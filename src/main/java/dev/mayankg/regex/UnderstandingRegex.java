package dev.mayankg.regex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Regex Docs
 *
 * <p><a href="https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/regex/Pattern.html">Java Doc on Pattern</a>
 * <a href="https://docs.oracle.com/javase/tutorial/essential/regex/index.html">Java Tutorial on Regex</a>
 *
 * <p>Tool: <a href="https://regexr.com/">regexr website (online tool to learn, build, & test regex)</a>
 */
@SuppressWarnings(value = {"unused"})
class UnderstandingRegex {

    private static final String alphaNumericRegex = "[a-zA-Z0-9]+";
    private static final String phoneNumberRegex = "[0-9]{10}";
    private static final String emailRegex = "^[a-zA-Z0-9_.$-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter the regular expression: ");
                String regexFromUser = scn.nextLine();

                System.out.print("Enter the string to be checked: ");
                String stringFromUser = scn.nextLine();

                System.out.printf("Result: %s%n", isMatches(regexFromUser, stringFromUser));

                System.out.println("Do you want to exit?? Press 'y' for doing so!");
                if (scn.nextLine().equalsIgnoreCase("y")) {
                    System.out.println("~~~ Thanks, good bye!! ~~~");
                    break;
                }
            }
        } catch (PatternSyntaxException err) {
            System.out.printf("Error Msg: %s%n", err.getMessage());
            System.out.println("StackTrace: " + Arrays.toString(err.getStackTrace()));
        }
    }

    private static void gettingStartedExample() {
        String regex = "[a-zA-Z0-9]+";
        String input = "aaaaab";
        boolean matches = isMatches(regex, input);
        System.out.println("result: " + matches);
    }

    private static boolean isMatches(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}