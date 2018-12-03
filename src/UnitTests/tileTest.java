package UnitTests;

import Core.CamelUp;

import java.util.Arrays;

public class tileTest {
    public static void main(String[] args) {
        CamelUp gameState = new CamelUp();
        printTrack(gameState);

        System.out.println(gameState.trap(0, 1)); //should return false because there are camels here
        System.out.println(gameState.trap(1, -1));
        System.out.println(gameState.trap(3, -1));
        System.out.println(gameState.trap(2, -1)); // should return false
        System.out.println(gameState.trap(14, 1));
        System.out.println(gameState.trap(15, 1)); //should not work
        gameState.roll();
        print10blankLines();
        printTrack(gameState);


        print10blankLines();
        gameState.legCalc();
        printTrack(gameState);

        print10blankLines();
        gameState.trap(1, -1);
        printTrack(gameState);

        System.out.println(gameState.currentPlayer());




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
