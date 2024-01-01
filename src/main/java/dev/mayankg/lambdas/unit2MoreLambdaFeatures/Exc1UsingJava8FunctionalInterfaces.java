/**
 * -> DocumentationLink - https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 */
package dev.mayankg.lambdas.unit2MoreLambdaFeatures;

import dev.mayankg.lambdas.common.Footballers;
import dev.mayankg.lambdas.common.PlayerAttributes;
import dev.mayankg.lambdas.common.UtilClass;

import java.nio.charset.UnsupportedCharsetException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exc1UsingJava8FunctionalInterfaces {
    public static void main(String[] args) {
        List<Footballers> players = UtilClass.createListOfFootballPlayers();
        performCertainOperations(players);
    }

    private static void performCertainOperations(List<Footballers> players) {
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

    // Q1. Sort the list of players
    static void sortPlayers(List<Footballers> players, String playerAttribute) {
        if (PlayerAttributes.FIRST_NAME.name().equalsIgnoreCase(playerAttribute)) {
            players.sort(Comparator.comparing(Footballers::getFirstName));
        } else if (PlayerAttributes.LAST_NAME.name().equalsIgnoreCase(playerAttribute)) {
            players.sort(Comparator.comparing(Footballers::getLastName));
        } else if (PlayerAttributes.JERSEY_NUMBER.name().equalsIgnoreCase(playerAttribute)) {
            players.sort(Comparator.comparing(Footballers::getJerseyNum));
        } else if (PlayerAttributes.POSITION.name().equalsIgnoreCase(playerAttribute)) {
            players.sort(Comparator.comparing(Footballers::getPosition));
        } else {
            System.out.println("Invalid player attribute: " + " used, operation failed!!");
        }
    }

    // Q2. print all elements in the list
    private static void printAll(List<Footballers> players) {
        performConditionally(players, player -> true, System.out::println);
    }

    private static void printOnBasisOfPosition(List<Footballers> players, String position) {
        if (!List.of("ST", "MF", "DF", "FW", "GK").contains(position))
            throw new UnsupportedCharsetException("Invalid position entered, operation failed!!");

        System.out.println("Players for " + position + " position:");
        performConditionally(players, player -> player.getPosition().equalsIgnoreCase(position), System.out::println);
    }

    private static void printIfFirstNameStartsWithLetter(List<Footballers> players, Character alpha) {
        if (!Character.isAlphabetic(alpha))
            throw new UnsupportedCharsetException("Invalid character entered, operation failed!!");

        System.out.println("Players with first name starting with " + alpha + ":");
        performConditionally(players,
                p -> p.getFirstName().toLowerCase().startsWith(String.valueOf(alpha).toLowerCase()),
                p -> System.out.println(p.getFirstName())
        );
    }

    private static void printIfLastNameStartsWithLetter(List<Footballers> players, Character alpha) {
        if (!Character.isAlphabetic(alpha))
            throw new UnsupportedCharsetException("Invalid character entered, operation failed!!");

        System.out.println("Players with last name starting with " + alpha + ":");
        performConditionally(players,
                player -> player.getLastName().toLowerCase().startsWith(String.valueOf(alpha).toLowerCase()),
                p -> System.out.println(p.getLastName())
        );
    }

    // Q3. perform a specific action on provided elements when the condition/predicate is satisfied
    private static void performConditionally(List<Footballers> players, Predicate<Footballers> predicate, Consumer<Footballers> performingAction) {
        for (Footballers player : players) {
            if (predicate.test(player)) {
                performingAction.accept(player);
            }
        }
    }
}