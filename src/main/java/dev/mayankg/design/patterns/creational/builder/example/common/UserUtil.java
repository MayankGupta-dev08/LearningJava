package dev.mayankg.design.patterns.creational.builder.example.common;

import java.time.LocalDate;

public class UserUtil {
    /**
     * @Returns a sample user.
     */
    public static User createUser() {
        User user = new User();
        user.setBirthDay(LocalDate.of(1960, 5, 6));
        user.setFirstName("Ron");
        user.setLastName("Swanson");
        Address address = new Address();
        address.setHouseNo("100");
        address.setStreet("State Street");
        address.setCity("Pawnee");
        address.setState("Indiana");
        address.setZipcode("47998");
        user.setAddress(address);
        return user;
    }
}