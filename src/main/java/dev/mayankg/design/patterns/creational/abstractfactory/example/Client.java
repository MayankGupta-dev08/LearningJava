package dev.mayankg.design.patterns.creational.abstractfactory.example;

import dev.mayankg.design.patterns.creational.abstractfactory.example.aws.AWSResourceFactory;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Instance;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.ResourceFactory;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Storage;
import dev.mayankg.design.patterns.creational.abstractfactory.example.gcp.GCPResourceFactory;

class Client {
    private ResourceFactory resourceFactory;

    public Client(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
    }

    public static void main(String[] args) {
        performClientOperation(new AWSResourceFactory());
        System.out.println("------------------------------------------");
        performClientOperation(new GCPResourceFactory());
    }

    private static void performClientOperation(ResourceFactory resourceFactory) {
        Client cloudPlatform = new Client(resourceFactory);
        Instance server = cloudPlatform.createServer(Instance.Capacity.micro, 20480);
        server.start();
        server.stop();
    }

    public Instance createServer(Instance.Capacity capacity, int storageMib) {
        Instance instance = this.resourceFactory.createInstance(capacity);
        Storage storage = this.resourceFactory.createStorage(storageMib);
        instance.attachStorage(storage);
        return instance;
    }
}