package graphics;

import core.Dice;
import core.Pyramid;

import java.awt.Point;
import java.awt.Shape;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;


public class GraphicPyramid extends Pyramid
{
    private Point pos;
    public GraphicPyramid()
    {
        super();
        die.clear();
        pos = new Point(1100,100);
    }

    public ArrayList<Shape> draw()
    {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        for(int i = 0; i<8;i+=2)
        	shapes.add(new Rectangle((int)pos.getX()-i*25, (int)pos.getY()-i*25, 300-i*25, 300-i*25));
        return shapes;
    }
    
    @Override
    public void reset()
	{
    	die.clear();
		die.add(new GraphicDice(new Point(500,200),"blue"));
		die.add(new GraphicDice(new Point(600,200),"yellow"));
		die.add(new GraphicDice(new Point(700,200),"orange"));
		die.add(new GraphicDice(new Point(800,200), "green"));
		die.add(new GraphicDice(new Point(900,200),"white"));
		Iterator<Dice> iter = die.iterator();
		while (iter.hasNext())
			iter.next().rollDice();
	}
}