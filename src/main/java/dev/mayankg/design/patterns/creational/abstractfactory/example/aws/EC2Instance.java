package dev.mayankg.design.patterns.creational.abstractfactory.example.aws;

import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Instance;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Storage;

/**
 * Concrete Product1A
 */
class EC2Instance implements Instance {
    public EC2Instance(Capacity capacity) {
        //Map capacity to EC2 instance types. Use AWS API to provision
        System.out.println("Created EC2Instance");
    }

    @Override
    public void start() {
        System.out.println("EC2Instance started");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attached " + storage + " to EC2Instance");
    }

    @Override
    public void stop() {
        System.out.println("EC2Instance stopped");
    }

    @Override
    public String toString() {
        return "EC2Instance";
    }
}