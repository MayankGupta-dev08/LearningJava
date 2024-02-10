package dev.mayankg.design.principles.solid.SRP.orginal;

//User entity
public class User {
    private String name;
    private String email;
    private String address;

    public User() {}

    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{name='%s', email='%s', address='%s'}".formatted(name, email, address);
    }
}