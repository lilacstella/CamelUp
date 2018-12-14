package core;

import java.util.ArrayList;
import java.util.Iterator;

//The Tile class is important because it represents the important feature of the desert tile in the sophisticated board game of camel up
//Below are some insightful explanation of the function of each method.
public class Tile
{
	private ArrayList<Camel> camels;
	private Trap trap;

	public Tile()
	{
		camels = new ArrayList<>();
	}

	// put a trap on the tile
	public void setTrap(Trap t)
	{
		trap = t;
	}

	public boolean hasTrap()
	{
		return trap != null;
	}

	// remove the trap from the tile and returns it
	public Trap removeTrap()
	{
		Trap t = trap;
		trap = null;
		return t;
	}

	// get the linkedList of camels for the graphics
	public ArrayList<Camel> getCamels()
	{
		return camels;
	}
	
	public ArrayList<Camel> remCamels(String color)
	{
		Iterator<Camel> iter = camels.iterator();
		Camel temp = null;
		ArrayList<Camel> list = new ArrayList<>();
		ArrayList<Camel> remaining = new ArrayList<>();
		while (iter.hasNext())
		{
			temp = iter.next();
			if (temp.getCamelColor().equals(color))
			{
				list.add(temp);
				break;
			}
			remaining.add(temp);
		}
		while (iter.hasNext())
			list.add(iter.next());
		camels = remaining;
		return list;
	}

	public int add(ArrayList<Camel> camel)
	{
		if(trap!=null)
			return trap.getDir();
		camels.addAll(camel);
		return 0;
	}

	public int add(ArrayList<Camel> camel, int index)
	{
		if(trap!=null)
			return trap.getDir();
		camels.addAll(index, camel);
		return 0;
	}
	
	public int add(Camel camel)
	{
		if(trap!=null)
			return trap.getDir();
		camels.add(camel);
		return 0;
	}

	public Trap getTrap() {
		return trap;
	}

	public boolean empty()
	{
		return getCamels().isEmpty();
	}

	public String toString() {
		String ret = "";
		ret += "\ntrap:" + trap + " ";
		ret += "camels " + camels;
		return ret;
	}

}
