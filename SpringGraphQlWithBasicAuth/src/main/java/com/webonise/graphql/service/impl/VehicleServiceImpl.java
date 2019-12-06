package com.webonise.graphql.service.impl;

import com.webonise.graphql.entity.Vehicle;
import com.webonise.graphql.exception.EmptyFoundException;
import com.webonise.graphql.exception.NotFoundException;
import com.webonise.graphql.exception.UnauthorizedRequestFoundException;
import com.webonise.graphql.repository.VehicleRepository;
import com.webonise.graphql.service.VehicleService;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Value("${app.authentication.key}")
	private String APP_AUTH_KEY; 

	private Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);

	@Override
	public Vehicle createVehicle(String type, String modelCode, String brandName, DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		return vehicleRepository.save(new Vehicle(type, modelCode, brandName));
	}

	@Override
	public int deleteVehicle(int id, DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		if (vehicleRepository.existsById(id)) {
			return vehicleRepository.deleteVehicleById(id);
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
			return vehicleRepository.save(vehicle);
		} else {
			return vehicleRepository.save(new Vehicle(type, modelCode, brandName));
		}
	}

	@Override
	public List<Vehicle> getVehicles(int count, DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		List<Vehicle> vehicles = vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
		if (Optional.of(vehicles).isPresent()) {
			return vehicles;
		} else {
			log.error("Empty vehicle list found.");
			throw new EmptyFoundException(204, "Empty vehicle list found.");
		}
	}

	@Override
	public Vehicle getVehicle(int id, DataFetchingEnvironment environment) {
		verifyAuthKey(environment);
		if (vehicleRepository.existsById(id)) {
			return vehicleRepository.findById(id).orElse(null);
		} else {
			log.error("Vehicle with id {} not found.", id);
			throw new NotFoundException(404, "Vehicle not found.");
		}
	}

	@Override
	public void verifyAuthKey(DataFetchingEnvironment environment) {
		final String AUTH_KEY = ((GraphQLContext) environment.getContext()).getHttpServletRequest().get()
				.getHeader("Auth-Key");
		if (AUTH_KEY == null) {
			log.error("Authentication token not found.");
			throw new UnauthorizedRequestFoundException(401, "Unauthorized request found.");
		} else if (!(AUTH_KEY.equals(APP_AUTH_KEY))) {
			log.error("Unauthorized request found.");
			throw new UnauthorizedRequestFoundException(401, "Unauthorized request found.");
		}
	}
}
