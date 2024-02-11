package dev.mayankg.design.principles.solid.DIP.orginal;

import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
        Message msg = new Message("This is a message again");
        MessagePrinter printer = new MessagePrinter();
        printer.writeMessage(msg, "test_msg.txt");
    }
}