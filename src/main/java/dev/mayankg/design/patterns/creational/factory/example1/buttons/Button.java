package dev.mayankg.design.patterns.creational.factory.example1.buttons;

/**
 * Common interface for all buttons.
 */
// Product
public interface Button {
    void render();
    void onClick();
}