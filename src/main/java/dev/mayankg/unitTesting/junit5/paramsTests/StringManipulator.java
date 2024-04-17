package dev.mayankg.unitTesting.junit5.paramsTests;

class StringManipulator {
    public String concatenate(String one, String two) {
        return one + two;
    }

    public String multiply(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("times can not be negative");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.repeat(times));
        return sb.toString();
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String truncateCharIfPresentInFirst2Position(String str, char ch) {
        if (str.length() <= 2)
            return str.replaceAll(String.valueOf(ch), "");

        String first2Chars = str.substring(0, 2).replaceAll(String.valueOf(ch), "");
        String remainingStr = str.substring(2);
        return first2Chars + remainingStr;
    }

    public boolean areFirstAndLastTwoCharsTheSame(String str) {
        if (str.length() <= 2)
            return false;

        String first2Chars = str.substring(0, 2);
        String last2Chars = str.substring(str.length() - 2);
        return first2Chars.equals(last2Chars);
    }
}