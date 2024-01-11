package dev.mayankg.collections;

import dev.mayankg.generics.EmailComparator;
import dev.mayankg.generics.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyCollectionsDemo {
    public static void main(String[] args) {
        usingCollectionInterface();
        usingListInterface();
        usingComparableInterface();
    }

    private static void usingComparableInterface() {
        List<User> users = new ArrayList<>();
        users.add(new User("mukesh", 30, "e1@gmail.com"));
        users.add(new User("sachin", 25, "e2@gmail.com"));
        users.add(new User("ashok", 40, "e3@gmail.com"));
        Collections.sort(users);
        System.out.println(users);

        usingComparatorInterface(users);
    }

    private static void usingComparatorInterface(List<User> users) {
        Collections.sort(users, new EmailComparator());
        System.out.println(users);
    }

    private static void usingListInterface() {
        List<String> myList = new ArrayList<>();
        Collections.addAll(myList, "a", "b", "c", "d", "e");
        System.out.println(myList);

        myList.set(0, "a+");
        myList.remove(1);

        System.out.println(myList);

        System.out.println(myList.size());
        System.out.println(myList.indexOf("d"));
        System.out.println(myList.indexOf("Z"));
        myList.add("a+");
        System.out.println(myList);
        System.out.println(myList.lastIndexOf("a+"));
        System.out.println(myList.subList(1, 3));   //[fromIndex, toIndex)
    }

    private static void usingCollectionInterface() {
        Collection<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list);
        list.remove("b");
        System.out.println(list);
        list.clear();

        Collections.addAll(list, "a", "b", "c", "d", "e");
        System.out.println(list);

        Object[] listArray = list.toArray();
        System.out.println(listArray.length);
        String[] stringArray = list.toArray(new String[0]); // No need to worry about the size it will automatically handle that
        for (String s : stringArray) {
            System.out.print(s + " ");
        }
        System.out.println();

        Collection<String> otherList = new ArrayList<>(list);
        System.out.println(otherList == list);  //reference
        System.out.println(otherList.equals(list)); //value
    }
}