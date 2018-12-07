package graphics;

import core.GameBet;

import java.awt.*;
import java.util.HashMap;

public class GraphicGameBet {
    private GameBet gameBet;
    private Point pos;
    private HashMap<String, Color> colorHashMap;

    public GraphicGameBet(Point pos, GameBet gameBet) {
        this.pos = pos;
        this.gameBet = gameBet;
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

        graphics2D.setColor(colorHashMap.get(gameBet.getCamelColor()));
        graphics2D.fill(new Rectangle(x, y, 100, 200));
        graphics2D.setPaint(Color.BLACK);
        int thickness = 3;
        Stroke oldStroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(thickness));
        graphics2D.drawRect(x, y, 100, 200);
        Font oldFont = graphics2D.getFont();
        graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        graphics2D.drawString(gameBet.getPlayerName(), x + 30, y + 105);
        graphics2D.setStroke(oldStroke);
        graphics2D.setFont(oldFont);
    }




}
