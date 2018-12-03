package Core;

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

	// gets the direction <o/. either -1 or 1 unless not initialized
	public int getDir()
	{
		return dir;
	}

	public String toString() {
		return "player" + player.getName() + "dir" + dir;
	}
}
