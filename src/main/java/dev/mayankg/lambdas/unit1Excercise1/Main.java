package dev.mayankg.lambdas.unit1Excercise1;

import dev.mayankg.lambdas.common.Footballers;
import dev.mayankg.lambdas.common.PlayerAttributes;
import dev.mayankg.lambdas.common.UtilClass;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Footballers> listOfFootballers = UtilClass.createListOfFootballPlayers();
        performOperationUsingSolution1(listOfFootballers);
        performOperationUsingSolution2(listOfFootballers);
    }

    private static void performOperationUsingSolution1(List<Footballers> players) {
        Exc1SolutionJava7 solution1 = new Exc1SolutionJava7();
        System.out.println("-- sorting players on the basis of last name --");
        solution1.sortPlayers(players, PlayerAttributes.LAST_NAME);
        solution1.printAll(players);
        System.out.println("\n-- sorting players on the basis of jersey number --");
        solution1.sortPlayers(players, PlayerAttributes.JERSEY_NUMBER);
        solution1.printAll(players);
        System.out.println("\n-----------------------------------------------");
        solution1.printIfFirstNameStartsWithLetter(players, 'S');
        System.out.println("\n-----------------------------------------------");
        solution1.printIfFirstNameStartsWithLetter(players, 'A');
        System.out.println("\n-----------------------------------------------");
        solution1.printOnBasisOfPosition(players, "GK");
        System.out.println("\n-----------------------------------------------");
        solution1.printOnBasisOfPosition(players, "MF");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }

    private static void performOperationUsingSolution2(List<Footballers> players) {
        Exc1SolutionJava8 solution2 = new Exc1SolutionJava8();
        System.out.println("-- sorting players on the basis of position --");
        solution2.sortPlayers(players, "position");
        solution2.printAll(players);
        System.out.println("\n-- sorting players on the basis of first name --");
        solution2.sortPlayers(players, "FIRST_name");
        solution2.printAll(players);
        System.out.println("\n-----------------------------------------------");
        solution2.printIfFirstNameStartsWithLetter(players, 's');
        System.out.println("\n-----------------------------------------------");
        solution2.printIfLastNameStartsWithLetter(players, 'C');
        System.out.println("\n-----------------------------------------------");
        solution2.printOnBasisOfPosition(players, "ST");
        System.out.println("\n-----------------------------------------------");
        solution2.printOnBasisOfPosition(players, "FW");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}