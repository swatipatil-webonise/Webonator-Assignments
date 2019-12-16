package com.webonise.graphql.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class UpdateRedisException extends RuntimeException implements GraphQLError {
	
	private static final long serialVersionUID = 1L;
	private final int errorCode;
	private final String errorMessage;
	
	public UpdateRedisException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	@Override
	public Map<String, Object> getExtensions(){
		Map<String, Object> customAttributes = new LinkedHashMap<String, Object>();
		customAttributes.put("errorCode", this.errorCode);
		customAttributes.put("errorMessage", this.errorMessage);
		return customAttributes;
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return null;
	}
}
