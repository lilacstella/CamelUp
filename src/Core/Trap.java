public class Trap
{
	private int dir;
	private Player player;

	public Trap(Player p, int d)
	{
		dir = d;
		player = p;
	}

	// gives player 1 coin after camel jumps on it
	public void trigger()
	{
		player.setCoins(player.getCoins() + 1);
	}

	// gets the direction <o/
	public int getDir()
	{
		return dir;
	}
}
