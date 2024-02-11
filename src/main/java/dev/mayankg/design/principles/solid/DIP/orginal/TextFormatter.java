package dev.mayankg.design.principles.solid.DIP.orginal;

//Formats Message to plain text
class TextFormatter implements Formatter {

    public String format(Message message) {
        return message.getTimestamp() + ":" + message.getMsg();
    }
}