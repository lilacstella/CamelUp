import java.util.LinkedList;
import java.util.Queue;

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

        while(!gameBetQueue.isEmpty()) {
            GameBet gameBet = gameBetQueue.poll();
            String playerName = gameBet.getPlayerName();
            if(gameBet.getCamelColor().equals(color)) {
                addPlayerCoins(playerName, players, values[index++]);
            } else {
                addPlayerCoins(playerName, players, -1);
            }
        }
    }

    public void addPlayerCoins(String playerName, Player[] players, int value) {
        for(Player p: players) {
            if (p.getName().equals(playerName)) {
                p.setCoins(p.getCoins() + value);
            }
        }
    }
}
