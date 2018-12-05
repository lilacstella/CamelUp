package core;

import java.util.LinkedList;
import java.util.Queue;

public class GameBetDock
{

	private Queue<GameBet> gameBetQueue;
	private static final int[] values =
	{ 8, 5, 3, 2, 1 };

	public GameBetDock()
	{
		gameBetQueue = new LinkedList<>(); // init
	}

	public boolean addGameBet(GameBet g)
	{
		if (g == null)
			return false;
		gameBetQueue.offer(g); // adds a gamebet to the queue
		return true;
	}

	public void calc(Player[] players, Camel c)
	{
		String color = c.getCamelColor();
		int index = 0;
		while (!gameBetQueue.isEmpty())
		{
			GameBet gameBet = gameBetQueue.poll();
			String playerName = gameBet.getPlayerName();
			if (gameBet.getCamelColor().equals(color))
				addPlayerCoins(playerName, players, values[index++]);
			else
				addPlayerCoins(playerName, players, -1);
		}
	}

	public void addPlayerCoins(String playerName, Player[] players, int value)
	{
		for (Player p : players)
		{
			if (p.getName().equals(playerName))
				p.setCoins(p.getCoins() + value);
		}
	}
}
