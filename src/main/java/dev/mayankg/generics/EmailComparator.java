package dev.mayankg.generics;

import java.util.Comparator;

/**
 * We need to use Java Comparator interface because Comparable.compareTo(Object o) method implementation can provide default sorting & we can’t change it dynamically.
 * Whereas with Comparator, we can define multiple methods with different ways of sorting and then chose the sorting method based on our requirements.
 */
public class EmailComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getEmailId().compareTo(o2.getEmailId());
    }
}