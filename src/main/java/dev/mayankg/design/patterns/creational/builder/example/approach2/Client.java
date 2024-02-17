package dev.mayankg.design.patterns.creational.builder.example.approach2;

import dev.mayankg.design.patterns.creational.builder.example.common.User;
import dev.mayankg.design.patterns.creational.builder.example.common.UserUtil;

class Client {
    public static void main(String[] args) {
        User user = UserUtil.createUser();
        //Client has to provide the director with the concrete builder which returns the product
        UserRestDTO dto = directBuild(user);
        System.out.println(dto);
    }

    private static UserRestDTO directBuild(User user) {
        UserRestDTO restDTO = UserRestDTO.getBuilderInstance()
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withBirthday(user.getBirthDay())
                .withAddress(user.getAddress())
                .build();
        return restDTO;
    }
}