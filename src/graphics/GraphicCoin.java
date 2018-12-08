package graphics;

import java.awt.*;
import java.util.HashMap;

public class GraphicCoin {
    private int coinVal;
    private Point pos;
    private static HashMap<Integer, Color> colorHashMap = new HashMap<>();

    public GraphicCoin(Point pos, int coinVal) {
        this.pos = pos;
        this.coinVal = coinVal;
        colorHashMap.put(1, new Color(205, 127, 50)); //bronze
        colorHashMap.put(5, new Color(192,192,192)); //silver
        colorHashMap.put(10, new Color(255,215,0));
    }

    public void draw(Graphics2D graphics2D) {

        graphics2D.setColor(colorHashMap.get(coinVal));
        graphics2D.fillOval(pos.x, pos.y, 35, 35);

        graphics2D.setPaint(Color.BLACK);
        int thickness = 3;
        Stroke oldStroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(thickness));
        graphics2D.drawOval(pos.x, pos.y, 35, 35);

        graphics2D.setFont(new Font("COMIC SANS MS", Font.BOLD, 15));
        if(coinVal != 10)
            graphics2D.drawString(Integer.toString(coinVal), pos.x + 14, pos.y + 25);
        else
            graphics2D.drawString(Integer.toString(coinVal), pos.x + 8, pos.y + 25);



        graphics2D.setStroke(oldStroke);

    }




}


