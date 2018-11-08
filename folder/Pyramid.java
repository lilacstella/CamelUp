import java.util.TreeSet;

public class Pyramid 
{
	TreeSet<Dice> s;
	
	public Pyramid()
	{
		 s = new TreeSet<Dice>();
		 addDice();
	


		 
	}
	
	//helper method to add dice to the TreeSet; also useful for reset
	private void addDice()
	{
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
	 int count = 0;
	 for(Dice d : s)
	 {
		 
		 count++;
		 if(count==dieToChoose)
		 {
			 s.remove(d);
			 return d;
		 }
			 
	 }
	 return new Dice("");
			 
	}
	
	public void reset()
	{
		addDice();
	}
	
	public TreeSet<Dice> getDiceLeft()
	{
		return s;
		
	}
	
}
