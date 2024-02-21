package dev.mayankg.design.patterns.structural.decorator.example;

/**
 * Concrete component. Object to be decorated
 */
class TextMessage implements Message {
    private String msg;

    public TextMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public String getContent() {
        return msg;
    }
}