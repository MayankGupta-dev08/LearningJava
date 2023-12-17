package dev.mayankg.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Understanding Java Generics using CodeWithMosh Tutorials
 */

public class Main {
    public static void main(String[] args) {
        GenericList<User> userList = new GenericList<User>(User.class, 4);
        userList.add(new User("mayank", 25, "myemail@gmail.com"));
        userList.add(new User("mridul", 23, "hisemail@gmail.com"));

        GenericList<Integer> integerList = new GenericList<>(Integer.class, 3);
        integerList.add(6);
        integerList.add(3);

        System.out.println(Utils.min("mango", "apple"));

        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("------------------------------------------------");

        List<User> uList = new ArrayList<>();
        uList.add(new User("abc", 25, "google@email.com"));
        uList.add(new User("xyz", 23, "apple@email.com"));

        Collections.sort(uList, new EmailComparator());
        uList.stream().forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Collections.sort(uList, new AgeComparator());
        uList.stream().forEach(System.out::println);
    }
}