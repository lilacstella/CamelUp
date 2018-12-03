public class Camel
{
	private String color;

	public Camel(String c)
	{
		color = c;
	}

	// get the getColor of the camel
	public String getCamelColor()
	{
		return color;
	}

	public String toString() {
		return getCamelColor().toUpperCase().substring(0, 1);
	}
}