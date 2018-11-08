import java.util.TreeSet;

public class Pyramid 
{
	TreeSet<Dice> s;
	
	public Pyramid()
	{
		 s = new TreeSet<Dice>();
		 s.add(new Dice("blue"));
		 s.add(new Dice("yellow"));
		 s.add(new Dice("orange"));
		 s.add(new Dice("green"));
		 s.add(new Dice("white"));


		 
	}
	
	public Dice roll()
	{
		//Chooses a random die out of the 5
	 int dieToChoose =(int)(Math.random()*5+1);
	 
	}
	
}
