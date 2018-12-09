package unit_tests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.Player;
import core.Tile;
import core.Trap;
import graphics.GraphicTile;

//import core.Camel;
//import core.CamelUp;

@SuppressWarnings("serial")
public class GraphicTrapTest extends JPanel {
//    private static CamelUp game;
    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicTrapTest board = new GraphicTrapTest();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setExtendedState(JFrame.NORMAL);
    }

    public void paintComponent(Graphics graphics) 
    {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawTile(graphics2D);
        try {
            repaint();
        } catch (NullPointerException e) {

        }
    }


    public void drawTile(Graphics2D g) 
    {
    	Tile thing = new Tile();
    	thing.setTrap(new Trap(new Player("P1"),1));
    	GraphicTile tile = new GraphicTile(500,500,thing);
    	tile.draw(g);
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





}
