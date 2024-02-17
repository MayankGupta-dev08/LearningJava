package dev.mayankg.design.patterns.creational.builder.example.approach1;

import dev.mayankg.design.patterns.creational.builder.example.common.Address;
import dev.mayankg.design.patterns.creational.builder.example.common.UserDTO;
import dev.mayankg.design.patterns.creational.builder.example.common.UserDTOBuilder;

import java.time.LocalDate;
import java.time.Period;

/**
 * Concrete Builder
 */
class UserWebDTOBuilder implements UserDTOBuilder {
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private UserWebDTO userWebDTO;

    @Override
    public UserDTOBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserDTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserDTOBuilder withBirthday(LocalDate birthday) {
        Period userAge = Period.between(birthday, LocalDate.now());
        this.age = Integer.toString(userAge.getYears());
        return this;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        this.address = address.toString();
        return this;
    }

    @Override
    public UserDTO build() {
        userWebDTO = new UserWebDTO(firstName + " " + lastName, age, address);
        return userWebDTO;
    }

    @Override
    public UserDTO getUserDTO() {
        return userWebDTO;
    }
}