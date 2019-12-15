package com.webonise.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webonise.graphql.entity.Vehicle;
import com.webonise.graphql.service.VehicleService;
import com.webonise.graphql.service.impl.VehicleServiceImpl;

@RestController
public class SecurityController {
	
	@Autowired
	private VehicleServiceImpl vehicleService;

	@PostMapping("/validate-token")
	public String validateToken(@RequestBody String token) {
		return "hello";
	}
	
	@GetMapping("/vehicle/{id}")
	public Vehicle vehicle(@PathVariable("id") int id) {
		return vehicleService.vehicle(id);
	}
}
