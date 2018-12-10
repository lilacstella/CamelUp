package graphics;

import java.awt.Color;
import java.awt.Font;
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
		g.fillRect(x+10, y+10, 80, 80);
		g.setColor(Color.BLACK);
		g.setFont(new Font("COMIC SANS MS", Font.BOLD, 15));
		g.drawString(trap.getPlayerName(),x+45,y+30);
		g.drawOval(x + 25, y+ 40, 50,50);
		g.drawString(""+trap.getDir(),x+50,y+50);
		g.setColor(Color.black);
	}
}