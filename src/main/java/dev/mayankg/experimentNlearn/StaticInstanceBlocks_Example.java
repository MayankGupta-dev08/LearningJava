package dev.mayankg.experimentNlearn;

class StaticInstanceBlocks_Example {
    static int staticVar = 1;
    int instanceVar = 100;

    /** Static block: Evaluated at time of class Loading */
    static {
        staticVar = 10;
        System.out.println("Inside static block, while class is loaded, static var: " + staticVar);
        // instanceVar = 100; //Not Possible
    }

    /** Instance block: Evaluated at time of class Loading */ {
        staticVar = 20;
        System.out.println("Inside instance block, static var: " + staticVar);
        instanceVar = 101;
        System.out.println("Inside instance block, instance var: " + instanceVar);
    }

    /**
     * Static method: called directly on the class, and they are executed in the order they are called.
     */
    static void someMethod() {
        staticVar = 30;
        System.out.println("Inside static void someMethod, staticVar: " + staticVar);
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Called using Parent reference, static var: " + ++StaticInstanceBlocks_Example.staticVar);
        StaticInstanceBlocks_Example.someMethod();
        StaticInstanceBlocks_Example m2 = new StaticInstanceBlocks_Example();
        System.out.println("Called using object of class, static var: " + ++m2.staticVar);
        System.out.println("Called using object of class, instance var: " + ++m2.instanceVar);
    }
}

/*
------------------------- OUTPUT -------------------------
Inside static block, while class is loaded, static var: 10
Called using Parent reference, static var: 11
Inside static void someMethod, staticVar: 30
Inside instance block, static var: 20
Inside instance block, instance var: 101
Called using object of class, static var: 21
Called using object of class, instance var: 102
*/