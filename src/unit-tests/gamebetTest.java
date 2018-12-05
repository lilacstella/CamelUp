package unit_tests;

import core.CamelUp;
import core.Player;

import java.util.Arrays;

public class gamebetTest {
    public static void main(String[] args) {
        CamelUp gameState = new CamelUp();
        printTrack(gameState);
        System.out.println(gameState.getCurrentPlayer());

        gameState.gameBet("blue", true);
        System.out.println(gameState.getCurrentPlayer()); //testing if the gamebet is removed


        print10blankLines();
        print10blankLines();


        gameState.proceed();
        gameState.gameBet("yellow", true);
        gameState.proceed();
        gameState.gameBet("green", true);
        gameState.proceed();
        gameState.gameBet("white", true);
        gameState.proceed();
        gameState.gameBet("orange", true);
        gameState.proceed();



        gameState.gameBet("yellow", false);
        gameState.proceed();
        gameState.gameBet("green", false);
        gameState.proceed();
        gameState.gameBet("white", false);
        gameState.proceed();
        gameState.gameBet("orange", false);
        gameState.proceed();
        gameState.gameBet("blue", false);
        gameState.proceed();





        int r = 1; // roll num


        while (!gameState.won()) {
            gameState.roll();
            gameState.proceed();
            System.out.println(r++);
        }
        printCoins(gameState);
        printTrack(gameState);
    }




    public static void printTrack(CamelUp camelUp) {
        System.out.println(Arrays.toString(camelUp.getTrack()));
    }

    public static void print10blankLines() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public static void printCoins(CamelUp gameState) {
        Player[] players = gameState.getPlayers();
        for (Player p : players) {
            System.out.print(p.getCoins() + " ");
        }
    }


}
