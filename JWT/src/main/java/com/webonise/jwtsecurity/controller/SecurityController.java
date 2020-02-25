package com.webonise.jwtsecurity.controller;

import com.webonise.jwtsecurity.model.JwtUser;
import com.webonise.jwtsecurity.security.JwtGeneratorAndValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author webonise on 24/02/20
 * @project jwt-security
 */
@RestController
public class SecurityController {

    @Autowired
    private JwtGeneratorAndValidator jwtGenerator;

    @PostMapping("/get-token")
    public String generate(@RequestBody final JwtUser jwtUser) {
        return jwtGenerator.generate(jwtUser);
    }
}
