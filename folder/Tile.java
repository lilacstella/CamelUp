import java.util.LinkedList;

public class Tile 
{
	private Camel camel;
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
	//set a trap
	public void setTrap(Trap t)
	{
		trap = t;
	}
	//remove the trap
	public Trap RemoveTrap()
	{
		Trap t = trap;
		trap = null;
		return t;
	}
	//get the linkedList of camels
	public LinkedList<Camel> getCamel()
	{
		return camels;
	}
}
