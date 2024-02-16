package dev.mayankg.design.patterns.creational.factory.example1.factory;

import dev.mayankg.design.patterns.creational.factory.example1.buttons.Button;
import dev.mayankg.design.patterns.creational.factory.example1.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}