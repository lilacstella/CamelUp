import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

//The Tile class is important because it represents the important feature of the desert tile in the sophisticated board game of camel up
//Below are some insightful explanation of the function of each method.
public class Tile
{
	private ArrayList<Camel> camels;
	private Trap trap;

	public Tile()
	{
		camels = new ArrayList<Camel>();
	}

	// put a trap on the tile
	public void setTrap(Trap t)
	{
		trap = t;
	}

	// remove the trap from the tile and returns it
	public Trap removeTrap()
	{
		Trap t = trap;
		trap = null;
		return t;
	}

	// get the linkedList of camels for the graphics
	public ArrayList<Camel> getCamel(String color)
	{
		// ask Stroud if we are allowed to use the remove(Object) of linked list
		// or iterator because it kind of breaks the law of Queues
		Iterator<Camel> iter = camels.iterator();
		Camel temp = null;
		ArrayList<Camel> list = new ArrayList<>();
		while (iter.hasNext())
		{
			temp = iter.next();
			if (temp.getCamelColor().equals(color))
			{
				list.add(iter.next());
				break;
			}
		}
		while(iter.hasNext())
				list.add(iter.next());
		return list;
	}

	public void add(ArrayList<Camel> camel)
	{
		camels.addAll(camel);
	}

	public void add(ArrayList<Camel> camel, int index)
	{
		camels.addAll(0,camel);
	}

	public boolean empty()
	{
		return camels.isEmpty();
	}
}
