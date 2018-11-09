import java.util.LinkedList;
import java.util.Queue;

//NOT COMPLETE
//NOT COMPLETE
//NOT COMPLETE
//NOT COMPLETE

public class GameBetDock {

    private Queue<GameBet> gameBetQueue;
    private static final int[] values = {8, 5, 3, 2, 1};

    public GameBetDock() {
        gameBetQueue = new LinkedList<>();

    }

    public void addGameBet(GameBet g) {
        gameBetQueue.offer(g);
    }

    public GameBet getTopCard() {
        return gameBetQueue.peek();
    }

    public void calc(Player[] players, Camel c) {
        String color = c.getCamelColor();

        int index = 0;

        for (GameBet gameBet : gameBetQueue) {

        }


    }


}
