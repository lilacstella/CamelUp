package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import core.CamelUp;
import core.Dice;
import core.LegBet;
import core.Player;

@SuppressWarnings("serial")
public class GraphicBoard extends JPanel implements MouseListener
{
	private static JFrame window;
	private static CamelUp game;
	private static Point[] trackPositions;
	private GraphicTile[] track;
	private GraphicPyramid pyramid;
	private HashMap<String, GraphicLegBet> legBets;
	private Stack<GraphicGameBet> winnerBets;
	private Stack<GraphicGameBet> loserBets;
	private Timer timer;

	// recreate game structure with graphic classes
	public GraphicBoard()
	{
		track = new GraphicTile[16];
		pyramid = new GraphicPyramid();
		legBets = new HashMap<String, GraphicLegBet>();
		for (int i = 0; i < trackPositions.length; i++)
			track[i] = new GraphicTile(trackPositions[i].x, trackPositions[i].y, game.getTrack()[i]);
		winnerBets = new Stack<GraphicGameBet>();
		loserBets = new Stack<GraphicGameBet>();
//		int adjX = 0;
//		for(LegBet card : game.getTopLegs())
//			switch(card.getCamelColor())
//			{
//			case("blue"): legBets.put("blue", new GraphicLegBet(new Point(180+adjX,275),card)); adjX+=60;break;
//			case("yellow"): legBets.put("yellow", new GraphicLegBet(new Point(180+adjX,275),card)); adjX+=60;break;
//			case("green"): legBets.put("green", new GraphicLegBet(new Point(180+adjX,275),card)); adjX+=60;break;
//			case("orange"):legBets.put("orange", new GraphicLegBet(new Point(180+adjX,275),card)); adjX+=60;break;
//			case("white"):legBets.put("white", new GraphicLegBet(new Point(180+adjX,275),card)); adjX+=60;break;
//			}
	}

	public void paintComponent(Graphics graphics)
	{
		double x = MouseInfo.getPointerInfo().getLocation().getX() - window.getLocationOnScreen().x;
		double y = MouseInfo.getPointerInfo().getLocation().getY() - window.getLocationOnScreen().y;
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		drawDiceRolled(g);
		drawPlayer(g);
		drawLegBetDock(g);
		drawLeaderBoard(g);
		drawGameBetDock(g);
		drawBoard(g);
		g.setStroke(new BasicStroke(3));
		g.draw(new Line2D.Double(x-5,y,x+5,y));
		g.draw(new Line2D.Double(x,y-5,x,y+5));
		repaint();
	}

	public void drawGameBetDock(Graphics2D g)
	{
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(3));
		g.drawString("Win",675,150);
		g.drawString("Lose",875,150);
		g.drawRect(600, 200, 200, 400);
		g.drawRect(800, 200, 200, 400);
		if (!winnerBets.isEmpty())

