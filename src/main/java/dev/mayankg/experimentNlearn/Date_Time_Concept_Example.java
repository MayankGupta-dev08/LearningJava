package dev.mayankg.experimentNlearn;

import java.time.*;

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
    }
}