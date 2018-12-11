package graphics;
import java.awt.*;
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
	private static String[][] positions;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("TrackPositions.dat"));
		JFrame window = new JFrame("Camel Up");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		GraphicBoard board = new GraphicBoard();
		window.add(board);
		board.addMouseListener(new GraphicBoard());
		game = new CamelUp();
		trackPositions = new Point[16];
		for (int i = 0; i < trackPositions.length; i++) {
			trackPositions[i] = new Point(in.nextInt(), in.nextInt());
		}
		game.roll();
		game.roll();
		game.legCalc();
		game.trap(8, 1);
		window.setVisible(true);
//		System.out.println(window.getWidth());
//		System.out.println(window.getHeight());
//		positions = new String[window.getWidth()][window.getHeight()];
//		for (int i = 0; i < trackPositions.length; i++) {
//			int x = trackPositions[i].x + 100;
//			int y = trackPositions[i].y - 200;
//			for (int j = 0; j < 100; j++) {
//				for (int k = 0; k < 100; k++) {
//					positions[x + j][y + k] = i + "";
//				}
//			}
//		}
//
//		for (int i = 0; i < positions.length; i++) {
//			for (int j = 0; j < positions[i].length; j++) {
//				System.out.print(positions[i][j]);
//			}
//			System.out.println();
//		}


	}

	public void paintComponent(Graphics graphics)
	{
		Graphics2D g2D = (Graphics2D) graphics;
		g2D.setColor(new Color(255,218,185));
		g2D.fillRect(0, 0, getWidth(), getHeight());
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
		graphics2D.setColor(Color.BLACK);
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		graphics2D.drawString("Dice Rolled: ", 20, 150);
		for (Dice dice : game.getRolled())
		{
			GraphicDice graphicDice = new GraphicDice(new Point(100 + adjX, 100), dice);
			graphicDice.draw(graphics2D);
			adjX += 125;

		}
	}
	
	public void drawBoard(Graphics2D graphics2D)
	{
		Tile[] track = game.getTrack();
		for (int i = 0; i < trackPositions.length; i++)
		{
			GraphicTile graphicTile = new GraphicTile(trackPositions[i].x+100, trackPositions[i].y-200, track[i]);
			graphicTile.draw(graphics2D);
		}
	}

	public void drawPlayer(Graphics2D graphics2D)
	{
		Player player = game.getCurrentPlayer();
		GraphicPlayer graphicPlayer = new GraphicPlayer(new Point(20, 500), player);
		graphicPlayer.draw(graphics2D);
	}

	public void drawLegBetDock(Graphics2D graphics2D) {
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		graphics2D.drawString("LegBet Dock: ", 20, 325);

		GraphicLegBetDock graphicLegBetDock = new GraphicLegBetDock(new Point(180, 275), game.getTopLegs());
		graphicLegBetDock.draw(graphics2D);

	}

	public void drawLeaderBoard(Graphics2D graphics2D) {
		Player[] leaderBoard = Arrays.copyOf(game.getPlayers(), game.getPlayers().length);
		Arrays.sort(leaderBoard);
		graphics2D.setColor(Color.BLACK);
		int x = 1250;
		int y = 100;
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		graphics2D.drawString("Leaderboard", x, y+=30);
		graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		for (int i = 0; i < leaderBoard.length; i++) {
			graphics2D.drawString(i + 1  + ". " + leaderBoard[i].getName() + " " + leaderBoard[i].getCoins(), x, y+=30);
		}
	}



	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + " " + y);




	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
