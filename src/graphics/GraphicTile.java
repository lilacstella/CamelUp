package graphics;


import java.awt.*;

import core.Camel;
import java.util.ArrayList;

public class GraphicTile
{
	int x,y;
	ArrayList<GraphicCamel> list;
	public GraphicTile(int x, int y, ArrayList<Camel> camels)
	{
		this.x = x;
		this.y = y;
		list = new ArrayList<GraphicCamel>();
		for(int i = 0; i < camels.size(); i++)
			list.add(new GraphicCamel(string2Color(camels.get(i).getCamelColor()), new Point(x+50,y+50),i));
	}
	
	
	
	public Color string2Color(String string)
	    {
	        switch(string)
	        {
	            //not sure if these are the colors just testing
	            case("blue"):return Color.blue;
	            case("green"):return Color.green;
	            case("yellow"):return Color.yellow;
	            case("orange"):return Color.orange;
	            case("white"):return Color.white;
	            default: return null;
	        }
	    }



	public void draw(Graphics2D g)
	{
		g.setColor(new Color(255,218,185));
		g.fillRect(x, y, 100, 100);
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(3));
		g.draw(new Rectangle(x,y,100,100));
		for(GraphicCamel camel : list)
			camel.draw(g);
	}
}