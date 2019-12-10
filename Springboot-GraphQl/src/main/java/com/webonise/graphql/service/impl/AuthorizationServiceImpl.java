package com.webonise.graphql.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.webonise.graphql.exception.UnauthorizedRequestFoundException;
import com.webonise.graphql.service.AuthorizationService;

@Component
public class AuthorizationServiceImpl implements AuthorizationService {
	
	private static Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);
	
	public void validateAuthKey(String authKey) {
		final String validate_token_url = "http://localhost:8080/validate-token";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> status = restTemplate.postForEntity(validate_token_url, authKey, String.class);
		if (status.getStatusCodeValue() != 200) {
			log.error("Invalid token found");
			throw new UnauthorizedRequestFoundException(401, "Invalid Token found.");
		}
	}
}
