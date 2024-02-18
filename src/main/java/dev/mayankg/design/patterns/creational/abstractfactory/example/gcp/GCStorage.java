package dev.mayankg.design.patterns.creational.abstractfactory.example.gcp;

import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Storage;

/**
 * Concrete Product2B
 */
class GCStorage implements Storage {
    public GCStorage(int capacityInMib) {
        //Use GCP GCS api
        System.out.println("Allocated " + capacityInMib + " on GCS");
    }

    @Override
    public String getId() {
        return Storage.generateRandomUUID();
    }

    @Override
    public String toString() {
        return "GC Storage";
    }
}