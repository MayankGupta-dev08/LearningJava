package dev.mayankg.design.principles.solid.DIP.orginal;

import java.io.IOException;

//Thrown by formatter
class FormatException extends IOException {

    public FormatException(Exception cause) {
        super(cause);
    }
}