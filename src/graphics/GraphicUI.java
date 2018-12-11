package graphics;

import java.awt.Graphics2D;

public interface GraphicUI
{
	public void draw(Graphics2D g2);
	public boolean contains(int x, int y);
	public void update(Object obj);
}
