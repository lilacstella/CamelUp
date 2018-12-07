package graphics;

import core.CamelUp;
import core.Player;

import javax.swing.*;
import java.awt.*;

public class GraphicPlayerTest extends JPanel {
    private static CamelUp gameState;
    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicPlayerTest board = new GraphicPlayerTest();
        window.add(board);
        gameState = new CamelUp();
        gameState.legBet("blue");
        gameState.legBet("blue");
        gameState.legBet("yellow");
        gameState.legBet("green");
        gameState.legBet("blue");
        gameState.roll();
        gameState.roll();
        gameState.roll();
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawPlayer(graphics2D);
        try {
            repaint();
        } catch (NullPointerException e) {

        }
    }


    public void drawPlayer(Graphics2D graphics2D) {
        Player player = gameState.getCurrentPlayer();
        GraphicPlayer graphicPlayer = new GraphicPlayer(new Point(100, 100), player);
        graphicPlayer.draw(graphics2D);
    }




}
