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

//        graphics2D.setColor(new Color(0, 255, 0, 100));
//        graphics2D.fillRect(x, y, 25, 100);
//        graphics2D.setColor(new Color(255, 0, 0, 100));
//        graphics2D.fillRect(x + 25, y , 25, 100);
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        graphics2D.drawString("-", x + 30, y + 85);
        graphics2D.drawString("+", x + 10, y + 85);



    }

    public GameBet getGameBet() {
        return gameBet;
    }

	@Override
	public boolean contains(int x, int y)
	{
		if (x >= pos.x && x <= pos.x+50 && y - 50 >= pos.y && y <= pos.y+75)
			return true;
		return false;
	}

	@Override
	public void update(Object obj)
	{
		// TODO Auto-generated method stub
		
	}

    public boolean containsWinner(int x, int y) {
        if (x > pos.x && x < pos.x + 25 && y > pos.y && y < pos.y + 100) {
            return true;
        }
        return false;
    }




}
