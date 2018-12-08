package unit_tests;

import core.CamelUp;
import graphics.GraphicCoin;

import javax.swing.*;
import java.awt.*;

public class GraphicCoinTest extends JPanel {

    private static CamelUp gameState;

    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicCoinTest board = new GraphicCoinTest();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gameState = new CamelUp();
        gameState.getCurrentPlayer().setCoins(36);
        window.setExtendedState(JFrame.NORMAL);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawCoins(graphics2D);
        try {
            repaint();
        } catch (NullPointerException e) {

        }
    }

    public void drawCoins(Graphics2D graphics2D) {
        int adjX = 0;
        int coins = gameState.getCurrentPlayer().getCoins();
        while (coins != 0) {

            if (coins >= 10) {
                GraphicCoin coin = new GraphicCoin(new Point(100 + adjX, 100), 10);
                coins -= 10;
                coin.draw(graphics2D);
            } else if (coins >= 5) {
                GraphicCoin coin = new GraphicCoin(new Point(100 + adjX, 100), 5);
                coins -= 5;
                coin.draw(graphics2D);
            } else {
                GraphicCoin coin = new GraphicCoin(new Point(100 + adjX, 100), 1);
                coins -= 1;
                coin.draw(graphics2D);
            }

            adjX += 60;

        }

    }


}
