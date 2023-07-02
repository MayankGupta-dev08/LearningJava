package co.in.codejava.mayankg.unit1Excercise1;

import co.in.codejava.mayankg.common.Footballers;
import co.in.codejava.mayankg.common.PlayerAttributes;

import java.util.Comparator;
import java.util.List;

public class Exc1SolutionJava7 {

    // Q1. Sort the list by lastName & position
    void sortPlayers(List<Footballers> players, PlayerAttributes playerAttribute) {
        if (PlayerAttributes.FIRST_NAME.equals(playerAttribute)) {
            players.sort(new Comparator<Footballers>() {
                @Override
                public int compare(Footballers p1, Footballers p2) {
                    return p1.getFirstName().compareTo(p2.getFirstName());
                }
            });
        } else if (PlayerAttributes.LAST_NAME.equals(playerAttribute)) {
            players.sort(new Comparator<Footballers>() {
                @Override
                public int compare(Footballers p1, Footballers p2) {
                    return p1.getLastName().compareTo(p2.getLastName());
                }
            });
        } else if (PlayerAttributes.POSITION.equals(playerAttribute)) {
            players.sort(new Comparator<Footballers>() {
                @Override
                public int compare(Footballers p1, Footballers p2) {
                    return p1.getPosition().compareTo(p2.getPosition());
                }
            });
        } else if (PlayerAttributes.JERSEY_NUMBER.equals(playerAttribute)) {
            players.sort(new Comparator<Footballers>() {
                @Override
                public int compare(Footballers p1, Footballers p2) {
                    return p1.getJerseyNum() - p2.getJerseyNum();
                }
            });
        }
    }

    // Q2. print all elements in the list
    void printAll(List<Footballers> players) {
        for (Footballers player : players) {
            System.out.println(player);
        }
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
        if (!List.of("ST", "MF", "DF", "FW", "GK").contains(position)) {
            System.out.println("Invalid position entered, operation failed!!");
            return;
        }

        System.out.println("Players for " + position + " position:");
        printConditionally(players, new Condition() {
            @Override
            public boolean test(Footballers player) {
                return player.getPosition().equalsIgnoreCase(position);
            }
        });
    }

    void printIfFirstNameStartsWithLetter(List<Footballers> players, Character letter) {
        if (!Character.isAlphabetic(letter)) {
            System.out.println("Invalid character entered, operation failed!!");
            return;
        }

        System.out.println("Players with first name starting with " + letter + ":");
        printConditionally(players, new Condition() {
            @Override
            public boolean test(Footballers player) {
                return player.getFirstName().toLowerCase()
                        .startsWith(String.valueOf(letter).toLowerCase());
            }
        });
    }
}