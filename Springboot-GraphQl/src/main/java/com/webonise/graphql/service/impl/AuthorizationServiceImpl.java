package com.webonise.graphql.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.webonise.graphql.exception.UnauthorizedRequestFoundException;
import com.webonise.graphql.service.AuthorizationService;

@Component
public class AuthorizationServiceImpl implements AuthorizationService {
	
	private static Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);
	
	@Value("${app.validate.token.url}")
	private String VALIDATE_TOKEN_URL;
	
	@Value("200")
	private int SUCCESS_CODE;
	
	public void validateAuthKey(String authKey) {
		if (new RestTemplate().postForEntity(VALIDATE_TOKEN_URL, authKey, String.class).getStatusCodeValue() != SUCCESS_CODE) {
			log.error("Invalid token found");
			throw new UnauthorizedRequestFoundException(401, "Invalid Token found.");
		}
	}
}
