package com.webonise.graphql.service.impl;

import com.webonise.graphql.entity.Vehicle;
import com.webonise.graphql.exception.EmptyFoundException;
import com.webonise.graphql.exception.FailedToUpdateDatabseException;
import com.webonise.graphql.exception.NotFoundException;
import com.webonise.graphql.exception.UnauthorizedRequestFoundException;
import com.webonise.graphql.repository.VehicleRedisRepository;
import com.webonise.graphql.repository.VehicleRepository;
import com.webonise.graphql.service.AuthorizationService;
import com.webonise.graphql.service.VehicleService;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleRedisRepository vehicleRedisRepository;

	@Autowired
	private AuthorizationService authorizationService;

	@Value("${app.authentication.key}")
	private String APP_AUTH_KEY;
	
	private final Long RECORD_DELETED = 1L, RECORD_NOT_UPDATED = 0L;

	private Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);

	@Override
	public Vehicle createVehicle(String type, String modelCode, String brandName, DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		Vehicle vehicle = vehicleRepository.save(new Vehicle(type, modelCode, brandName));
		if (Optional.ofNullable(vehicle).isPresent()) {
			flushAndUpdateRedisCache();
			return vehicle;
		} else {
			log.error("Failed to execute save operation of object {} on database.", vehicle);
			throw new FailedToUpdateDatabseException(304, "Failed to update database.");
		}
	}

	@Override
	public long deleteVehicle(int id, DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		if (vehicleRepository.deleteVehicleById(id) == RECORD_DELETED) {
			flushAndUpdateRedisCache();
			return RECORD_DELETED;
		} else {
			log.error("Vehicle with id {} not found.", id);
			throw new NotFoundException(404, "Vehicle not found.");
		}
	}

	@Override
	public Vehicle updateVehicle(int id, String type, String modelCode, String brandName,
			DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
		if (Optional.ofNullable(vehicle).isPresent()) {
			vehicle.setType(type);
			vehicle.setModelCode(modelCode);
			vehicle.setBrandName(brandName);
			vehicle = vehicleRepository.save(new Vehicle(type, modelCode, brandName));
			flushAndUpdateRedisCache();
			return vehicle;
		} else {
			vehicle = vehicleRepository.save(new Vehicle(type, modelCode, brandName));
			if (Optional.ofNullable(vehicle).isPresent()) {
				flushAndUpdateRedisCache();
				return vehicle;
			} else {
				log.error("Failed to execute save operation of object {} on database.", vehicle);
				throw new FailedToUpdateDatabseException(304, "Failed to update database.");
			}
		}
	}

	@Override
	public List<Vehicle> getVehicles(int count, DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		List<Vehicle> vehicles = vehicleRedisRepository.findAll().stream().sorted(new Comparator<Vehicle>() {

			@Override
			public int compare(Vehicle vehicle1, Vehicle vehicle2) {
				if (vehicle1.getId() < vehicle2.getId()) {
					return -1;
				} else if (vehicle1.getId() > vehicle2.getId()) {
					return 1;
				} else {
					return 0;
				}
			}
		}).limit(count).collect(Collectors.toList());
		if (Optional.of(vehicles).isPresent()) {
			return vehicles;
		} else {
			log.error("Empty vehicle list found.");
			throw new EmptyFoundException(204, "Empty vehicle list found.");
		}
	}

	@Cacheable(value = "vehicle")
	public Vehicle vehicle(int id) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return vehicleRepository.findById(id).orElse(null);
	}

	@Override
	public Vehicle getVehicle(int id, DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		return vehicleRedisRepository.get(id);
	}

	@Override
	public void verifyAuthKey(DataFetchingEnvironment environment) {
		final String AUTH_KEY = ((GraphQLContext) environment.getContext()).getHttpServletRequest().get()
				.getHeader("Auth-Key");
		if (AUTH_KEY == null) {
			log.error("Authentication token not found.");
			throw new UnauthorizedRequestFoundException(401, "Unauthorized request found.");
		} else {
			authorizationService.validateAuthKey(AUTH_KEY);
		}
	}

	@Override
	public void flushRedisCache() {
		List<Vehicle> vehicles = vehicleRedisRepository.findAll();
		for (Vehicle vehicle : vehicles) {
			vehicleRedisRepository.delete(vehicle.getId());
		}
	}

	@Override
	public void updateRedisCache() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		if (Optional.ofNullable(vehicles).isPresent()) {
			for (Vehicle vehicle : vehicles) {
				vehicleRedisRepository.save(vehicle);
			}
		} else {
			log.error("Empty vehicle list found.");
			throw new EmptyFoundException(204, "Empty vehicle list found.");
		}
	}

	@Override
	public void flushAndUpdateRedisCache() {
		flushRedisCache();
		updateRedisCache();
	}
}
