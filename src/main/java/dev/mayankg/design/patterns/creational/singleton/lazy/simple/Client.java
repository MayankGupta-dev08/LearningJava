package dev.mayankg.design.patterns.creational.singleton.lazy.simple;

class Client {
    public static void main(String[] args) {
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.printf("%s: %d%n", lazySingleton1.toString(), lazySingleton1.hashCode());

        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.printf("%s: %d%n", lazySingleton2.toString(), lazySingleton2.hashCode());

        System.out.println(lazySingleton1.hashCode() == lazySingleton2.hashCode());
    }
}