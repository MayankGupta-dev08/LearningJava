package dev.mayankg.generics;

class User implements Comparable<User> {
    private String name;
    private int age;
    private String emailId;

    public User(String name, int age, String emailId) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmailId() {
        return emailId;
    }

    @Override
    public String toString() {
        return "User{name='%s', age=%d, emailId='%s'}".formatted(getName(), getAge(), getEmailId());
    }

    @Override
    public int compareTo(User that) {
        return this.name.compareTo(that.name);
    }
}