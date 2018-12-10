package unit_tests;

import core.CamelUp;
import core.Tile;
import graphics.GraphicTile;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphicsBoardTest extends JPanel {
    private static CamelUp gameState;
    private static Point[] trackPositions;
    public static void main(String[] args) throws FileNotFoundException {
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
        for (int i = 0; i < trackPositions.length; i++) {
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
        gameState.trap(15, -1);
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        drawBoard(graphics2D);
        repaint();
    }

    public void drawBoard(Graphics2D graphics2D) {
        Tile[] track = gameState.getTrack();
        for (int i = 0; i < trackPositions.length; i++) {
            GraphicTile graphicTile = new GraphicTile(trackPositions[i].x, trackPositions[i].y + 200, track[i]);
            graphicTile.draw(graphics2D);
        }
    }



}
