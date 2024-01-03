package dev.mayankg.lambdas.unit5ThisReferenceExample;

/**
 * It is important to note that Lambdas are not just the syntactical sugar of anonymous inner classes,
 * rather there is a difference between the two which we will see through this example class.
 * Lambdas treat the "this" reference in a slightly different way than the anonymous inner class do.
 * In the case of an anonymous inner class, the "this" reference refers to the instance of that anonymous inner class.
 * However, in the case of a lambda, the instance of a lambda does not touch the "this" reference; it is actually unmodified when we are using a lambda expression.
 * So, when you're using the lambda anywhere in the code, then the value of the "this" reference would actually be the same as what it would have been outside the lambda expression.
 */
public class ThisReferenceExample {
    void doSomeProcess(int i, Process p) {
        p.process(i);
    }

    void execute() {
        doSomeProcess(30, i -> {
            System.out.println("inside lambda expression from member function");
            System.out.println("Value of i is " + i);
            System.out.println(this); // 'this' works here, since outside the lambda; we are in scope of an instance method which has the reference for 'this'.
            System.out.println("-----------------------------------------------------------------");
        });
    }

    @Override
    public String toString() {
        return "This is the object instance (this === thisReferenceExampleObj)";
    }

    // NOTE: we can't call an instance method (doSomeProcess, execute) from a static method (main)
    public static void main(String[] args) {
        // System.out.println(this); // 'this' will not work here, as main() is a static method

        ThisReferenceExample thisReferenceExampleObj = new ThisReferenceExample();

        // POC1 - using anonymous inner class
        thisReferenceExampleObj.doSomeProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("inside method of anonymous inner class");
                System.out.println("Value of i is " + i);
                System.out.println(this);   // 'this' is the part of the anonymous inner class of Process interface
                System.out.println("-----------------------------------------------------------------");
            }

            @Override
            public String toString() {
                return "(this) refers to the instance of the anonymous inner class that we have created using (new Process() {...})";
            }
        });

        //POC2 - using lambda expression
        thisReferenceExampleObj.doSomeProcess(20, i -> {
            System.out.println("inside lambda expression through method call using obj from main()");
            System.out.println("Value of i is " + i);
            // System.out.println(this); // 'this' will not work here as outside the lambda, we are in the scope of the main() which is static method, hence 'this' doesn't refer to anything
            System.out.println("-----------------------------------------------------------------");
        });

        //POC3
        thisReferenceExampleObj.execute();
    }
}

@FunctionalInterface
interface Process {
    void process(int i);
}