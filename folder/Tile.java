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
	public Trap getTrap()
	{
		return trap;
	}
	public void setTrap(Trap t)
	{
		trap = t;
	}
	public Trap RemoveTrap()
	{
		Trap t = trap;
		trap = null;
		return t;
	}
	public linkedlist<Camel> getCamel()
	{
		return camels;
	}
}
