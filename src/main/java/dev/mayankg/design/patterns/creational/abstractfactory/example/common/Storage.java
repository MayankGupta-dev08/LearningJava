package dev.mayankg.design.patterns.creational.abstractfactory.example.common;

import java.util.Random;

/**
 * Abstract Product2
 */
public interface Storage {
    String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    String getId();

    static String generateRandomUUID() {
        Random random = new Random();
        StringBuilder uuid = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            uuid.append(randomChar);
        }

        return uuid.toString();
    }
}