package dev.mayankg.design.patterns.creational.abstractfactory.example.aws;

import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Instance;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.ResourceFactory;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Storage;

/**
 * Concrete ProductFactoryA
 */
public class AWSResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new EC2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}