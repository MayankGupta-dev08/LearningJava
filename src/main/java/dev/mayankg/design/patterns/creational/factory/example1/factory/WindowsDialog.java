package dev.mayankg.design.patterns.creational.factory.example1.factory;

import dev.mayankg.design.patterns.creational.factory.example1.buttons.Button;
import dev.mayankg.design.patterns.creational.factory.example1.buttons.WindowsButton;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}