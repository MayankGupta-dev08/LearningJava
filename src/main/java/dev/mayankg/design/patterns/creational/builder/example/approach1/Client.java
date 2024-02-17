package dev.mayankg.design.patterns.creational.builder.example.approach1;

import dev.mayankg.design.patterns.creational.builder.example.common.Address;
import dev.mayankg.design.patterns.creational.builder.example.common.User;
import dev.mayankg.design.patterns.creational.builder.example.common.UserDTO;
import dev.mayankg.design.patterns.creational.builder.example.common.UserDTOBuilder;

import java.time.LocalDate;

class Client {
    public static void main(String[] args) {
        User user = createUser();
        UserWebDTOBuilder userWebDTOBuilder = new UserWebDTOBuilder();
        UserDTO userDTO = directBuild(userWebDTOBuilder, user);
        System.out.println(userDTO);
    }

    /**
     * Director
     */
    private static UserDTO directBuild(UserDTOBuilder userDTOBuilder, User user) {
        return userDTOBuilder
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withBirthday(user.getBirthDay())
                .withAddress(user.getAddress())
                .build();
    }

    /**
     * @Returns a sample user.
     */
    static User createUser() {
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