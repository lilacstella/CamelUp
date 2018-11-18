public class Trap 
{
	private final int dir;
	private Player player;
	
	public Trap(Player p, int d) 
	{
		player = p;
	}
	//gives player 1 coin after camel jumps on it
	public void trigger()
	{
		player.setCoins(player.getCoins()+1);
	}
	//set the direction the trap moves the camel
	public void setDir(int dir)
	{
		this.dir = dir;
	}
	//gets the direction <o/
	public int getDir()
	{
		return dir;
	}
}
