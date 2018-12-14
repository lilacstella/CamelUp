package unit_tests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.CamelUp;
import core.Player;
import graphics.GraphicPlayer;

@SuppressWarnings("serial")
public class GraphicsBoardTest extends JPanel
{
	private static CamelUp gameState;
	private static Point[] trackPositions;

	public static void main(String[] args) throws FileNotFoundException
	{
		JFrame window = new JFrame("Camel Up");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1600, 1200);
		window.setVisible(true);
		GraphicsBoardTest board = new GraphicsBoardTest();
		window.add(board);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameState = new CamelUp();
		window.setExtendedState(JFrame.NORMAL);
		System.out.println(window.getWidth());
		System.out.println(window.getHeight());
		trackPositions = new Point[16];
		Scanner in = new Scanner(new File("TrackPositions.txt"));
		for (int i = 0; i < trackPositions.length; i++)
		{
			trackPositions[i] = new Point(in.nextInt(), in.nextInt());
		}
		gameState.roll();
		gameState.proceed();
		gameState.roll();
		gameState.proceed();
		gameState.roll();
		gameState.proceed();
		gameState.roll();
		gameState.proceed();
		gameState.trap(10, 1);
		gameState.legBet("green");
		gameState.gameBet("blue", false);
		gameState.roll();
		gameState.roll();
		gameState.getCurrentPlayer().setCoins(4);
		in.close();
	}

	public void paintComponent(Graphics graphics)
	{
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setColor(new Color(255,218,185));
		graphics2D.fillRect(0, 0, 1600, 1200);
		drawBoard(graphics2D);
		drawPlayer(graphics2D);
		repaint();
	}

	public void drawBoard(Graphics2D graphics2D)
	{
//		Tile[] track = gameState.getTrack();
		for (int i = 0; i < trackPositions.length; i++)
		{
//			GraphicTile graphicTile = new GraphicTile(trackPositions[i].x, trackPositions[i].y, track[i]);
//			graphicTile.draw(graphics2D);
		}
	}

	public void drawPlayer(Graphics2D graphics2D)
	{
		Player player = gameState.getCurrentPlayer();
		GraphicPlayer graphicPlayer = new GraphicPlayer(new Point(625, 700), player);
		graphicPlayer.draw(graphics2D);
	}

}
