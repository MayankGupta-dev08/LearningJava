package dev.mayankg.design.patterns.creational.singleton.example1;

class Client {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton1);
        System.out.println(eagerSingleton2);
        System.out.println(eagerSingleton1 == eagerSingleton2);
    }
}