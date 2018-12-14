package unit_tests;

import core.CamelUp;
import graphics.GraphicRollCard;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GraphicRollCardTest extends JPanel {
    private static CamelUp gameState;
    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicRollCardTest board = new GraphicRollCardTest();
        window.add(board);
        gameState = new CamelUp();
        gameState.roll();
        gameState.roll();
        gameState.roll();
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawRollCards(graphics2D);
        try {
            repaint();
        } catch (NullPointerException e) {

        }
    }


    public void drawRollCards(Graphics2D graphics2D) {
        int rollCards = gameState.getCurrentPlayer().getRollCards();
        int adjX = 0;

        for(int i = 0; i < rollCards; i++) {
            GraphicRollCard graphicRollCard = new GraphicRollCard(new Point(500 + adjX, 500));
            graphicRollCard.draw(graphics2D);
            adjX += 125;
        }
    }

}