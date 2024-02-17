package dev.mayankg.design.patterns.creational.factory.example2;

import java.util.Base64;

/**
 * Abstract Product
 */
abstract class Message {
    protected String content;

    public String getContent() {
        return content;
    }

    public abstract void setContent();

    public void addDefaultHeader() {
        // Has some code to add some default headers
    }

    public void encryptContent() {
        // Encrypt the content using Base64 encoding
        byte[] encryptedBytes = Base64.getEncoder().encode(content.getBytes());
        this.content = new String(encryptedBytes);
    }

    public void decryptContent() {
        // Decrypt the content using Base64 decoding
        byte[] decodedBytes = Base64.getDecoder().decode(content.getBytes());
        this.content = new String(decodedBytes);
    }
}