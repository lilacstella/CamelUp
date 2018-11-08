
public class Dice
{
	private int dieFace;
	private String color;
	
	public Dice( String co)
	{
		
		setColor(co);
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	private int rollDice() 
	{
		 dieFace = (int)(Math.random()*3+1);
		 return dieFace;
		
	}

	public int getDieFace()
	{
		return dieFace;
	}
	
	public String color()
	{
		return color;
	}
}
