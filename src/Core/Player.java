import java.util.ArrayList;
import java.util.Iterator;

public class Player
{
	private int coins;
	private ArrayList<GameBet> gameBets;
	private ArrayList<LegBet> legBets;
	private String name;
	private int rollCards;
	private boolean trap; // true if trap is on track
	private static final String[] camelColors =
	{ "blue", "yellow", "green", "orange", "white" };

	// TO DO
	// ALSO I HAVE TO COMMENT SOME OF MY METHODS IN MY GAMEBET DOCK AFTER THESE
	// ISSUES ARE RESOLVED

	public Player(String name)
	{
		this.name = name;
		setCoins(3); // start out with 3 coins issue #28
		gameBets = new ArrayList<>(); // initialize gameBets
		for (int i = 0; i < 5; i++)
			gameBets.add(new GameBet(name, camelColors[i])); // sets the players five gameBets of each camel color;
		legBets = new ArrayList<>(); // initialize leg bets
		rollCards = 0;
		trap = false;
	}

	public int getCoins()
	{
		return coins;
	}

	public void setCoins(int coins)
	{
		this.coins = coins;
	}

	public ArrayList<GameBet> getGameBet()
	{
		return gameBets;
	}

	public GameBet getGameBet(String color)
	{
		Iterator<GameBet> iter = gameBets.iterator();
		while (iter.hasNext())
		{
			GameBet temp = iter.next();
			if (!temp.getCamelColor().equals(color))
				continue;
			iter.remove();
			return temp;
		}
		return null;
	}

	public ArrayList<LegBet> getLegBets()
	{
		return legBets;
	}

	public void addRollCard()
	{
		rollCards++;
	}

	public int getRollCards()
	{
		return rollCards;
	}

	public String getName()
	{
		return name;
	}

	public boolean trap()
	{
		if (trap) // if trap is on track
			return !trap; // false to not put down more trap
		trap = !trap;
		return trap; // true to proceed placing trap
	}
	
	public void legClear()
	{
		coins += rollCards;
		rollCards = 0;
		trap = false;
	}
	
	public boolean addLegBet(LegBet legBet)
	{
		if (legBet == null)
			return false;
		return legBets.add(legBet);
	}
}
