package dev.mayankg.design.patterns.creational.singleton.eager;

class Client {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.printf("%s: %d%n", eagerSingleton1.toString(), eagerSingleton1.hashCode());

        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        System.out.printf("%s: %d%n", eagerSingleton2.toString(), eagerSingleton2.hashCode());

        System.out.println(eagerSingleton1.hashCode() == eagerSingleton2.hashCode());
    }
}