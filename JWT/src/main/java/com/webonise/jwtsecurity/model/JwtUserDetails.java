package com.webonise.jwtsecurity.model;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author webonise on 24/02/20
 * @project jwt-security
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JwtUserDetails implements UserDetails {

    private String userName;
    private Long id;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;
    private static final boolean DEFAULT_VALUE_FOR_BOOLEAN_ELEMENTS = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return DEFAULT_VALUE_FOR_BOOLEAN_ELEMENTS;
    }

    @Override
    public boolean isAccountNonLocked() {
        return DEFAULT_VALUE_FOR_BOOLEAN_ELEMENTS;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return DEFAULT_VALUE_FOR_BOOLEAN_ELEMENTS;
    }

    @Override
    public boolean isEnabled() {
        return DEFAULT_VALUE_FOR_BOOLEAN_ELEMENTS;
    }
}
