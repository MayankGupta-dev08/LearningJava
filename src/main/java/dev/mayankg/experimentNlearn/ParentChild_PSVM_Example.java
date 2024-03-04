package dev.mayankg.experimentNlearn;

class ParentChild_PSVM_Example {
    public static void main(String[] args) {
        Parent a = new Parent();
        Parent b = new Child();

        a.main(new String[]{});
        b.main(new String[]{});
        Child.main(new String[]{});
    }
}

class Parent {
    protected static void main(String[] args) {
        System.out.println("Parent class main method");
    }
}

class Child extends Parent {
    protected static void main(String[] args) {
        System.out.println("Child class main method");
    }
}