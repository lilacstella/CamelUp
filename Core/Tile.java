import java.util.ConcurrentModificationException;
import java.util.Iterator;
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
	public Camel getCamel(String color)
	{
		// ask Stroud if we are allowed to use the remove(Object) of linked list
		// or iterator because it kind of breaks the law of Queues
		Iterator<Camel> iter = camels.iterator();
		Camel temp = null;
		try
		{
			while (iter.hasNext())
			{
				temp = iter.next();
				if (temp.getCamelColor().equals(color))
					camels.remove(temp);
			}
		} catch (ConcurrentModificationException e){}
		return temp;
	}

	public boolean empty()
	{
		return camels.isEmpty();
	}
}
