package dev.mayankg.experimentNlearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SomeApp {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//        boolean flag = null; can't be done

        List<String> userLoginFilter = new ArrayList<>(List.of("tester", "developer"));
        List<String> jobInPlanResp_userLogin = new ArrayList<>(List.of("tester", "developer", "wauser", "luserA"));

        boolean condition = userLoginFilter.stream().allMatch(x -> (jobInPlanResp_userLogin.stream().anyMatch(x::equals)));
        System.out.println(condition);

        List<String> tzs = new ArrayList<>(List.of("asia/ho_chi_min", "-07:00", "05:30", "europe/berlin", "america/new_york"));
        List<String> strings = handleTimeZone(tzs);
        System.out.println(strings);
    }

    public static List<String> handleTimeZone(List<String> tzs) {
        List<String> TZs = new ArrayList<>();
        for (String tz : tzs) {
            if (tz.isEmpty()) TZs.add("");
            else if (tz.length() <= 3 && !tz.contains("/"))
                tz.toUpperCase();
            else {
                String correctTz = handleBackSlash(tz);
                TZs.add(correctTz);
            }
        }
        return TZs;
    }

    private static String capitalizeFirstCharAndLowercaseRest(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    private static String handleBackSlash(String s) {
        String[] split_strings = s.split("/");
        String reduce = Arrays.stream(split_strings)
                .map(SomeApp::capitalizeFirstCharAndLowercaseRest)
                .map(SomeApp::camelcase)
                .reduce("", (x, y) -> x + "/" + y);
        return reduce.substring(1);
    }

    private static String camelcase(String s) {
        if (s.contains("_")) {
            String[] split_strings = s.split("_");
            String reduce = Arrays.stream(split_strings)
                    .map(SomeApp::capitalizeFirstCharAndLowercaseRest)
                    .reduce("", (x, y) -> x + "_" + y);
            return reduce.substring(1);
        }
        return s;
    }
}