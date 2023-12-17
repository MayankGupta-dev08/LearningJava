package dev.mayankg.generics;

import java.util.Comparator;

public class User implements Comparable<User> {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailId='" + emailId + '\'' +
                '}';
    }

    @Override
    public int compareTo(User that) {
        return this.name.compareTo(that.name);
    }
}

/**
 * We need to use Java Comparator interface because Comparable.compareTo(Object o) method implementation can provide default sorting & we can’t change it dynamically.
 * Whereas with Comparator, we can define multiple methods with different ways of sorting and then chose the sorting method based on our requirements.
 */
class EmailComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getEmailId().compareTo(o2.getEmailId());
    }
};

class AgeComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge();
    }
};