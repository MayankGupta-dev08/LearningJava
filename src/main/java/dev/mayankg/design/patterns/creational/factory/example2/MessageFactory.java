package dev.mayankg.design.patterns.creational.factory.example2;

/**Abstract Factory*/
abstract class MessageFactory {

    public Message getMessage(){
        Message message = createMessage();
        message.addDefaultHeader();
        message.encryptContent();
        return message;
    }

    // abstract method of Factory
    public abstract Message createMessage();
}