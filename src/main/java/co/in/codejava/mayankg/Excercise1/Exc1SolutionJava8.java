package co.in.codejava.mayankg.Excercise1;

import java.util.Comparator;
import java.util.List;

public class Exc1SolutionJava8 {

    // Q1. Sort the list by lastName & position
    void sortPlayers(List<Footballers> players, PlayerAttributes playerAttribute) {

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

    }

    protected void printIfFirstNameStartsWithLetter(List<Footballers> players, Character letter) {

    }
}