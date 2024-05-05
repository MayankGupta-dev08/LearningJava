package dev.mayankg.design.patterns.creational.singleton.lazy.full_proof;

class ABCWork implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void someWork() {
        System.out.println("some work...");
    }
}