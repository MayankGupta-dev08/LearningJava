package dev.mayankg.design.patterns.behavioural.mediator.example;

/**
 * Abstract colleague
 */
interface UIControl {

    void controlChanged(UIControl control);

    String getControlValue();

    String getControlName();
}