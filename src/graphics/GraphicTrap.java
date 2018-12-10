package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import core.Trap;

public class GraphicTrap
{
	private Trap trap;
	private int x,y;
	private static final Color COLOR = new Color(166,128,100);
	
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
		g.setFont(new Font("COMIC SANS MS", Font.BOLD, 20));
		g.drawString(trap.getPlayerName(),x+40,y+30);
		g.drawOval(x + 25, y + 35, 50,50);
		g.setFont(new Font("COMIC SANS MS", Font.BOLD, 30));
		g.drawString(""+trap.getDir(),x+42,y+70);
		g.setColor(Color.black);
	}
}