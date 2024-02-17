package dev.mayankg.design.patterns.creational.factory.example2;

/**
 * Concrete Factory1
 */
class JsonMessageFactory extends MessageFactory {
    @Override
    public Message createMessage() {
        return new JsonMessage();
    }
}