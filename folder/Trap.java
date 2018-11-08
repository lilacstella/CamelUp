
public class Trap 
{
	private boolean isForward;
	private Player player;
	private int pos;
	public Trap(Player p) 
	{
		player = p;
	}
	
	public void trigger()
	{
		player.setCoins(player.getCoins()+1);
	}
	public void setPos(int p)
	{
		pos = p;
	}
	public void setForward(boolean f)
	{
		isForward = f;
	}
}
