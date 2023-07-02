package co.in.codejava.mayankg.lamdaExpAndFunctionalInterface;

/**
 * Functional Interfaces:
 * - We can have as many methods as we want in an interface but since we are making it a functional interface
 * we can have only one declared method and
 * rest methods could be defined methods (with default implementation which is supported after Java8)
 */

@FunctionalInterface
public interface Greeting {
    public void perform();

    // since this method has default implementation --> no need to override this in class which is implementing this interface.
    public static void anotherMethod() {
        System.out.println("another method");
    }
}
