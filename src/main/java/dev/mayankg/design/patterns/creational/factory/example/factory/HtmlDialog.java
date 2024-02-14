package dev.mayankg.design.patterns.creational.factory.example.factory;

import dev.mayankg.design.patterns.creational.factory.example.buttons.Button;
import dev.mayankg.design.patterns.creational.factory.example.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}