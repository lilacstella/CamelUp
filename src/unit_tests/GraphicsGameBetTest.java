package unit_tests;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.CamelUp;
import core.GameBet;
import graphics.GraphicGameBet;

@SuppressWarnings("serial")
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
        gameState.gameBet("green", true);


    }


    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawPlayerGameBets(graphics2D);
        repaint();
    }




    public void drawPlayerGameBets(Graphics2D graphics2D) {
        ArrayList<GameBet> gameBets = gameState.getCurrentPlayer().getGameBets();
        System.out.println(gameState.getCurrentPlayer().getGameBets());
        int adjX = 0;
        for (GameBet gameBet : gameBets) {
            GraphicGameBet graphicGameBet = new GraphicGameBet(new Point(500 + adjX, 500), gameBet);
            graphicGameBet.draw(graphics2D);
            adjX += 125;
        }
    }




}