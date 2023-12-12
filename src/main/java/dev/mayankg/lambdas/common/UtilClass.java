package dev.mayankg.lambdas.common;

import java.util.ArrayList;
import java.util.List;

public class UtilClass {
    public static List<Footballers> createListOfFootballPlayers() {
        return new ArrayList<>(List.of(
                new IndianFootballer("Gurpreet", "Sandhu", 1, "GK"),
                new IndianFootballer("Jeakson", "Thounaojam", 14, "MF"),
                new IndianFootballer("Sandesh", "Jhingan", 5, "DF"),
                new IndianFootballer("Mehtab", "Singh", 18, "DF"),
                new IndianFootballer("Anwar", "Ali", 4, "DF"),
                new IndianFootballer("Akash", "Mishra", 6, "DF"),
                new IndianFootballer("Udanta", "Kumam", 15, "MF"),
                new IndianFootballer("Sahal", "Samad", 10, "MF"),
                new IndianFootballer("Naorem", "Mahesh", 8, "MF"),
                new IndianFootballer("Anirudh", "Thapa", 7, "MF"),
                new IndianFootballer("Nikhil", "Poojary", 21, "MF"),
                new IndianFootballer("Lallianzuala", "Chhangte", 17, "FW"),
                new IndianFootballer("Sunil", "Chhetri", 11, "ST"),
                new IndianFootballer("Ashique", "Kuruniyan", 22, "FW")
        ));
    }
}