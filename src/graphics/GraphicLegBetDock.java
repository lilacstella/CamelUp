package graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import core.LegBet;

public class GraphicLegBetDock implements GraphicUI
{

    private Point pos;
    private ArrayList<LegBet> topCards;
    int adjX;

    public GraphicLegBetDock(Point pos, ArrayList<LegBet> topCards) {
        this.pos = pos;
        this.topCards = topCards;
        adjX = 0;
    }


    public void draw(Graphics2D graphics2D) {
        int x = pos.x;
        int y = pos.y;

        for (LegBet legBet : topCards) {
            GraphicLegBet graphicLegBet = new GraphicLegBet(new Point(x + adjX, y), legBet);
            graphicLegBet.draw(graphics2D);
            adjX += 60;
        }
    }


	@Override
	public boolean contains(int x, int y)
	{
		if(x >= pos.x && x <= pos.x+50+adjX && y >= pos.y && y<= pos.y+100)
			return true;
		return false;
	}


	@SuppressWarnings("unchecked")
	@Override
	public void update(Object obj)
	{
		topCards = (ArrayList<LegBet>) obj;
	}




}
