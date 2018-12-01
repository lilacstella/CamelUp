package Core;
public class Dice
{
	private int dieFace;
	private String color;

	// sets the color only
	public Dice(String co)
	{
		setColor(co);
	}

	// helper method to set color
	public void setColor(String color)
	{
		this.color = color;
	}

	// rolls the dice from an number 1-3
	public int rollDice()
	{
		dieFace = (int) (Math.random() * 3 + 1);
		return dieFace;
	}

	// returns the number that the dice rolled last
	public int getDieFace()
	{
		return dieFace;
	}

	// returns the color
	public String color()
	{
		return color;
	}
}
