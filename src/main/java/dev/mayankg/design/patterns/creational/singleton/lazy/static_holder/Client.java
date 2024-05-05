package dev.mayankg.design.patterns.creational.singleton.lazy.static_holder;

class Client {
    public static void main(String[] args) {
        LazySingletonIH lazySingletonIH1 = LazySingletonIH.getInstance();
        System.out.printf("%s: %d%n", lazySingletonIH1.toString(), lazySingletonIH1.hashCode());

        LazySingletonIH lazySingletonIH2 = LazySingletonIH.getInstance();
        System.out.printf("%s: %d%n", lazySingletonIH2.toString(), lazySingletonIH2.hashCode());

        System.out.println(lazySingletonIH1.hashCode() == lazySingletonIH2.hashCode());
    }
}