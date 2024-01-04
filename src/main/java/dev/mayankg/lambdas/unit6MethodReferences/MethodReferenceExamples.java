package dev.mayankg.lambdas.unit6MethodReferences;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        Thread t1 = new Thread(MethodReferenceExamples::printMessage); // () -> method() === ClassName::methodName
        t1.start();
    }

    public static void printMessage() {
        System.out.println("Hello");
    }
}