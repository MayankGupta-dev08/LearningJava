package dev.mayankg.experimentNlearn;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

class Date_Time_Concept_Example {
    public static void main(String[] args) {
        System.out.println(Instant.now().atZone(ZoneId.of("Asia/Kolkata")));

        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

//        Date date = new Date("2021-11-16T14:13:17.475+05:30");
//        System.out.println(date);
        String timestamp = "2021-11-16T14:13:17.475+05:30";


        System.out.println(Instant.now().atOffset(ZoneOffset.UTC));

        ZonedDateTime zdt = ZonedDateTime.parse(timestamp);
        System.out.println(zdt);

        ZonedDateTime utcTime = zdt.withZoneSameInstant(ZoneOffset.UTC);
        System.out.println(utcTime);

//        zdt.withFixedOffsetZone(ZoneOffset.UTC)
//        ZonedDateTime.parse(header.getString("timestamp")).withZoneSameInstant(ZoneOffset.UTC)

        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(df.format(now));

        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HHmm");
        System.out.println(tf.format(now));
        System.out.println(1000 + Integer.parseInt(tf.format(now)));

        temp();
    }

    private static void temp() {
        String[] abc = new String[]{"one", "two", "three"};
        String ans = Arrays.stream(abc).reduce("", (a, b) -> a +","+ b).substring(1);
        System.out.println(ans);
    }
}