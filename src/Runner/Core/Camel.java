package Core;

public class Camel
{
	private String color;

	public Camel(String c)
	{
		color = c;
	}

	// get the color of the camel
	public String getCamelColor()
	{
		return color;
	}

	public String toString() {
		return getCamelColor().toUpperCase().substring(0, 1);
	}
}