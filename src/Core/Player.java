import java.util.ArrayList;

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
		setCoins(5); // i assume this is how many coins the player starts out with though not sure
		gameBets = new ArrayList<>(); // initialize gameBets
		for (int i = 0; i < 5; i++)
		{
			gameBets.add(new GameBet(name, camelColors[i])); // sets the players five gameBets of each camel color;
		}

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

	public ArrayList<GameBet> getGameBets()
	{
		return gameBets;
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

	public boolean addLegBet(LegBet legBet)
	{
		if (legBet == null)
			return false;
		return legBets.add(legBet);
	}
}
