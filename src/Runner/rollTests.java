import Core.CamelUp;

import java.util.Arrays;

public class rollTests {
    public static void main(String[] args) {
        CamelUp gameState = new CamelUp();
        printTrack(gameState);
        gameState.roll();
        gameState.roll();
        gameState.roll();
        print10blankLines();
        System.out.println("rolled: " + gameState.getRolled());
        printTrack(gameState);

        gameState.roll();
        gameState.roll();
        print10blankLines();
        System.out.println("rolled: " + gameState.getRolled());
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

}
