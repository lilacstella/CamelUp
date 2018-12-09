package graphics;

import java.awt.Color;
import java.awt.Graphics2D;

import core.Trap;

public class GraphicTrap
{
	private Trap trap;
	private int x,y;
	private static final Color COLOR = new Color(40,155,24);
	
	public GraphicTrap(int x, int y, Trap trap)
	{
		this.trap = trap;
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(COLOR);
		g.drawString(trap.getPlayerName(),x+45,y+30);
		g.drawOval(x + 50, y+50, 10,10);
		g.drawString(""+trap.getDir(),x+50,y+50);
		g.setColor(Color.black);
	}
}