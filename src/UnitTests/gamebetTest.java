package UnitTests;

import Core.CamelUp;
import Core.Player;

import java.util.Arrays;

public class gamebetTest {
    public static void main(String[] args) {
        CamelUp gameState = new CamelUp();
        printTrack(gameState);
        System.out.println(gameState.currentPlayer());

        gameState.gameBet("blue", true);
        System.out.println(gameState.currentPlayer());
        while (!gameState.won()) {
            gameState.roll();
            gameState.proceed();
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
