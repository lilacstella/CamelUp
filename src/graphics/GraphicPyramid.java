package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class GraphicPyramid implements GraphicUI
{
	private Point pos;
	public GraphicPyramid()
	{
		this.pos = new Point(1275,550);	
	}
	@Override
	public void draw(Graphics2D g2)
	{
		for (int i = 0; i < 6; i++)
		{
			g2.setColor(new Color(244 - i * 10, 182 - i * 10, 66 - i * 10));
			g2.fillRect(1275 + i * 25, 550 + i * 25, 300 - i * 50, 300 - i * 50);
			g2.setColor(Color.BLACK);
			g2.drawRect(1275 + i * 25, 550 + i * 25, 300 - i * 50, 300 - i * 50);
		}
	}

	@Override
	public boolean contains(int x, int y)
	{
		System.out.println("hello");
		if(x >= pos.x && x <= pos.x+300 && y >= pos.y && y<= pos.y+300)
			return true;
		return false;
	}

	@Override
	public void update(Object obj)
	{
		// TODO Auto-generated method stub
		
	}
	
}
