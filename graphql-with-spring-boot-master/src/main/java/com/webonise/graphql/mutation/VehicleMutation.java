package com.webonise.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.webonise.graphql.entity.Vehicle;
import com.webonise.graphql.service.VehicleService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

    public Vehicle createVehicle(String type, String modelCode, String brandName, DataFetchingEnvironment environment) {
    	return vehicleService.createVehicle(type, modelCode, brandName, environment);
    }	
    
    public int deleteVehicle(int id, DataFetchingEnvironment environment) {
    	return vehicleService.deleteVehicle(id, environment);
    }
    
    public Vehicle updateVehicle(int id, String type,String modelCode, String brandName, DataFetchingEnvironment environment) {
    	return vehicleService.updateVehicle(id, type, modelCode, brandName, environment);
    }
}
