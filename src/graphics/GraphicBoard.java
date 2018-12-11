package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.CamelUp;
import core.Dice;
import core.Player;
import core.Tile;

@SuppressWarnings("serial")
public class GraphicBoard extends JPanel implements MouseListener
{

	private static CamelUp game;
	private static Point[] trackPositions;
	//recreate game structure with graphic classes

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("TrackPositions.dat"));
		JFrame window = new JFrame("Camel Up");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1600, 1200);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		GraphicBoard board = new GraphicBoard();

		window.add(board);
		game = new CamelUp();
		trackPositions = new Point[16];
		for (int i = 0; i < trackPositions.length; i++)
		{
			trackPositions[i] = new Point(in.nextInt(), in.nextInt());
		}
		game.roll();
		window.setVisible(true);
		in.close();
	}

	public void paintComponent(Graphics graphics)
	{
		Graphics2D g2D = (Graphics2D) graphics;
		drawDiceRolled(g2D);
		drawBoard(g2D);
		drawPlayer(g2D);
		drawLegBetDock(g2D);
		drawLeaderBoard(g2D);
		repaint();
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
		Tile[] track = game.getTrack();
		for (int i = 0; i < trackPositions.length; i++)
		{
			GraphicTile graphicTile = new GraphicTile(trackPositions[i].x, trackPositions[i].y, track[i]);
			graphicTile.draw(g2);
		}
		for (int i = 0; i < 6; i++)
		{
			g2.setColor(new Color(244 - i * 10, 182 - i * 10, 66 - i * 10));
			g2.fillRect(1275 + i * 25, 550 + i * 25, 300 - i * 50, 300 - i * 50);
			g2.setColor(Color.BLACK);
			g2.drawRect(1275 + i * 25, 550 + i * 25, 300 - i * 50, 300 - i * 50);
		}
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

		GraphicLegBetDock graphicLegBetDock = new GraphicLegBetDock(new Point(180, 275), game.getTopLegs());
		graphicLegBetDock.draw(graphics2D);
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
		{
			graphics2D.drawString(i + 1 + ". " + leaderBoard[i].getName() + " " + leaderBoard[i].getCoins(), x,
					y += 30);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
	}
}