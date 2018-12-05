package graphics;

import core.Dice;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;


public class GraphicDice
{
    private Point pos;
    Dice dice;
    public GraphicDice(Point point, Dice dice)
    {
        pos = point;
        this.dice = dice;
    }

    public void draw(Graphics2D graphics2D) {
        
    }





//    public ArrayList<Shape> draw()
//    {
//        ArrayList<Shape> shapes = new ArrayList<Shape>();
//        shapes.add(new Rectangle((int)pos.getX(), (int)pos.getY(), 100, 100));
//        if(getDieFace() == 1)
//            shapes.add(new Ellipse2D.Double(pos.getX() + 50, pos.getY() + 50, 10, 10));
//        else if(super.getDieFace() == 2)
//        {
//            shapes.add(new Ellipse2D.Double(pos.getX() + 25, pos.getY() + 25, 10, 10));
//            shapes.add(new Ellipse2D.Double(pos.getX() + 75, pos.getY() + 75, 10, 10));
//        }
//        else if(super.getDieFace() == 3)
//        {
//            shapes.add(new Ellipse2D.Double(pos.getX()+50, pos.getY()+50, 10, 10));
//            shapes.add(new Ellipse2D.Double(pos.getX() + 25, pos.getY() + 25, 10, 10));
//            shapes.add(new Ellipse2D.Double(pos.getX() + 75, pos.getY() + 75, 10, 10));
//        }
//        return shapes;
//    }
}