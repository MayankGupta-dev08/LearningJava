package dev.mayankg.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/regex/Pattern.html">Java Doc on Pattern</a>
 */
@SuppressWarnings(value = {"unused"})
public class UnderstandingRegex {
    public static void main(String[] args) {

    }

    private static void gettingStartedExample() {
        String regex = "a*b";
        Pattern pattern = Pattern.compile(regex);

        String input = "aaaaab";
        Matcher matcher = pattern.matcher(input);

        System.out.println("result: " + matcher.matches());
    }
}