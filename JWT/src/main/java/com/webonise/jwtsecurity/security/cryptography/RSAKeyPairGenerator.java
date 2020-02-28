package com.webonise.jwtsecurity.security.cryptography;

/**
 * @author webonise on 28/02/20
 * @project JWT
 */

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAKeyPairGenerator {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2560);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public String getRSABase64EncodedPublicKey() {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public String getRSABase64EncodedPrivateKey() {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }
}
