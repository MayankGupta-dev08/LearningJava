package dev.mayankg.design.patterns.creational.builder.example.common;

import java.time.LocalDate;

/**
 * Abstract Builder
 */
public interface UserDTOBuilder {

    // Methods to build the product
    UserDTOBuilder withFirstName(String firstName);
    UserDTOBuilder withLastName(String lastName);
    UserDTOBuilder withBirthday(LocalDate birthday);
    UserDTOBuilder withAddress(Address address);

    // Method to assemble the final product
    UserDTO build();

    // Optional Method to fetch the final product
    UserDTO getUserDTO();
}