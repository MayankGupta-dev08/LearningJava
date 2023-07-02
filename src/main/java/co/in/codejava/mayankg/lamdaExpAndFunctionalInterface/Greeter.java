package co.in.codejava.mayankg.lamdaExpAndFunctionalInterface;

public class Greeter {
    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        // option1
        Greeting hwg = new HelloWorldGreeting();
        greeter.greet(hwg);

        // option2
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello world by innerClassGreeting");
            }
        };
        greeter.greet(innerClassGreeting);

        // option3
        Greeting lambdaGreeting = () -> {
            System.out.println("Hello world by lambdaGreeting");
        };
        greeter.greet(lambdaGreeting);

        // option4
        greeter.greet(() -> System.out.println("Hello World by Lambda expression"));

    }
}
