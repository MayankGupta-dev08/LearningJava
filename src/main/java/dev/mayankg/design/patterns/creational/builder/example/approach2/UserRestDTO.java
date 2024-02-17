package dev.mayankg.design.patterns.creational.builder.example.approach2;

import dev.mayankg.design.patterns.creational.builder.example.common.Address;
import dev.mayankg.design.patterns.creational.builder.example.common.UserDTO;
import dev.mayankg.design.patterns.creational.builder.example.common.UserDTOBuilder;

import java.time.LocalDate;
import java.time.Period;

/**
 * Concrete Product
 */
// private -> members, setters | public -> getters | No param constructor
class UserRestDTO implements UserDTO {
    private String name;
    private String age;
    private String address;

    // Needed if the builder class is private or package-private
    public static UserRestDTOBuilder getBuilderInstance() {
        return new UserRestDTOBuilder();
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    @Override
    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ("Name: %s" +
                "%n" +
                "Age: %s" +
                "%n" +
                "Address: %s").formatted(name, age, address);
    }

    /**
     * Concrete Builder
     */
    // inner static builder --> able to use the private setters of concrete product class
    static class UserRestDTOBuilder implements UserDTOBuilder {
        private String firstName;
        private String lastName;
        private String age;
        private String address;
        private UserRestDTO userDTO;

        @Override
        public UserRestDTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public UserRestDTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public UserRestDTOBuilder withBirthday(LocalDate birthday) {
            this.age = Integer.toString(Period.between(birthday, LocalDate.now()).getYears());
            return this;
        }

        @Override
        public UserRestDTOBuilder withAddress(Address address) {
            this.address = address.toString();
            return this;
        }

        @Override
        public UserRestDTO build() {
            this.userDTO = new UserRestDTO();
            this.userDTO.setName(firstName + " " + lastName);
            this.userDTO.setAge(age);
            this.userDTO.setAddress(address);
            return userDTO;
        }

        @Override
        public UserRestDTO getUserDTO() {
            return userDTO;
        }
    }
}