package dev.mayankg.design.patterns.creational.abstractfactory.example.aws;

import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Storage;

/**
 * Concrete Product2A
 */
class S3Storage implements Storage {
    public S3Storage(int capacityInMib) {
        //Use AWS S3 api
        System.out.println("Allocated " + capacityInMib + " on S3");
    }

    @Override
    public String getId() {
        return Storage.generateRandomUUID();
    }

    @Override
    public String toString() {
        return "S3 Storage";
    }
}