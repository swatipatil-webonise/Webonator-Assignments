package com.webonise.jwtsecurity.security.cryptography;

/**
 * @author webonise on 28/02/20
 * @project JWT
 */
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RSAUtil {

    public String base64PublicKey;

    public String base64PrivateKey;

    private RSAKeyPairGenerator rsaKeyPairGenerator;

    @Value("${crypto.algorithm}")
    private String algorithm;

    @Value("${crypto.algorithm.padding}")
    private String padding;

    public RSAUtil() throws NoSuchAlgorithmException {
        rsaKeyPairGenerator = new RSAKeyPairGenerator();
        this.base64PublicKey = rsaKeyPairGenerator.getRSABase64EncodedPublicKey();
        this.base64PrivateKey = rsaKeyPairGenerator.getRSABase64EncodedPrivateKey();
    }

    public PublicKey getPublicKey(String base64PublicKey) {
        PublicKey base64PublicKeyWithX509Spec = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            base64PublicKeyWithX509Spec = keyFactory.generatePublic(new X509EncodedKeySpec(
                    Base64.getDecoder().decode(base64PublicKey.getBytes())));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return base64PublicKeyWithX509Spec;
    }

    public PrivateKey getPrivateKey(String base64PrivateKey) {
        PrivateKey base64PrivateKeyWithPKCS8Spec = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            base64PrivateKeyWithPKCS8Spec = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(
                    Base64.getDecoder().decode(base64PrivateKey.getBytes())));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return base64PrivateKeyWithPKCS8Spec;
    }

    public byte[] encrypt(String data)
            throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance(padding);
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(base64PublicKey));
        return cipher.doFinal(data.getBytes());
    }

    public String decrypt(String data)
            throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher = Cipher.getInstance(padding);
        cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(base64PrivateKey));
        return new String(cipher.doFinal(Base64.getDecoder().decode(data.getBytes())));
    }
}
