package dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer;

/**
 * Collateral Model API.
 */
public interface Collateral {

    long getId();

    String getName();

    CollateralType getType();
}