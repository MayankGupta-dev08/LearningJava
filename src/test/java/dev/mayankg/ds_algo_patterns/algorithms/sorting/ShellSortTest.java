package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShellSortTest {

    private Integer[] integerArray;
    private String[] stringArray;
    private Student[] studentArray;

    @BeforeEach
    void setUp() {
        integerArray = new Integer[]{23, 29, 15, 19, 31, 7, 9, 5, 2};
        stringArray = new String[]{"Mayank", "Ankit", "Rahul", "Amit", "Rohit", "Sachin"};
        studentArray = new Student[]{
                new Student(101, "Mayank", "Gupta", "mayank@gmail.com"),
                new Student(102, "Ankit", "Kumar", "ankit.kr@gmail.com"),
                new Student(103, "Rahul", "Singh", "signh.rahul@gmail.com"),
                new Student(104, "Amit", "Sharma", "amit.sh@gmail.com"),
                new Student(106, "Sachin", "Gupta", "saching@gmail.com"),
                new Student(105, "Rohit", "Kumar", "kr.rohit@gmail.com")
        };
    }

    @Test
    void sortIntegerArray() {
        ShellSort.sort(integerArray);
        assertArrayEquals(new Integer[]{2, 5, 7, 9, 15, 19, 23, 29, 31}, integerArray);
        SortingUtil.printArray(integerArray);
    }

    @Test
    void sortStringArray() {
        ShellSort.sort(stringArray);
        assertArrayEquals(new String[]{"Amit", "Ankit", "Mayank", "Rahul", "Rohit", "Sachin"}, stringArray);
        SortingUtil.printArray(stringArray);
    }

    @Test
    void sortStudentArray() {
        ShellSort.sort(studentArray);
        assertArrayEquals(new Student[]{
                new Student(104, "Amit", "Sharma", "amit.sh@gmail.com"),
                new Student(102, "Ankit", "Kumar", "ankit.kr@gmail.com"),
                new Student(101, "Mayank", "Gupta", "mayank@gmail.com"),
                new Student(103, "Rahul", "Singh", "signh.rahul@gmail.com"),
                new Student(105, "Rohit", "Kumar", "kr.rohit@gmail.com"),
                new Student(106, "Sachin", "Gupta", "saching@gmail.com")
        }, studentArray);
        SortingUtil.printArray(studentArray);
    }
}