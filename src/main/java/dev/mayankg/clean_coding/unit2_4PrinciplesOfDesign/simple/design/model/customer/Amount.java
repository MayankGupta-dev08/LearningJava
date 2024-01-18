package dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.model.customer;

import java.math.BigDecimal;

public interface Amount {
	BigDecimal getValue();

	Currency getCurrency();
}