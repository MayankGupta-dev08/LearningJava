package dev.mayankg.experimentNlearn;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


/**
 * KeyGenerator for encryption/decryption process
 */
public class KeyGeneration {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Generate a key using AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256, new SecureRandom());
        SecretKey secretKey = keyGen.generateKey();

        // Print the key in base64 encoding
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Generated Key: " + encodedKey);
    }
}