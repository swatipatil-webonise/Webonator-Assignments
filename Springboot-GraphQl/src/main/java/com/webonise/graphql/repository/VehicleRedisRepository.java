package com.webonise.graphql.repository;

import java.util.List;
import com.webonise.graphql.entity.Vehicle;

public interface VehicleRedisRepository {
	
	/**
	 * This method will return all the record from redis-cache.
	 * @return List<Vehicle>
	 */
	public List<Vehicle> findAll();

	/**
	 * This method will put the given vehicle into redis-cache.
	 * @param user
	 */
	public boolean save(Vehicle vehicle);

	/**
	 * This method will delete vehicle with given id from redis-cache.
	 * @param id
	 * @return Long
	 */
	public Long delete(int id);
	
	/**
	 * This method will return the vehicle from redis-cache.
	 * @param id
	 * @return Vehicle
	 */
	public Vehicle get(int id);
}
