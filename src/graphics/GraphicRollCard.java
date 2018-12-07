package graphics;

import java.awt.*;

public class GraphicRollCard {

    private Point pos;

    public GraphicRollCard(Point pos) {
        this.pos = pos;
    }

    public void draw(Graphics2D graphics2D) {

        int x = pos.x;
        int y = pos.y;


        graphics2D.setColor(new Color(218,165,32)); // goldenrod i think? i dunno i got it from google
        graphics2D.fill(new Rectangle(x, y, 100, 200));
        graphics2D.setPaint(Color.BLACK);
        int thickness = 3;
        Stroke oldStroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(thickness));
        graphics2D.drawRect(x, y, 100, 200);
        Font oldFont = graphics2D.getFont();
        graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        graphics2D.drawString("1", x + 40, y + 105);
        graphics2D.setStroke(oldStroke);
        graphics2D.setFont(oldFont);
    }


}
