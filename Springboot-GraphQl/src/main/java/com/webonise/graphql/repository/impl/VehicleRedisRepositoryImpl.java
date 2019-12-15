package com.webonise.graphql.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import com.webonise.graphql.entity.Vehicle;
import com.webonise.graphql.repository.VehicleRedisRepository;

public class VehicleRedisRepositoryImpl implements VehicleRedisRepository {
	
	private String OBJECT_KEY = "VEHICLE-1";

	private RedisTemplate<Integer, Vehicle> redisTemplate;

	private HashOperations hashOperations;

	private Logger log = LoggerFactory.getLogger(VehicleRedisRepositoryImpl.class);

	private final Long VEHICLE_DELETED = 1l, VEHICLE_NOT_DELETED = 0l;

	public VehicleRedisRepositoryImpl(RedisTemplate<Integer, Vehicle> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public List<Vehicle> findAll() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>(hashOperations.entries(OBJECT_KEY).values());
		if (Optional.ofNullable(vehicles).isPresent()) {
			return vehicles;
		} else {
			log.error("Empty redis cache found.");
			return vehicles;
		}
	}

	@Override
	public boolean save(Vehicle vehicle) {
		return hashOperations.putIfAbsent(OBJECT_KEY, vehicle.getId(), vehicle);
	}

	@Override
	public Long delete(int id) {
		if (hashOperations.delete(OBJECT_KEY, id) == VEHICLE_DELETED) {
			return VEHICLE_DELETED;
		} else {
			log.error("User with given id {} not found.", id);
			return VEHICLE_NOT_DELETED;
		}
	}

	@Override
	public Vehicle get(int id) {
		return (Vehicle) hashOperations.get(OBJECT_KEY, id);
	}
}
