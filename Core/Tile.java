import java.util.LinkedList;

//The Tile class is important because it represents the important feature of the desert tile in the sophisticated board game of camel up
//Below are some insightful explanation of the function of each method.
public class Tile  
{
	private LinkedList<Camel> camels;
	private Trap trap;
	public Tile() 
	{
		camels = new LinkedList<Camel>();
	}
	//returns the trap
	public Trap getTrap()
	{
		return trap;
	}
	//put a trap on the tile
	public void setTrap(Trap t)
	{
		trap = t;
	}
	//remove the trap from the tile and returns it 
	public Trap removeTrap()
	{
		Trap t = trap;
		trap = null;
		return t;
	}
	//get the linkedList of camels for the graphics
	public LinkedList<Camel> getCamel()
	{
		return camels;
	}
}
