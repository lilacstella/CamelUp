public class Trap 
{
	private boolean isForward;
	private Player player;
	private int pos;
	public Trap(Player p) 
	{
		player = p;
	}
	//gives player 1 coin after camel jumps on it
	public void trigger()
	{
		player.setCoins(player.getCoins()+1);
	}
	//set the position
	public void setPos(int p)
	{
		pos = p;
	}
	//set the direction the trap moves the camel
	public void setForward(boolean f)
	{
		isForward = f;
	}
}
