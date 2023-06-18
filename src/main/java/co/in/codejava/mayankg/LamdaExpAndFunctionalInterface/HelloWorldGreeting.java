package co.in.codejava.mayankg.LamdaExpAndFunctionalInterface;

public class HelloWorldGreeting implements Greeting {
    @Override
    public void perform() {
        System.out.println("Hello world by HelloWorldGreeting");
    }
}
