package dev.mayankg.design.patterns.creational.factory.example2;

/**
 * Concrete Factory2
 */
class TextMessageFactory extends MessageFactory {
    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}