package dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.customer;

import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.exception.DifferentCurrenciesException;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer.Amount;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer.AmountImpl;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer.Currency;
import dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer.Product;

import java.math.BigDecimal;
import java.util.List;


public class CustomerBOImpl implements CustomerBO {

    @Override
    public Amount getCustomerProductsSum(List<Product> products)
            throws DifferentCurrenciesException {
        BigDecimal temp = BigDecimal.ZERO;

        if (products.size() == 0)
            return new AmountImpl(temp, Currency.EURO);

        // Throw Exception If Any of the product has a currency different from
        // the first product
        Currency firstProductCurrency = products.get(0).getAmount()
                .getCurrency();

        for (Product product : products) {
            boolean currencySameAsFirstProduct = product.getAmount()
                    .getCurrency().equals(firstProductCurrency);
            if (!currencySameAsFirstProduct) {
                throw new DifferentCurrenciesException();
            }
        }

        // Calculate Sum of Products
        for (Product product : products) {
            temp = temp.add(product.getAmount().getValue());
        }

        // Create new product
        return new AmountImpl(temp, firstProductCurrency);
    }
}