package dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.exception;

public class DifferentCurrenciesException extends Exception {
    private static final long serialVersionUID = 1L;

    public DifferentCurrenciesException(String message) {
        super(message);
    }
}