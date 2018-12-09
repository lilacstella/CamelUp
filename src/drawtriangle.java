
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class drawtriangle extends JPanel {
    public static void main(String[] args) {
        JFrame window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1600, 1200);
        window.setVisible(true);
        drawtriangle board = new drawtriangle();
        window.add(board);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setExtendedState(JFrame.NORMAL);
    }


    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;

        Path2D path2D = new Path2D.Double();
        path2D.moveTo(500, 500);
        path2D.lineTo(600, 600);
        path2D.lineTo(400, 600);
        path2D.lineTo(500, 500);
        path2D.closePath();

        graphics2D.setColor(Color.blue);

        graphics2D.fill(path2D);

    }



}
