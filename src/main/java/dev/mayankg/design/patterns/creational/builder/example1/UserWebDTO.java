package dev.mayankg.design.patterns.creational.builder.example1;

/** Concrete Product*/
class UserWebDTO implements UserDTO {
    private String name;
    private String age;
    private String address;

    public UserWebDTO(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return ("Name: %s" +
                "%n" +
                "Age: %s" +
                "%n" +
                "Address: %s").formatted(name, age, address);

    }
}