package unit_tests;

import core.CamelUp;

import java.util.Arrays;

public class camelRankTest {
    public static void main(String[] args) {
        CamelUp gameState = new CamelUp();
        printTrack(gameState);
        System.out.println(gameState.getRankCamel(1));
        System.out.println(gameState.getRankCamel(2));
        System.out.println(gameState.getRankCamel(5));
        print10blankLines();

        gameState.roll();
        gameState.roll();
        gameState.roll();
        gameState.roll();
        gameState.roll();
        gameState.roll();
        gameState.roll();
        gameState.roll();
        gameState.roll();
        printTrack(gameState);
        System.out.println(gameState.getRankCamel(1));
        System.out.println(gameState.getRankCamel(2));
        System.out.println(gameState.getRankCamel(5));
    }

    public static void printTrack(CamelUp camelUp) {
        System.out.println(Arrays.toString(camelUp.getTrack()));
    }

    public static void print10blankLines() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

}


