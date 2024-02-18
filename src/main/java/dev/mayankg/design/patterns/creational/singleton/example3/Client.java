package dev.mayankg.design.patterns.creational.singleton.example3;

class Client {
    public static void main(String[] args) {
        LazySingletonIH singletonIH1 = LazySingletonIH.getInstance();
        LazySingletonIH singletonIH2 = LazySingletonIH.getInstance();
        LazySingletonIH singletonIH3 = LazySingletonIH.getInstance();
        LazySingletonIH singletonIH4 = LazySingletonIH.getInstance();
    }
}