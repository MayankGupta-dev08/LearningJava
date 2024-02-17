package dev.mayankg.design.patterns.creational.factory.example2;

/**
 * Concrete Product2
 */
class TextMessage extends Message {
    TextMessage() {
        this.setContent();
    }

    @Override
    public void setContent() {
        this.content = "Name: John\nAge: 30\nAddress: 123 Main Street, City, Country";
    }
}