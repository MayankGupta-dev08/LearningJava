package co.in.codejava.mayankg.LamdaExpAndFunctionalInterface;

public class TypeInferenceExample {
    public static void main(String[] args) {
        String str = "findLengthOfString";
        StringLengthLambda myLambda = s -> s.length();
        printStringLengthUsingLambda(myLambda);
    }

    private static void printStringLengthUsingLambda(StringLengthLambda l) {
        l.getLength()
    }

    interface StringLengthLambda {
        int getLength(String s);
    }
}
