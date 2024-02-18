package dev.mayankg.design.patterns.creational.abstractfactory.example.gcp;

import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Instance;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Storage;

/**
 * Concrete Product1B
 */
class GCEInstance implements Instance {
    public GCEInstance(Capacity capacity) {
        //Map capacity to GCE instance types. Use GCP API to provision
        System.out.println("Created GCEInstance");
    }

    @Override
    public void start() {
        System.out.println("GCEInstance started");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attached " + storage + " to GCEInstance");
    }

    @Override
    public void stop() {
        System.out.println("GCEInstance stopped");
    }

    @Override
    public String toString() {
        return "GCEInstance";
    }
}