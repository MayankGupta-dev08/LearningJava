package dev.mayankg.clean_coding.unit2.simple.design.business.customer;

import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.customer.CustomerBO;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.customer.CustomerBOImpl;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.exception.DifferentCurrenciesException;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CustomerBORefactoredTest {
    private CustomerBO customerBO = new CustomerBOImpl();

    @Test
    void testCustomerProductSum_TwoProductsOfSameCurrencies() throws DifferentCurrenciesException {
        //setup
        Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
                new AmountImpl(new BigDecimal("6.0"), Currency.EURO)};
        List<Product> products = createProductsWithAmount(amounts);

        //method invocation
        Amount actualSum = customerBO.getCustomerProductsSum(products);

        //assertion
        Amount expectedSum = new AmountImpl(new BigDecimal("11.0"), Currency.EURO);
        assertCurrency(expectedSum, actualSum);
    }

    @Test
    void testCustomerProductSum_TwoProductsOfDifferentCurrencies() {
        Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
                new AmountImpl(new BigDecimal("6.0"), Currency.INDIAN_RUPEE)};
        List<Product> products = createProductsWithAmount(amounts);


        DifferentCurrenciesException exception = assertThrows(DifferentCurrenciesException.class, () -> {
            customerBO.getCustomerProductsSum(products);
        });

        // Optionally, you can assert details about the exception
        assertNotNull(exception.getMessage());
    }


    @Test
    void testCustomerProductSum_WithNoProducts() throws DifferentCurrenciesException{
        Amount[] amounts = {};
        List<Product> products = createProductsWithAmount(amounts);

        Amount actualSum = customerBO.getCustomerProductsSum(products);

        Amount expectedSum = new AmountImpl(BigDecimal.ZERO, Currency.EURO);
        assertCurrency(expectedSum, actualSum);
    }

    private void assertCurrency(Amount expectedSum, Amount actualSum) {
        assertEquals(expectedSum.getValue(), actualSum.getValue());
        assertEquals(expectedSum.getCurrency(), actualSum.getCurrency());
    }

    private List<Product> createProductsWithAmount(Amount[] amounts) {
        return Arrays.stream(amounts)
                .map(amount -> new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE, amount))
                .collect(Collectors.toList());
    }
}