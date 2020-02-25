package com.webonise.jwtsecurity.security;

import com.webonise.jwtsecurity.model.JwtAuthenticationToken;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 * @author webonise on 24/02/20
 * @project jwt-security
 */
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    private static final int TOKEN_START_STR_LEN = 6;

    private static final String TOKEN_START_STR = "Token ";

    private static final String TOKEN_HEADER_KEY = "Authorization";

    private static final String FILTER_URL_PATTERN = "/say-hello/**";

    public JwtAuthenticationTokenFilter() {
        super(FILTER_URL_PATTERN);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws AuthenticationException{
        String header = httpServletRequest.getHeader(TOKEN_HEADER_KEY);
        if (!Optional.ofNullable(header).isPresent() || !header.startsWith(TOKEN_START_STR)) {
            throw new RuntimeException("JWT Token is missing");
        }
        String authenticationToken = header.substring(TOKEN_START_STR_LEN);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
