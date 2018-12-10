package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import core.Camel;
import core.Tile;
import core.Trap;

public class GraphicTile
{
	int x,y;
	ArrayList<GraphicCamel> list;
	GraphicTrap trap;
	public GraphicTile(int x, int y, ArrayList<Camel> camels, Trap trap)
	{
		this.x = x;
		this.y = y;
		list = new ArrayList<GraphicCamel>();
		for(int i = 0; i < camels.size(); i++)
			list.add(new GraphicCamel(string2Color(camels.get(i).getCamelColor()), new Point(x+50,y+50),i));
		if(trap!=null)
			this.trap = new GraphicTrap(x,y,trap);
	}
	
	
	
	public GraphicTile(int x, int y, Tile tile)
	{
		this.x = x;
		this.y = y;
		list = new ArrayList<GraphicCamel>();
		for(int i = 0; i < tile.getCamels().size(); i++)
			list.add(new GraphicCamel(string2Color(tile.getCamels().get(i).getCamelColor()), new Point(x+50,y+50),i));
		if(tile.getTrap()!=null)
			this.trap = new GraphicTrap(x,y,tile.getTrap());
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
//		g.setColor(new Color(255,218,185));
//		g.fillRect(x, y, 100, 100);
		g.setColor(Color.ORANGE);
		g.fillRect(x,y,100,100);
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(3));
		g.draw(new Rectangle(x,y,100,100));
		for(GraphicCamel camel : list)
			camel.draw(g);
		trap.draw(g);
	}
}