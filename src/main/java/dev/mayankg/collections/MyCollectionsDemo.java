package dev.mayankg.collections;

import dev.mayankg.generics.EmailComparator;
import dev.mayankg.generics.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyCollectionsDemo {
    private static final List<User> users = new ArrayList<>(List.of(
            new User("mukesh", 30, "e3@gmail.com"),
            new User("sachin", 25, "e1@gmail.com"),
            new User("ashok", 40, "e2@gmail.com")
    ));

    public static void main(String[] args) {
        Method[] methods = MyCollectionsDemo.class.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.getName().startsWith("main")) {
                try {
                    // Set accessible if the method is not public
                    if (!method.isAccessible()) method.setAccessible(true);

                    // Invoke the method
                    System.out.printf("---initiating: %s()---%n", method.getName());
                    method.invoke(null);// pass null for static methods
                    System.out.println("--------------------------------------------");
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void workingWithSet() {
        Set<String> set1 = new HashSet<>(List.of("a", "b", "c"));
        Set<String> set2 = new HashSet<>(List.of("b", "c", "d"));

        // Union
        Set<String> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Union Set: " + unionSet);

        // Intersection
        Set<String> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Intersection Set: " + intersectionSet);

        // Difference (Set1 - Set2)
        Set<String> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        System.out.println("Difference Set (Set1 - Set2): " + differenceSet);
    }

    private static void usingComparableInterface() {
        System.out.println("using name for comparison via comparable interface");
        Collections.sort(users);
        System.out.println(users);
    }

    private static void usingComparatorInterface() {
        System.out.println("using email comparator to sort the list");
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