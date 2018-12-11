package unit_tests;

import core.CamelUp;
import graphics.GraphicLegBetDock;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GraphicLegBetDockTest extends JPanel {
    private static CamelUp gameState;
    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicLegBetDockTest board = new GraphicLegBetDockTest();
        window.add(board);
        gameState = new CamelUp();
        gameState.legBet("blue");
        gameState.legBet("blue");
        gameState.legBet("yellow");
        gameState.legBet("green");
        gameState.legBet("blue");
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawLegBetDock(graphics2D);
        try {
            repaint();
        } catch (NullPointerException e) {

        }
    }


    public void drawLegBetDock(Graphics2D graphics2D) {
        GraphicLegBetDock graphicLegBetDock = new GraphicLegBetDock(new Point(500, 500), gameState.getTopLegs());
        graphicLegBetDock.draw(graphics2D);
    }

}
