package com.example.momospringboot.constant;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptCustom {
    public static String encryptSHA256HEX(String secret,String message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        System.out.println("=======Encrypt: "+message+"===========================");
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256Hmac.init(secretKey);

        byte[] hashedBytes = sha256Hmac.doFinal(message.getBytes(StandardCharsets.UTF_8));

        StringBuilder signature = new StringBuilder();
        for (byte b : hashedBytes) {
            signature.append(String.format("%02x", b));
        }
        return signature.toString();
    }
}
