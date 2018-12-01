import Core.CamelUp;

import java.util.Arrays;

public class tileTest {
    public static void main(String[] args) {
        CamelUp gameState = new CamelUp();
        printTrack(gameState);

        System.out.println(gameState.trap(0, 1));
        print10blankLines();

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
