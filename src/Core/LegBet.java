package Core;
public class LegBet
{
	private int value;
	private String camelColor;

	public LegBet(int value, String camelColor)
	{
		setValue(value);
		setCamelColor(camelColor);
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public String getCamelColor()
	{
		return camelColor;
	}

	public int getValue()
	{
		return value;
	}

	public void setCamelColor(String camelColor)
	{
		this.camelColor = camelColor;
	}
}
