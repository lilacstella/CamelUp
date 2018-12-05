package graphics;

import core.CamelUp;

import javax.swing.*;
import java.awt.*;

public class GraphicBoard extends JPanel {

    private CamelUp gameState = new CamelUp();

    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicBoard board = new GraphicBoard();
        window.add(board);
    }


    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
    }

    public void drawDiceRolled(Graphics2D graphics2D) {

    }


}
