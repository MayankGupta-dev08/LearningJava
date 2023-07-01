package co.in.codejava.mayankg.Unit1Excercise;

import java.util.Comparator;
import java.util.List;

enum PROPERTY {
    FIRST_NAME, LAST_NAME, JERSEY_NUM, POSITION;
}


public class Unit1SolutionJava7 {

    // Q1. Sort the list by lastName & position
    void sortPlayers(List<Footballers> players, PROPERTY property) {
        if (property.equals(PROPERTY.FIRST_NAME)) {
            players.sort(new Comparator<Footballers>() {
                @Override
                public int compare(Footballers p1, Footballers p2) {
                    return p1.getFirstName().compareTo(p2.getFirstName());
                }
            });
        } else if (property.equals(PROPERTY.LAST_NAME)) {
            players.sort(new Comparator<Footballers>() {
                @Override
                public int compare(Footballers p1, Footballers p2) {
                    return p1.getLastName().compareTo(p2.getLastName());
                }
            });
        } else if (property.equals(PROPERTY.POSITION)) {
            players.sort(new Comparator<Footballers>() {
                @Override
                public int compare(Footballers p1, Footballers p2) {
                    return p1.getPosition().compareTo(p2.getPosition());
                }
            });
        } else if (property.equals(PROPERTY.JERSEY_NUM)) {
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

    protected void printOnBasisOfPosition(List<Footballers> players, String position) {
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

    protected void printIfFirstNameStartsWithLetter(List<Footballers> players, Character letter) {
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

@FunctionalInterface
interface Condition {
    boolean test(Footballers player);
}