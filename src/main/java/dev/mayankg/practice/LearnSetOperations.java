package dev.mayankg.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LearnSetOperations {
    public static void main(String[] args) {
        System.out.println("s1 = " + Arrays.asList("a", "b", "c", "d"));
        System.out.println("s2 = " + Arrays.asList("b", "c", "e"));
        setUnion();
        setIntersection();
        setDifference();
    }

    static void setUnion() {
        Set<String> s1 = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b", "c", "e"));

        // Union
        s1.addAll(s2);
        System.out.println("s1 ∪ s2 = " + s1);
    }

    static void setIntersection() {
        Set<String> s1 = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b", "c", "e"));

        // Intersection
        s1.retainAll(s2);
        System.out.println("s1 ∩ s2 = " + s1);
    }

    static void setDifference() {
        Set<String> s1 = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b", "c", "e"));

        // Difference
        s1.removeAll(s2);
        System.out.println("s1 − s2 = " + s1);
    }
}