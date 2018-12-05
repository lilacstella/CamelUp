package graphics;

import core.Dice;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;


public class GraphicDice
{
    private Point pos;
    private Dice dice;
    public GraphicDice(Point point, Dice dice)
    {
        pos = point;
        this.dice = dice;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setPaint(Color.BLACK);

        int x = pos.x;
        int y = pos.y;


        switch (dice.getDieFace()) {

            case 1:

                graphics2D.fillOval(x + 43, y + 43, 15, 15);
                break;

            case 2:

                graphics2D.fillOval(x+18, y+68, 15, 15);
                graphics2D.fillOval(x+68, y+18, 15, 15);
                break;

            case 3:

                graphics2D.fillOval(x+18, y+68, 15, 15);
                graphics2D.fillOval(x+43, y+43, 15, 15);
                graphics2D.fillOval(x+68, y+18, 15, 15);
                break;

            case 4:

                graphics2D.fillOval(x+23, y+23, 15, 15);
                graphics2D.fillOval(x+63, y+63, 15, 15);
                graphics2D.fillOval(x+23, y+63, 15, 15);
                graphics2D.fillOval(x+63, y+23, 15, 15);
                break;

            case 5:

                graphics2D.fillOval(x+23, y+23, 15, 15);
                graphics2D.fillOval(x+63, y+63, 15, 15);
                graphics2D.fillOval(x+23, y+63, 15, 15);
                graphics2D.fillOval(x+63, y+23, 15, 15);
                graphics2D.fillOval(x+43, y+43, 15, 15);
                break;

            case 6:

                graphics2D.fillOval(x+13, y+13, 15, 15);
                graphics2D.fillOval(x+43, y+13, 15, 15);
                graphics2D.fillOval(x+73, y+13, 15, 15);
                graphics2D.fillOval(x+13, y+73, 15, 15);
                graphics2D.fillOval(x+43, y+73, 15, 15);
                graphics2D.fillOval(x+73, y+73, 15, 15);
                break;

            default:
                break;
        }
    }
}