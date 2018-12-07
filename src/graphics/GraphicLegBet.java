package graphics;

import core.LegBet;

import javax.swing.text.Position;
import java.awt.*;
import java.util.HashMap;

public class GraphicLegBet {
    private LegBet legBet;
    private Point pos;
    private HashMap<String, Color> colorHashMap;

    public GraphicLegBet(Point pos, LegBet legBet) {
        this.pos = pos;
        this.legBet = legBet;
        colorHashMap = new HashMap<>();
        colorHashMap.put("yellow", Color.yellow);
        colorHashMap.put("green", Color.green);
        colorHashMap.put("blue", Color.blue);
        colorHashMap.put("orange", Color.orange);
        colorHashMap.put("white", Color.white);
    }


    public void draw(Graphics2D graphics2D) {

        int x = pos.x;
        int y = pos.y;

        if (legBet == null) {
            graphics2D.setPaint(Color.BLACK);
            int thickness = 3;
            Stroke oldStroke = graphics2D.getStroke();
            graphics2D.setStroke(new BasicStroke(thickness));
            graphics2D.drawRect(x, y, 50, 100);
            graphics2D.setStroke(oldStroke);
            return;
        }


        graphics2D.setColor(colorHashMap.get(legBet.getCamelColor()));
        graphics2D.fill(new Rectangle(x, y, 50, 100));
        graphics2D.setPaint(Color.BLACK);
        int thickness = 3;
        Stroke oldStroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(thickness));
        graphics2D.drawRect(x, y, 50, 100);
        Font oldFont = graphics2D.getFont();
        graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        graphics2D.drawString(Integer.toString(legBet.getValue()), x + 20, y + 43);
        graphics2D.setStroke(oldStroke);
        graphics2D.setFont(oldFont);


    }
}
