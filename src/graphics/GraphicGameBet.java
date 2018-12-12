package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.HashMap;

import core.GameBet;

public class GraphicGameBet implements GraphicUI
{
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
        graphics2D.fillRect(x, y, 50, 100);
        graphics2D.setPaint(Color.BLACK);
        int thickness = 3;
        Stroke oldStroke = graphics2D.getStroke();
        graphics2D.setStroke(new BasicStroke(thickness));
        graphics2D.drawRect(x, y, 50, 100);
        Font oldFont = graphics2D.getFont();
        graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        graphics2D.drawString(gameBet.getPlayerName(), x + 15, y + 43);
        graphics2D.setStroke(oldStroke);
        graphics2D.setFont(oldFont);
    }

	@Override
	public boolean contains(int x, int y)
	{
		if (x >= pos.x && x <= pos.x && y >= pos.y && y <= pos.y)
			return true;
		return false;
	}

	@Override
	public void update(Object obj)
	{
		// TODO Auto-generated method stub
		
	}




}
