package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import java.util.Comparator;
import java.util.Objects;

class Student implements Comparable<Student> {
    private int rollNo;
    private String firstName;
    private String lastName;
    private String email;

    public static final Comparator<Student> BY_ROLL_NO = new ByRollNo();
    public static final Comparator<Student> BY_EMAIL = new ByEmail();

    public Student(int rollNo, String firstName, String lastName, String email) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "[%d, %s, %s, %s]".formatted(rollNo, firstName, lastName, email);
    }

    @Override
    public int compareTo(Student that) {
        return this.firstName.compareTo(that.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                email.equals(student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, firstName, lastName, email);
    }

    private static class ByRollNo implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.rollNo - o2.rollNo;
        }
    }

    private static class ByEmail implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.email.compareTo(o2.email);
        }
    }
}
