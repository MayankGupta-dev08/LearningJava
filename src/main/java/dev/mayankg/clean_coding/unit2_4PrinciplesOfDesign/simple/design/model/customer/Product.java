package dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer;

/**
 * Product Model API.
 */
public interface Product {

    long getId();

    String getName();

    ProductType getType();

    Amount getAmount();
}