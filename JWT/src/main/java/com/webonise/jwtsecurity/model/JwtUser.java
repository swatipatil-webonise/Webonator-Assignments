package com.webonise.jwtsecurity.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author webonise on 24/02/20
 * @project jwt-security
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class JwtUser implements Serializable {

    private static final long serialVersionUID = -7443376555073535299L;
    private String userName;
    private String password;
    private long id;
    private String role;

    public JwtUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public JwtUser(String userName, long id, String role) {
        this.userName = userName;
        this.id = id;
        this.role = role;
    }
}
