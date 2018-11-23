import java.util.Stack;

public class LegBetDock
{
	private Stack<LegBet> legBets;
	private static final int[] cardValues =
	{ 2, 3, 5 };
	private static final String[] camelColors =
	{ "blue", "yellow", "green", "orange", "white" };

	// instantiating all the legBet
	public LegBetDock()
	{
		reset();
	}

	// polls the top camel on the stack for the player
	public LegBet getLegBet()
	{
		if (legBets.size() == 0)
			return null;
		return legBets.pop();
	}

	// resets the dock to its original position, meant for the beginning
	public void reset()
	{
		legBets = new Stack<>();
		for (String s : camelColors)
			for (Integer i : cardValues)
				legBets.push(new LegBet(i, s));
	}
}
