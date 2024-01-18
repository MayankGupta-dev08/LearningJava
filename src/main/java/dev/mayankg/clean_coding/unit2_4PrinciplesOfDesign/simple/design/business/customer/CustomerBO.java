package dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.customer;

import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.exception.DifferentCurrenciesException;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer.Amount;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer.Product;

import java.util.List;

public interface CustomerBO {
    /**
     * Method for calculating the sum of all the products
     */
    Amount getCustomerProductsSum(List<Product> products) throws DifferentCurrenciesException;
}