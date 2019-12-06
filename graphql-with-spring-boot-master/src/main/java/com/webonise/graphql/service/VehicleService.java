package com.webonise.graphql.service;

import java.util.List;
import com.webonise.graphql.entity.Vehicle;
import graphql.schema.DataFetchingEnvironment;

public interface VehicleService {
	
	/**
	 * This method will create vehicle with given property values and will insert that into Vehicle table.
	 * @param type
	 * @param modelCode
	 * @param brandName
	 * @param environment
	 * @return Vehicle
	 */
	Vehicle createVehicle(String type, String modelCode, String brandName, DataFetchingEnvironment environment);
	
	/**
	 * This method will delete vehicle with given id from Vehicle table.
	 * @param id
	 * @param environment
	 * @return 1 If Deleted else 0
	 */
	int deleteVehicle(int id, DataFetchingEnvironment environment);
	
	/**
	 * This method will update vehicle with given id to given property values.
	 * @param id
	 * @param type
	 * @param modelCode
	 * @param brandName
	 * @param environment
	 * @return Vehicle
	 */
	Vehicle updateVehicle(int id, String type, String modelCode, String brandName, DataFetchingEnvironment environment);
	
	/**
	 * This method will retrieve list of vehicle from Vehicle table.
	 * @param count
	 * @param environment
	 * @return
	 */
	List<Vehicle> getVehicles(int count, DataFetchingEnvironment environment);
	
	/**
	 * This method will retrieve vehicle with given id from Vehicle table.
	 * @param id
	 * @param environment
	 * @return
	 */
	Vehicle getVehicle(int id, DataFetchingEnvironment environment);
	
	/**
	 * This method will verify whether given environment contains valid Auth-Key
	 * @param environment
	 */
	void verifyAuthKey(DataFetchingEnvironment environment);
}
