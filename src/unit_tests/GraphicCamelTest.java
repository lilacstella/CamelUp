package unit_tests;

import core.Camel;
import core.CamelUp;
import core.Player;
import graphics.GraphicCamel;
import graphics.GraphicPlayer;

import javax.swing.*;
import java.awt.*;

public class GraphicCamelTest extends JPanel {
    private static CamelUp game;
    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicCamelTest board = new GraphicCamelTest();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        game = new CamelUp();
        game.roll();
        game.roll();
        game.roll();
        window.setExtendedState(JFrame.NORMAL);
        System.out.println(game);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawCamel(graphics2D);
        try {
            repaint();
        } catch (NullPointerException e) {

        }
    }


    public void drawCamel(Graphics2D graphics2D) {
        Camel camel = game.getRankCamel(1);
        System.out.println(camel.getCamelColor());
        GraphicCamel graphicCamel = new GraphicCamel(string2Color(camel.getCamelColor()));
        graphicCamel.draw(graphics2D);
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
