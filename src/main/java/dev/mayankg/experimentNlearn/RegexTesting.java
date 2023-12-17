package dev.mayankg.experimentNlearn;

import java.util.regex.Pattern;

public class RegexTesting {
    private static final Pattern INVALID_START_NAME_PATTERN = Pattern.compile("^([^/°a-zA-Z]).*");
    private static final Pattern INVALID_NOT_STARTING_NAME_PATTERN = Pattern.compile("^..*([^a-zA-Z0-9_/°-]).*");

    public static void main(String[] args) {
        String calName = "/°CALnm°-2";

//        NewFolder/°Cal
        System.out.println(isValidName(calName));
    }

    public static boolean isValidName(String value)  {
        return hasValidNameStartChar(value) && hasValidNotStartingNameChars(value);
    }

    private static boolean hasValidNotStartingNameChars(String value) {
        return !INVALID_NOT_STARTING_NAME_PATTERN.matcher(value).matches();
    }

    private static boolean hasValidNameStartChar(String value) {
        return !INVALID_START_NAME_PATTERN.matcher(value).matches();
    }
}