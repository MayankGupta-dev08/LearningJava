package dev.mayankg.generics.other;

import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Child> childList = List.of(new Person("p1", "X"), new Person("p2", "Y"));
        test(childList);

        List<Parent> parentList = List.of(new Person("p1", "X"), new Person("p2", "Y"));
        test(parentList);
    }

    public static <T extends Parent>  void test(List<T> parentList) {
        Child p5 = new Person("p1", "X");
        parentList.add((T) p5);
    }
}
