package unit_tests;

import core.CamelUp;
import core.GameBet;
import core.LegBet;
import graphics.GraphicGameBet;
import graphics.GraphicLegBet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class graphicLegBetTest extends JPanel {

    private static CamelUp gameState;

    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        graphicLegBetTest board = new graphicLegBetTest();
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
        drawPlayerLegBets(graphics2D);
        try {
            repaint();
        } catch (NullPointerException e) {

        }
    }

    public void drawPlayerLegBets(Graphics2D graphics2D) {
        ArrayList<LegBet> legBets = gameState.getCurrentPlayer().getLegBets();
        int adjX = 0;
        for (LegBet legBet : legBets) {
            GraphicLegBet graphicLegBet = new GraphicLegBet(new Point(500 + adjX, 500), legBet);
            graphicLegBet.draw(graphics2D);
            adjX += 125;
        }
    }



}
