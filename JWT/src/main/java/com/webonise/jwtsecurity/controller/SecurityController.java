package com.webonise.jwtsecurity.controller;

import com.webonise.jwtsecurity.model.JwtUser;
import com.webonise.jwtsecurity.security.cryptography.RSAUtil;
import com.webonise.jwtsecurity.security.jwt.JwtGeneratorAndValidator;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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

    @Autowired
    private RSAUtil rsaUtil;

    @PostMapping("/get-token")
    public String generate(@RequestBody final JwtUser jwtUser)
            throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException {
        return Base64.getEncoder().encodeToString(rsaUtil.encrypt(jwtGenerator.generate(jwtUser)));
    }
}
