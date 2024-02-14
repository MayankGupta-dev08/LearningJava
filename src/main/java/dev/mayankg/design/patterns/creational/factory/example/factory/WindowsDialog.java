package dev.mayankg.design.patterns.creational.factory.example.factory;

import dev.mayankg.design.patterns.creational.factory.example.buttons.Button;
import dev.mayankg.design.patterns.creational.factory.example.buttons.WindowsButton;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}