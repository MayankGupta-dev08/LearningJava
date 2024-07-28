package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    private Integer[] integerArray;
    private String[] stringArray;
    private Student[] studentArray;

    @BeforeEach
    void setUp() {
        integerArray = new Integer[]{5, 3, 1, 9, 8, 2, 4, 7};
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
        MergeSort.sort(integerArray);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 7, 8, 9}, integerArray);
        SortingUtil.printArray(studentArray);
    }

    @Test
    void sortStringArray() {
        MergeSort.sort(stringArray);
        assertArrayEquals(new String[]{"Amit", "Ankit", "Mayank", "Rahul", "Rohit", "Sachin"}, stringArray);
        SortingUtil.printArray(studentArray);
    }

    @Test
    void sortStudentArray() {
        MergeSort.sort(studentArray);
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