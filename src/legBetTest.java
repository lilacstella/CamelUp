package unit_tests;

import core.CamelUp;
import core.Player;

import java.util.Arrays;

public class legBetTest {

    public static void main(String[] args) {

        CamelUp gameState = new CamelUp();
        printTrack(gameState);

        System.out.println(gameState.getCurrentPlayer());
        gameState.legBet("blue");
        System.out.println(gameState.getCurrentPlayer());
        gameState.legBet("blue");
        System.out.println(gameState.getCurrentPlayer()); //to see if the leg bets get appended correctly
        gameState.legBet("yellow");
        System.out.println(gameState.getCurrentPlayer());
        gameState.legBet("orange");
        gameState.legBet("white");
        gameState.legBet("green");
        for (int i = 0; i < 5; i++) {
            gameState.roll();
            gameState.proceed();
        }

        print10blankLines();
        printTrack(gameState);
        System.out.println();
        printCoins(gameState);











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
