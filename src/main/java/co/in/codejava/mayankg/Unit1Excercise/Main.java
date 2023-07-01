package co.in.codejava.mayankg.Unit1Excercise;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Footballers> players = new ArrayList<>(List.of(
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

        performOperationUsingSolution1(players);
        performOperationUsingSolution2(players);
    }

    private static void performOperationUsingSolution1(List<Footballers> players) {
        Unit1SolutionJava7 solution1 = new Unit1SolutionJava7();
        System.out.println("-- sorting players on the basis of last name --");
        solution1.sortPlayers(players, PROPERTY.LAST_NAME);
        solution1.printAll(players);
        System.out.println("\n-- sorting players on the basis of position --");
        solution1.sortPlayers(players, PROPERTY.JERSEY_NUM);
        solution1.printAll(players);
        System.out.println("\n-----------------------------------------------");
        solution1.printIfFirstNameStartsWithLetter(players, 'S');
        System.out.println("\n-----------------------------------------------");
        solution1.printOnBasisOfPosition(players, "GK");
    }

    private static void performOperationUsingSolution2(List<Footballers> players) {

    }
}
