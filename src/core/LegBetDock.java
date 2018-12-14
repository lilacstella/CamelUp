package core;

import java.util.EmptyStackException;
import java.util.Stack;

public class LegBetDock
{
	private Stack<LegBet> legBets;
	private String color;
	private static final int[] cardValues =
	{ 2, 3, 5 };

	// instantiating all the legBet
	public LegBetDock(String color)
	{
		this.color = color;
		reset();
	}

	// polls the top camel on the stack for the player
	public LegBet getLegBet()
	{
		try {
			return legBets.pop();
		}catch(NullPointerException e)
		{
			return null;
		}
	}

	public LegBet getTopLeg() {
		try {
			return legBets.peek();
		}catch(EmptyStackException e)
		{
			return null;
		}
	}

	// resets the dock to its original position, meant for the beginning
	public void reset()
	{
		legBets = new Stack<>();
		for (Integer i : cardValues)
			legBets.push(new LegBet(i, color));
	}

	public String toString() {
		return getTopLeg().toString();
	}

}
