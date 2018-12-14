package unit_tests;

import core.CamelUp;
import core.Dice;
import graphics.GraphicDice;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.*;

@SuppressWarnings("serial")
public class graphicsDiceTest extends JPanel {

    private static CamelUp gameState;

    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        graphicsDiceTest board = new graphicsDiceTest();
        window.add(board);
        gameState = new CamelUp();
        gameState.roll();
        gameState.roll();
        gameState.roll();
    }


    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawDiceRolled(graphics2D, gameState.getRolled());
        repaint();
    }

    public void drawDiceRolled(Graphics2D graphics2D, ArrayList<Dice> diceRolled) {

        int adjX = 0;
        for (Dice dice : diceRolled) {
            GraphicDice graphicDice = new GraphicDice(new Point(800 + adjX, 800), dice);
            graphicDice.draw(graphics2D);
            adjX += 125;
        }
    }
}