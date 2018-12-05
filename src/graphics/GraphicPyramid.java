package graphics;

import core.Dice;
import core.Pyramid;

import java.awt.Point;
import java.awt.Shape;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;


public class GraphicPyramid
{
    private Point pos;
    public GraphicPyramid()
    {

        pos = new Point(1100,100);
    }

    public ArrayList<Shape> draw()
    {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        for(int i = 0; i<8;i+=2)
        	shapes.add(new Rectangle((int)pos.getX()-i*25, (int)pos.getY()-i*25, 300-i*25, 300-i*25));
        return shapes;
    }
    

}