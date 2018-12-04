package core;

import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;

public class Pyramid
{
	HashSet<Dice> die;

	public Pyramid()
	{
		die = new HashSet<Dice>();
		reset();
	}

	// helper method to add dice to the set; also useful for reset
	public void reset()
	{
		die.add(new Dice("blue"));
		die.add(new Dice("yellow"));
		die.add(new Dice("orange"));
		die.add(new Dice("green"));
		die.add(new Dice("white"));
		Iterator<Dice> iter = die.iterator();
		while (iter.hasNext())
			iter.next().rollDice();
	}

	// chooses and returns the dice that
	public Dice roll()
	{
		Random gen = new Random();
		int rand = gen.nextInt(die.size());
		Iterator<Dice> iter = die.iterator();
		while (--rand > 0)
			iter.next();

		Dice dice = iter.next();
		iter.remove();

		return dice;
	}
}
