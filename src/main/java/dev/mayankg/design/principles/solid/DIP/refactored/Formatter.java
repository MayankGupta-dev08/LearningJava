package dev.mayankg.design.principles.solid.DIP.refactored;

//Common interface for classes formatting Message object
interface Formatter {

    public String format(Message message) throws FormatException;
}