package com.webonise.jwtsecurity.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author webonise on 24/02/20
 * @project jwt-security
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;

    private static final String DEFAULT_VALUE = null;

    public JwtAuthenticationToken(String token) {
        super(DEFAULT_VALUE, DEFAULT_VALUE);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return DEFAULT_VALUE;
    }

    @Override
    public Object getPrincipal() {
        return DEFAULT_VALUE;
    }
}
