import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;

public class Poly extends JPanel {

    private Path2D prettyPoly;


    public Poly() {

        prettyPoly = new Path2D.Double();
        boolean isFirst = true;
        for (int points = 0; points < (int)Math.round(Math.random() * 100); points++) {
            double x = Math.random() * 300;
            double y = Math.random() * 300;

            if (isFirst) {
                prettyPoly.moveTo(x, y);
                isFirst = false;
            } else {
                prettyPoly.lineTo(x, y);
            }
        }

        prettyPoly.closePath();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                System.out.println(prettyPoly.contains(p));

                repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.draw(prettyPoly);
        g2d.dispose();

    }
}