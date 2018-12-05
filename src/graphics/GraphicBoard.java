package graphics;

import javax.swing.*;

public class GraphicBoard extends JFrame {
    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        GraphicBoard board = new GraphicBoard();
        window.add(board);
    }
}
