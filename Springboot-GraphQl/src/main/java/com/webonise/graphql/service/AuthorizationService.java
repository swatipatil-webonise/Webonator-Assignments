package com.webonise.graphql.service;

public interface AuthorizationService {
	
	/**
	 * This method validates authKey.
	 * @param authKey
	 */
	void validateAuthKey(String authKey);
}
