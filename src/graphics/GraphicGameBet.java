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
    private String player;
    
    
    public GraphicGameBet(Point pos, GameBet gameBet) 
    {
        this.pos = pos;
        this.gameBet = gameBet;
        colorHashMap = new HashMap<>();
        colorHashMap.put("yellow", Color.yellow);
        colorHashMap.put("green", Color.green);
        colorHashMap.put("blue", Color.blue);
        colorHashMap.put("orange", Color.orange);
        colorHashMap.put("white", Color.white);
    }
    
    public GraphicGameBet(Point pos, String player)
    {
    	this.pos = pos;
    	this.player = player;
    }
    
    public void draw(Graphics2D g, Color color)
    {
    	g.setColor(color);
    	int x = pos.x;
        int y = pos.y;

        g.setPaint(Color.BLACK);
        int thickness = 3;
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(thickness));
        g.fillRect(x, y, 50, 100);
        g.setColor(Color.white);
        Font oldFont = g.getFont();
        g.drawRect(x, y, 50, 100);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString(player, x + 15, y + 43);
        g.setStroke(oldStroke);
        g.setFont(oldFont);
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
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        graphics2D.drawString("L", x + 30, y + 85);
        graphics2D.drawString("W", x + 10, y + 85);
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.drawLine(x, y + 65,x+50, y+65);
        graphics2D.drawLine(x + 25, y + 65,x+25, y+100);




    }

    public GameBet getGameBet() {
        return gameBet;
    }

	@Override
	public boolean contains(int x, int y)
	{
		System.out.println(pos.x + " " + pos.y);
		if (x >= pos.x && x <= pos.x+50 && y >= pos.y && y <= pos.y+100)
		{
			System.out.println("yes");
			return true;
		}
		return false;
	}

	@Override
	public void update(Object obj)
	{
		// TODO Auto-generated method stub
		
	}

    public boolean containsWinner(int x, int y) {
        if (x > pos.x && x < pos.x + 25 && y > pos.y + 65 && y < pos.y + 100) {
            return true;
        }
        return false;
    }

    public boolean containsLoser(int x, int y) {
        if (x > pos.x + 25 && x < pos.x + 50 && y > pos.y + 65 && y < pos.y + 100) {
            return true;
        }
        return false;
    }




}
