package com.webonise.jwtsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author webonise on 24/02/20
 * @project jwt-security
 */
@RestController
public class AppController {

    @GetMapping("/say-hello")
    public String hello() {
        return "Hello World";
    }
}
