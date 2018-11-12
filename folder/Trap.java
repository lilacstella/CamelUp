public class Trap 
{
	private int dir;
	private Player player;
	public Trap(Player p) 
	{
		player = p;
	}
	//gives player 1 coin after camel jumps on it
	public void trigger()
	{
		player.setCoins(player.getCoins()+1);
	}
	//set the direction the trap moves the camel
	public void setDirection(int dir)
	{
		this.dir = dir;
	}
}
