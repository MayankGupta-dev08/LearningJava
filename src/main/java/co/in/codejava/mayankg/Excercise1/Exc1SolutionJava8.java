package co.in.codejava.mayankg.Excercise1;

import java.nio.charset.UnsupportedCharsetException;
import java.util.Comparator;
import java.util.List;

public class Exc1SolutionJava8 {

    // Q1. Sort the list by lastName & position
    void sortPlayers(List<Footballers> players, String playerAttribute) {
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
    void printAll(List<Footballers> players) {
        printConditionally(players, player -> true);
    }

    // Q3. print all elements on basis of Condition
    private void printConditionally(List<Footballers> players, Condition condition) {
        for (Footballers player : players) {
            if (condition.test(player)) {
                System.out.println(player);
            }
        }
    }

    void printOnBasisOfPosition(List<Footballers> players, String position) {
        if (!List.of("ST", "MF", "DF", "FW", "GK").contains(position))
            throw new UnsupportedCharsetException("Invalid position entered, operation failed!!");

        System.out.println("Players for " + position + " position:");
        printConditionally(players, player -> player.getPosition().equalsIgnoreCase(position));
    }

    void printIfFirstNameStartsWithLetter(List<Footballers> players, Character letter) {
        if (!Character.isAlphabetic(letter))
            throw new UnsupportedCharsetException("Invalid character entered, operation failed!!");

        System.out.println("Players with first name starting with " + letter + ":");
        printConditionally(players, player -> player.getFirstName().toLowerCase().startsWith(String.valueOf(letter).toLowerCase()));
    }

    void printIfLastNameStartsWithLetter(List<Footballers> players, Character letter) {
        if (!Character.isAlphabetic(letter))
            throw new UnsupportedCharsetException("Invalid character entered, operation failed!!");

        System.out.println("Players with last name starting with " + letter + ":");
        printConditionally(players, player -> player.getLastName().toLowerCase().startsWith(String.valueOf(letter).toLowerCase()));
    }
}