package com.webonise.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.webonise.graphql.entity.Vehicle;
import com.webonise.graphql.service.VehicleService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

	@Autowired
	private VehicleService vehicleService;

	public List<Vehicle> getVehicles(int count, DataFetchingEnvironment environment) {
		return vehicleService.getVehicles(count, environment );		
	}

	public Vehicle getVehicle(int id, DataFetchingEnvironment environment) {
		return vehicleService.getVehicle(id, environment);
	}
}
