package dev.mayankg.design.patterns.creational.singleton.lazy.double_check_lock;

class Client {
    public static void main(String[] args) {
        LazySingletonDCL lazySingletonDCL1 = LazySingletonDCL.getInstance();
        System.out.printf("%s: %d%n", lazySingletonDCL1.toString(), lazySingletonDCL1.hashCode());

        LazySingletonDCL lazySingletonDCL2 = LazySingletonDCL.getInstance();
        System.out.printf("%s: %d%n", lazySingletonDCL2.toString(), lazySingletonDCL2.hashCode());

        System.out.println(lazySingletonDCL1.hashCode() == lazySingletonDCL2.hashCode());
    }
}