package unit_tests;

import core.CamelUp;
import core.GameBet;
import graphics.GraphicGameBet;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class GraphicsGameBetTest extends JPanel {

    private static CamelUp gameState;

    public static void main(String[] args) throws InterruptedException {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicsGameBetTest board = new GraphicsGameBetTest();
        window.add(board);
        gameState = new CamelUp();
        TimeUnit.SECONDS.sleep(6);
        gameState.gameBet("blue", true);


    }


    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawPlayerGameBets(graphics2D);
        repaint();
    }




    public void drawPlayerGameBets(Graphics2D graphics2D) {
        ArrayList<GameBet> gameBets = gameState.getCurrentPlayer().getGameBets();
        int adjX = 0;
        for (GameBet gameBet : gameBets) {
            GraphicGameBet graphicGameBet = new GraphicGameBet(new Point(500 + adjX, 500), gameBet);
            graphicGameBet.draw(graphics2D);
            adjX += 125;
        }
    }




}