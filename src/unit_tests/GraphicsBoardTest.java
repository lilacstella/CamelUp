package unit_tests;

import core.CamelUp;

import javax.swing.*;
import java.awt.*;

public class GraphicsBoardTest extends JPanel {
    private static CamelUp gameState;
    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicPlayerTest board = new GraphicPlayerTest();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gameState = new CamelUp();
        window.setExtendedState(JFrame.NORMAL);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
    }



}
