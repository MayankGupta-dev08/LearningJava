package dev.mayankg.clean_coding.unit2_4PrinciplesOfDesign.simple.design.business.text;

public class TextHelper {
    public String swapLastTwoCharacters(String str) {
        if (str == null || str.isEmpty() || str.length() == 1) return str;

        int length = str.length();
        char lastChar = str.charAt(length - 1);
        char secondLastChar = str.charAt(length - 2);

        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(length - 1, secondLastChar);
        sb.setCharAt(length - 2, lastChar);

        return sb.toString();
    }

    public String truncateAInFirst2Positions(String str) {
        if (str == null || str.isEmpty()) return str;
        if (str.length() < 2) return str.replace("A", "");

        StringBuilder sb = new StringBuilder(str);
        String restOfTheString = sb.substring(2);
        String first2Chars = sb.substring(0, 2);
        String updatedFirst2Chars = first2Chars.replaceAll("A", "");
        return updatedFirst2Chars + restOfTheString;
    }
}