package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.CamelUp;
import core.Dice;
import core.GameBet;
import core.Player;
import core.Tile;

@SuppressWarnings("serial")
public class GraphicBoard extends JPanel
{

	private static CamelUp game;
	private static Point[] trackPositions;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("TrackPositions.dat"));
		JFrame window = new JFrame("Camel Up");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1600, 1200);
		window.setVisible(true);
		GraphicBoard board = new GraphicBoard();
		window.addMouseListener((new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e)
			{
				//put if it is inside track here
//				if(e.getX()>=1075 && e.getX()<=1475 && e.getY() >= 650 && e.getY() <= 1050)
					//iterate thru tiles and find which one it is in
			}
		}));
		window.add(board);
		game = new CamelUp();
		trackPositions = new Point[16];
		for(Point point : trackPositions)
			point = new Point(in.nextInt(),in.nextInt());
	}

	public void paintComponent(Graphics graphics)
	{
		Graphics2D g2D = (Graphics2D) graphics;
		drawDiceRolled(g2D, game.getRolled());
		drawPlayerGameBets(g2D);
		drawBoard(g2D);
		drawPlayer(g2D);
		repaint();
	}

	public void drawDiceRolled(Graphics2D graphics2D, HashSet<Dice> diceRolled)
	{

		int adjX = 0;
		for (Dice dice : diceRolled)
		{
			GraphicDice graphicDice = new GraphicDice(new Point(800 + adjX, 800), dice);
			graphicDice.draw(graphics2D);
			adjX += 125;

		}
	}

	public void drawPlayerGameBets(Graphics2D graphics2D)
	{
		ArrayList<GameBet> gameBets = game.getCurrentPlayer().getGameBets();
		int adjX = 0;
		for (GameBet gameBet : gameBets)
		{
			GraphicGameBet graphicGameBet = new GraphicGameBet(new Point(500 + adjX, 500), gameBet);
			graphicGameBet.draw(graphics2D);
			adjX += 125;
		}
	}
	
	public void drawBoard(Graphics2D graphics2D)
	{
		Tile[] track = game.getTrack();
		for (int i = 0; i < trackPositions.length; i++)
		{
			GraphicTile graphicTile = new GraphicTile(trackPositions[i].x, trackPositions[i].y, track[i]);
			graphicTile.draw(graphics2D);
		}
	}

	public void drawPlayer(Graphics2D graphics2D)
	{
		Player player = game.getCurrentPlayer();
		GraphicPlayer graphicPlayer = new GraphicPlayer(new Point(625, 700), player);
		graphicPlayer.draw(graphics2D);
	}
}
