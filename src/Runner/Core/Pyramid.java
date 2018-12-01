package Core;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;

public class Pyramid
{
	HashSet<Dice> s;

	public Pyramid()
	{
		s = new HashSet<Dice>();
		reset();
	}

	// helper method to add dice to the set; also useful for reset
	public void reset()
	{
		s.add(new Dice("blue"));
		s.add(new Dice("yellow"));
		s.add(new Dice("orange"));
		s.add(new Dice("green"));
		s.add(new Dice("white"));
		Iterator<Dice> iter = s.iterator();
		while (iter.hasNext())
			iter.next().rollDice();
	}

	// chooses and returns the dice that
	public Dice roll()
	{
		Random gen = new Random();
		int rand = gen.nextInt(s.size());
		Iterator<Dice> iter = s.iterator();
		while (--rand > 0)
			iter.next();
		return iter.next();
	}
}
