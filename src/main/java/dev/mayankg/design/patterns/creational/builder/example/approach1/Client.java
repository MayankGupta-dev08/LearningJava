package dev.mayankg.design.patterns.creational.builder.example.approach1;

import dev.mayankg.design.patterns.creational.builder.example.common.User;
import dev.mayankg.design.patterns.creational.builder.example.common.UserDTO;
import dev.mayankg.design.patterns.creational.builder.example.common.UserDTOBuilder;
import dev.mayankg.design.patterns.creational.builder.example.common.UserUtil;

class Client {
    public static void main(String[] args) {
        User user = UserUtil.createUser();
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
}