package dev.mayankg.design.patterns.creational.abstractfactory.example.gcp;

import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Instance;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.ResourceFactory;
import dev.mayankg.design.patterns.creational.abstractfactory.example.common.Storage;

/**
 * Concrete ProductFactoryB
 */
public class GCPResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GCEInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GCStorage(capMib);
    }
}