		try
		{
			winnerBets.peek().draw(g);
		}
		catch(EmptyStackException e)
		{

		}
		try
		{
			loserBets.peek().draw(g);
		}
		catch(EmptyStackException e)
		{

		}
	}

	public void drawDiceRolled(Graphics2D graphics2D)
	{
		int adjX = 50;
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		graphics2D.drawString("Dice Rolled: ", 20, 150);
		for (Dice dice : game.getRolled())
		{
			GraphicDice graphicDice = new GraphicDice(new Point(100 + adjX, 100), dice);
			graphicDice.draw(graphics2D);
			adjX += 125;
		}
	}

	public void drawBoard(Graphics2D g2)
	{
		pyramid.draw(g2);
		for (int i = 0; i < 5; i++)
			drawTile(i, g2);
		for (int i = 0; i < 4; i++)
		{
			drawTile(4 + i, g2);
			drawTile(15 - i, g2);
		}
		for (int i = 0; i < 5; i++)
			drawTile(i + 8, g2);
	}

	public void drawTile(int i, Graphics2D g2)
	{
		track[i].update(game.getTrack()[i]);
		track[i].draw(g2);
	}

	public void drawPlayer(Graphics2D graphics2D)
	{
		Player player = game.getCurrentPlayer();
		GraphicPlayer graphicPlayer = new GraphicPlayer(new Point(20, 500), player);
		graphicPlayer.draw(graphics2D);
	}

	public void drawLegBetDock(Graphics2D graphics2D)
	{
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		graphics2D.drawString("LegBet Dock: ", 20, 325);

		int adjX = 0;
		for (LegBet card : game.getTopLegs()) {
			if (card == null) continue;
			switch (card.getCamelColor()) {
				case ("blue"):
					legBets.put("blue", new GraphicLegBet(new Point(180 + adjX, 275), card));
					adjX += 60;
					legBets.get("blue").draw(graphics2D);
					break;
				case ("yellow"):
					legBets.put("yellow", new GraphicLegBet(new Point(180 + adjX, 275), card));
					adjX += 60;
					legBets.get("yellow").draw(graphics2D);
					break;
				case ("green"):
					legBets.put("green", new GraphicLegBet(new Point(180 + adjX, 275), card));
					adjX += 60;
					legBets.get("green").draw(graphics2D);
					break;
				case ("orange"):
					legBets.put("orange", new GraphicLegBet(new Point(180 + adjX, 275), card));
					adjX += 60;
					legBets.get("orange").draw(graphics2D);
					break;
				case ("white"):
					legBets.put("white", new GraphicLegBet(new Point(180 + adjX, 275), card));
					adjX += 60;
					legBets.get("white").draw(graphics2D);
					break;
			}
		}
	}

	public void drawLeaderBoard(Graphics2D graphics2D)
	{
		Player[] leaderBoard = Arrays.copyOf(game.getPlayers(), game.getPlayers().length);
		Arrays.sort(leaderBoard);
		graphics2D.setColor(Color.BLACK);
		int x = 1250;
		int y = 100;
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		graphics2D.drawString("Leaderboard", x, y += 30);
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		for (int i = 0; i < leaderBoard.length; i++)
			graphics2D.drawString(i + 1 + ". " + leaderBoard[i].getName() + " " + leaderBoard[i].getCoins(), x,
					y += 30);
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (game.won())
			return;

		// check four places
		// corresponds to the 4 places a player can click

		// roll
		if (pyramid.contains(e.getX(), e.getY()))
		{
			game.roll();
			game.proceed();
			return;
		}

		//trap
		for(int i = 0; i < track.length; i++)
			if(track[i].contains(e.getX(), e.getY()))
			{
				if(game.trap(i, track[i].containsDir(e.getX(), e.getY())))
					game.proceed();
			}

		//leg bet
		for (String color : legBets.keySet()) {
			if (legBets.get(color) == null) return;
			if (legBets.get(color).contains(e.getX(), e.getY())) {
				if (game.legBet(color))
					game.proceed();
				return;
			}
		}


		//game bet
		Player player = game.getCurrentPlayer();
		GraphicPlayer graphicPlayer = new GraphicPlayer(new Point(20, 500), player);

		for (GraphicGameBet graphicGameBet : graphicPlayer.getPlayerGraphicGameBets())
			if (graphicGameBet.contains(e.getX(), e.getY()))
			{
				game.gameBet(graphicGameBet.getGameBet().getCamelColor(),
						graphicGameBet.containsWinner(e.getX(), e.getY()));
				if (graphicGameBet.containsWinner(e.getX(), e.getY()))
					winnerBets.push(new GraphicGameBet(new Point(650, 300), graphicGameBet.getGameBet()));
				else
					loserBets.push(new GraphicGameBet(new Point(850, 300), graphicGameBet.getGameBet()));
				game.proceed();
				return;
			}

	}

	private void startTimer()
	{
		timer = new Timer(0, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				double x = MouseInfo.getPointerInfo().getLocation().getX() - window.getLocationOnScreen().x;
				double y = MouseInfo.getPointerInfo().getLocation().getY() - window.getLocationOnScreen().y;
				// if graphic tiles .contains(e.x,e.y) then display plus or minus
//				System.out.println(x + " " + y);
				for (GraphicTile tile : track)
					if (tile.contains((int) x, (int) y))
						tile.setGlow(true);
					else
						tile.setGlow(false);
				repaint();
			}
		});
		timer.setRepeats(true);
		// timer.setDelay(0);
		timer.start();
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
//		System.out.println(arg0.getPoint());
//		System.out.println(MouseInfo.getPointerInfo().getLocation());
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		startTimer();
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		timer.stop();
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("TrackPositions.dat"));
		window = new JFrame("Camel Up");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1920, 1080);
		game = new CamelUp();
		trackPositions = new Point[16];
		for (int i = 0; i < trackPositions.length; i++)
			trackPositions[i] = new Point(in.nextInt(), in.nextInt());
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setResizable(false);
		GraphicBoard board = new GraphicBoard();
		window.addMouseListener(board);
		window.add(board);
		window.getContentPane().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor"));
		window.setVisible(true);
		in.close();
	}
}
