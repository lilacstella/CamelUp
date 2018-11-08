
public class Camel 
{
	private String color;
	private int pos;
	public Camel(String c) 
	{
		color = c;
		pos = 0;
	}
	public int move(int num)
	{
		pos += num;
		return pos;
	}
	public String getCamelColor()
	{
		return color;
	}
}
