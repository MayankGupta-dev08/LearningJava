package dev.mayankg.design.patterns.behavioural.mediator.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Mediator
 */
class UIMediator {

    List<UIControl> colleagues = new ArrayList<>();

    public void register(UIControl control) {
        colleagues.add(control);
    }

    public void valueChanged(UIControl control) {
        colleagues.stream().filter(c -> c != control).forEach(c -> c.controlChanged(control));
    }
}