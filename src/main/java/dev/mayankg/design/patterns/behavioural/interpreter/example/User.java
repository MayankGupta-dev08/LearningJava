package dev.mayankg.design.patterns.behavioural.interpreter.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class User {

    private List<String> permissions;
    private String username;

    public User(String username, String... permissions) {
        this.username = username;
        this.permissions = new ArrayList<>();
        Stream.of(permissions).forEach(permission -> this.permissions.add(permission.toLowerCase()));
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public String getUsername() {
        return username;
    }
}