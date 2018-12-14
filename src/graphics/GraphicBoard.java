package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
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
		Graphics2D g2D = (Graphics2D) graphics;

		g2D.setColor(new Color(255, 218, 185));
		g2D.fillRect(0, 0, 1920, 1080);
		g2D.setColor(Color.black);
		drawDiceRolled(g2D);
		drawPlayer(g2D);
		drawLegBetDock(g2D);
		drawLeaderBoard(g2D);
		drawGameBetDock(g2D);
		drawBoard(g2D);
//		drawEndGame(g2D);
		drawTitle(g2D);
		g2D.setColor(new Color(129, 9, 233));
		if (game.won())
			drawEndGame(g2D);
		g2D.setStroke(new BasicStroke(3));
		g2D.draw(new Line2D.Double(x - 5, y, x + 5, y));
		g2D.draw(new Line2D.Double(x, y - 5, x, y + 5));
		g2D.setColor(Color.black);
		repaint();
	}

	public void drawGameBetDock(Graphics2D g)
	{
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(3));
		g.drawString("Win", 695, 175);
		g.drawString("Lose", 765, 175);
		g.drawRect(690, 200, 70, 250);
		g.drawRect(760, 200, 70, 250);
		if (!winnerBets.isEmpty())
			for (GraphicGameBet thing : winnerBets)
				thing.draw(g, Color.BLACK);
		for (GraphicGameBet thing : loserBets)
			thing.draw(g, Color.black);
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

	public void drawBoard(Graphics2D g2D)
	{
		pyramid.draw(g2D);
		for (int i = 0; i < 5; i++)
			drawTile(4 - i, g2D);
		for (int i = 0; i < 4; i++)
		{
			drawTile(4 + i, g2D);
			drawTile(15 - i, g2D);
		}
		for (int i = 0; i < 5; i++)
			drawTile(i + 8, g2D);
	}

	public void drawTile(int i, Graphics2D g2D)
	{
		track[i].update(game.getTrack()[i], i);
//		lastList = Arrays.toString(game.getTrack());
		track[i].draw(g2D);
		paintLine(g2D, 1274, 449, false);
//		paintLine(g2, 1175, 651, true);
		track[i].drawCamel(g2D);
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
		legBets.clear();
		for (LegBet card : game.getTopLegs())
		{
			if (card == null)
				continue;
			switch (card.getCamelColor())
			{
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
		int x = 1300;
		int y = 100;
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		graphics2D.drawString("Leaderboard", x, y += 30);
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		for (int i = 0; i < leaderBoard.length; i++)
		{
			graphics2D.drawString(i + 1 + ". " + leaderBoard[i].getName(), x, y += 30);
			graphics2D.drawString(Integer.toString(leaderBoard[i].getCoins()), x + 170, y);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (game.won())
		{
			return;
		}

		// check four places
		// corresponds to the 4 places a player can click

		// roll
		if (pyramid.contains(e.getX(), e.getY()))
		{
			game.roll();
			proceed();
			return;
		}

		// trap
		for (int i = 0; i < track.length; i++)
			if (track[i].contains(e.getX(), e.getY()))
			{
				if (game.trap(i, track[i].containsDir(e.getX(), e.getY())))
					proceed();
				return;
			}

		// leg bet
		for (String color : legBets.keySet())
		{
			if (legBets.get(color) == null)
				return;
			if (legBets.get(color).contains(e.getX(), e.getY()))
			{
				if (game.legBet(color))
					proceed();
				return;
			}

		}

		// game bet
		Player player = game.getCurrentPlayer();
		GraphicPlayer graphicPlayer = new GraphicPlayer(new Point(20, 500), player);

		for (GraphicGameBet graphicGameBet : graphicPlayer.getPlayerGraphicGameBets())
			if (graphicGameBet.contains(e.getX(), e.getY()))
			{
				if (graphicGameBet.containsWinner(e.getX(), e.getY())) {
					winnerBets.push(new GraphicGameBet(new Point(700, 210 + 10 * winnerBets.size()), player.getName()));
					game.gameBet(graphicGameBet.getGameBet().getCamelColor(), true);
				} else if (graphicGameBet.containsLoser(e.getX(), e.getY())) {
					loserBets.push(new GraphicGameBet(new Point(770, 210 + 10 * loserBets.size()), player.getName()));
					game.gameBet(graphicGameBet.getGameBet().getCamelColor(), false);
				} else {
					return;
				}

				proceed();
				return;
			}
	}

	private void drawEndGame(Graphics2D graphics2D)
	{

		int x = 500;
		int y = 500;

		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		graphics2D.setColor(new Color(240, 230, 140));
		graphics2D.fillRect(x, y, 550, 400);
		graphics2D.setColor(Color.BLACK);
		graphics2D.drawRect(x, y, 550, 400);
		graphics2D.drawString("Winner Camel", x + 10, y + 20);
		graphics2D.drawString("Loser Camel", x + 420, y + 20);
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		graphics2D.drawString("End Game", x + 180, y + 50);

		Player[] leaderBoard = Arrays.copyOf(game.getPlayers(), game.getPlayers().length);
		Arrays.sort(leaderBoard);
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		graphics2D.drawString(leaderBoard[0].getName() + " Wins!", x + 220, y + 100);
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		int adjY = y + 150;
		for (int i = 0; i < leaderBoard.length; i++)
		{
			graphics2D.drawString(i + 1 + ". " + leaderBoard[i].getName(), x + 190, adjY += 30);
			graphics2D.drawString(Integer.toString(leaderBoard[i].getCoins()), x + 360, adjY);
		}

		GraphicCamel first = new GraphicCamel(string2Color(game.getRankCamel(1).getCamelColor()),
				new Point(x + 70, y + 100), 0);
		first.setSize(150);
		GraphicCamel last = new GraphicCamel(string2Color(game.getRankCamel(5).getCamelColor()),
				new Point(x + 480, y + 100), 0);
		last.setSize(150);
		first.draw(graphics2D);
		last.draw(graphics2D);

	}

	private void proceed()
	{
		game.proceed();
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

	public void paintLine(Graphics g, int posX, int posY, boolean b)
	{
		if (b)
			for (int i = 1; i <= 10; i++)
			{
				if (i % 2 == 0)
					g.setColor(Color.BLACK);
				else
					g.setColor(Color.WHITE);
				g.fillRect(posX, posY, 10, 10);
				posX += 10;
			}
		else
			for (int i = 1; i <= 10; i++)
			{
				if (i % 2 == 0)
					g.setColor(Color.BLACK);
				else
					g.setColor(Color.WHITE);
				g.fillRect(posX, posY, 10, 10);
				posY += 10;
			}
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
		window.getContentPane().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor"));
		window.setVisible(true);
		in.close();
	}

	private Color string2Color(String color)
	{
		switch (color)
		{
		case ("blue"):
			return Color.blue;
		case ("yellow"):
			return Color.yellow;
		case ("green"):
			return Color.green;
		case ("orange"):
			return Color.orange;
		case ("white"):
			return Color.white;
		default:
			return null;
		}
	}

	private void drawTitle(Graphics2D graphics2D) {
		graphics2D.setColor(new Color(212,175,55));
		graphics2D.setFont(new Font("Comic Sans MS", Font.ITALIC., 100));
		graphics2D.drawString("Camel Up", 625, 100);
	}




}
