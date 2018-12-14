package core;

public class Camel
{
	private String color;
	private int lap;

	public Camel(String c)
	{
		color = c;
		lap = 0;
	}

	// get the getColor of the camel
	public String getCamelColor()
	{
		return color;
	}

	public String toString() {
		return getCamelColor().toUpperCase().substring(0, 1);
	}
	
	public void addLap()
	{
		lap++;
	}
	
	public int getLap()
	{
		return lap;
	}
}
