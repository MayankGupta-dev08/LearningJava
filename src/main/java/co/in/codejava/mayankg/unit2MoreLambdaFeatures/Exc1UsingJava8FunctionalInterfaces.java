package co.in.codejava.mayankg.unit2MoreLambdaFeatures;

import co.in.codejava.mayankg.common.Footballers;
import co.in.codejava.mayankg.common.IndianFootballer;
import co.in.codejava.mayankg.common.PlayerAttributes;

import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exc1UsingJava8FunctionalInterfaces {
    public static void main(String[] args) {
        List<Footballers> players = createListOfFootballPlayers();

        System.out.println("-- sorting players on the basis of position --");
        sortPlayers(players, "position");
        printAll(players);
        System.out.println("\n-- sorting players on the basis of first name --");
        sortPlayers(players, "FIRST_name");
        printAll(players);
        System.out.println("\n-----------------------------------------------");
        printIfFirstNameStartsWithLetter(players, 's');
        System.out.println("\n-----------------------------------------------");
        printIfLastNameStartsWithLetter(players, 'C');
        System.out.println("\n-----------------------------------------------");
        printOnBasisOfPosition(players, "ST");
        System.out.println("\n-----------------------------------------------");
        printOnBasisOfPosition(players, "FW");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static List<Footballers> createListOfFootballPlayers() {
        return new ArrayList<>(List.of(
                new IndianFootballer("Gurpreet", "Sandhu", 1, "GK"),
                new IndianFootballer("Jeakson", "Thounaojam", 14, "MF"),
                new IndianFootballer("Sandesh", "Jhingan", 5, "DF"),
                new IndianFootballer("Anwar", "Ali", 4, "DF"),
                new IndianFootballer("Akash", "Mishra", 6, "DF"),
                new IndianFootballer("Udanta", "Kumam", 15, "MF"),
                new IndianFootballer("Naorem", "Mahesh", 8, "MF"),
                new IndianFootballer("Anirudh", "Thapa", 7, "MF"),
                new IndianFootballer("Nikhil", "Poojary", 21, "MF"),
                new IndianFootballer("Lallianzuala", "Chhangte", 17, "FW"),
                new IndianFootballer("Sunil", "Chhetri", 11, "ST"),
                new IndianFootballer("Ashique", "Kuruniyan", 22, "FW")
        ));
    }

    // Q1. Sort the list of players
    static void sortPlayers(List<Footballers> players, String playerAttribute) {
        if (PlayerAttributes.FIRST_NAME.name().equalsIgnoreCase(playerAttribute)) {
            players.sort((Footballers p1, Footballers p2) -> {
                return p1.getFirstName().compareTo(p2.getFirstName());
            });
        } else if (PlayerAttributes.LAST_NAME.name().equalsIgnoreCase(playerAttribute)) {
            players.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        } else if (PlayerAttributes.JERSEY_NUMBER.name().equalsIgnoreCase(playerAttribute)) {
            players.sort(Comparator.comparing(Footballers::getJerseyNum));
        } else if (PlayerAttributes.POSITION.name().equalsIgnoreCase(playerAttribute)) {
            players.sort((p1, p2) -> p1.getPosition().compareTo(p2.getPosition()));
        } else {
            System.out.println("Invalid player attribute: " + " used, operation failed!!");
        }
    }

    // Q2. print all elements in the list
    static void printAll(List<Footballers> players) {
        performConditionally(players, player -> true, System.out::println);
    }

    static void printOnBasisOfPosition(List<Footballers> players, String position) {
        if (!List.of("ST", "MF", "DF", "FW", "GK").contains(position))
            throw new UnsupportedCharsetException("Invalid position entered, operation failed!!");

        System.out.println("Players for " + position + " position:");
        performConditionally(players, player -> player.getPosition().equalsIgnoreCase(position), System.out::println);
    }

    static void printIfFirstNameStartsWithLetter(List<Footballers> players, Character letter) {
        if (!Character.isAlphabetic(letter))
            throw new UnsupportedCharsetException("Invalid character entered, operation failed!!");

        System.out.println("Players with first name starting with " + letter + ":");
        performConditionally(players, player -> player.getFirstName().toLowerCase().startsWith(String.valueOf(letter).toLowerCase()), p -> System.out.println(p.getFirstName()));
    }

    static void printIfLastNameStartsWithLetter(List<Footballers> players, Character letter) {
        if (!Character.isAlphabetic(letter))
            throw new UnsupportedCharsetException("Invalid character entered, operation failed!!");

        System.out.println("Players with last name starting with " + letter + ":");
        performConditionally(players, player -> player.getLastName().toLowerCase().startsWith(String.valueOf(letter).toLowerCase()), p -> System.out.println(p.getLastName()));
    }

    // Q3. print all elements on basis of Condition
    private static void performConditionally(List<Footballers> players, Predicate<Footballers> predicate, Consumer<Footballers> consumer) {
        for (Footballers player : players) {
            if (predicate.test(player)) {
                consumer.accept(player);
            }
        }
    }
}