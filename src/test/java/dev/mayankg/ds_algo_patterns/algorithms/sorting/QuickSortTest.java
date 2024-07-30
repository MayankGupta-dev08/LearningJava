package dev.mayankg.ds_algo_patterns.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

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
        QuickSort.sort(integerArray);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 7, 8, 9}, integerArray);
        SortingUtil.printArray(studentArray);
    }

    @Test
    void sortStringArray() {
        QuickSort.sort(stringArray);
        assertArrayEquals(new String[]{"Amit", "Ankit", "Mayank", "Rahul", "Rohit", "Sachin"}, stringArray);
        SortingUtil.printArray(studentArray);
    }

    @Test
    void sortStudentArray() {
        QuickSort.sort(studentArray);
        assertArrayEquals(new Student[]{
                new Student(104, "Amit", "Sharma", "amit.sh@gmail.com"),
                new Student(102, "Ankit", "Kumar", "ankit.kr@gmail.com"),
                new Student(101, "Mayank", "Gupta", "mayank@gmail.com"),
                new Student(103, "Rahul", "Singh", "signh.rahul@gmail.com"),
                new Student(105, "Rohit", "Kumar", "kr.rohit@gmail.com"),
                new Student(106, "Sachin", "Gupta", "saching@gmail.com")
        }, studentArray);
    }

    @Test
    void sortAlreadySortedArray() {
        Integer[] sortedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        QuickSort.sort(sortedArray);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, sortedArray);
    }

    @Test
    void sortArrayWithDuplicates() {
        Integer[] arrayWithDuplicates = new Integer[]{5, 3, 8, 8, 1, 2, 3, 5};
        QuickSort.sort(arrayWithDuplicates);
        assertArrayEquals(new Integer[]{1, 2, 3, 3, 5, 5, 8, 8}, arrayWithDuplicates);
    }

    @Test
    void sortEmptyArray() {
        Integer[] emptyArray = new Integer[]{};
        QuickSort.sort(emptyArray);
        assertArrayEquals(new Integer[]{}, emptyArray);
    }

    @Test
    void sortSingleElementArray() {
        Integer[] singleElementArray = new Integer[]{42};
        QuickSort.sort(singleElementArray);
        assertArrayEquals(new Integer[]{42}, singleElementArray);
    }

    @Test
    void sortStudentArrayByEmail() {
        QuickSort.sort(studentArray, Student.BY_EMAIL);
        assertArrayEquals(new Student[]{
                new Student(104, "Amit", "Sharma", "amit.sh@gmail.com"),
                new Student(102, "Ankit", "Kumar", "ankit.kr@gmail.com"),
                new Student(105, "Rohit", "Kumar", "kr.rohit@gmail.com"),
                new Student(101, "Mayank", "Gupta", "mayank@gmail.com"),
                new Student(106, "Sachin", "Gupta", "saching@gmail.com"),
                new Student(103, "Rahul", "Singh", "signh.rahul@gmail.com")
        }, studentArray);
    }

    @Test
    void sortStudentArrayByRollNo() {
        QuickSort.sort(studentArray, Student.BY_ROLL_NO);
        assertArrayEquals(new Student[]{
                new Student(101, "Mayank", "Gupta", "mayank@gmail.com"),
                new Student(102, "Ankit", "Kumar", "ankit.kr@gmail.com"),
                new Student(103, "Rahul", "Singh", "signh.rahul@gmail.com"),
                new Student(104, "Amit", "Sharma", "amit.sh@gmail.com"),
                new Student(105, "Rohit", "Kumar", "kr.rohit@gmail.com"),
                new Student(106, "Sachin", "Gupta", "saching@gmail.com")
        }, studentArray);
    }
}