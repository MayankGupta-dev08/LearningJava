package dev.mayankg.design.patterns.creational.factory.example2;

class Client {
    public static void main(String[] args) {
        //JSON
        Message msg1 = fetchMessage(new JsonMessageFactory());
        System.out.println(msg1.getContent());
        printDecryptedMessage(msg1);

        //TEXT
        Message msg2 = fetchMessage(new TextMessageFactory());
        System.out.println(msg2.getContent());
        printDecryptedMessage(msg2);
    }

    private static Message fetchMessage(MessageFactory messageFactory) {
        return messageFactory.getMessage();
    }

    private static void printDecryptedMessage(Message message) {
        message.decryptContent();
        System.out.println(message.getContent());
    }
}