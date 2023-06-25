package co.in.codejava.mayankg.LamdaExpAndFunctionalInterface;

public class TypeInferenceExample {
    public static void main(String[] args) {
        String str = "findLengthOfString";
//        StringLengthLambda myLambda = (String s) -> s.length();
        StringLengthLambda myLambda = String::length;
        printStringLengthUsingLambda(str, myLambda);
    }

    private static void printStringLengthUsingLambda(String s, StringLengthLambda lambda) {
        System.out.println(lambda.getLength(s));
    }

    @FunctionalInterface
    interface StringLengthLambda {
        //this interface should have only one declared method
        int getLength(String s);
    }
}
