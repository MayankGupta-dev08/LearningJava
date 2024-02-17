package dev.mayankg.design.patterns.creational.factory.example2;

/**
 * Concrete Product1
 */
class JsonMessage extends Message {
    JsonMessage() {
        this.setContent();
    }

    @Override
    public void setContent() {
        this.content = "{\"name\": \"John\", \"age\": 30, \"address\": \"123 Main Street, City, Country\"}";
    }
}