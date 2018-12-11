package graphics;

import core.LegBet;

import java.awt.*;
import java.util.ArrayList;

public class GraphicLegBetDock {

    private Point pos;
    private ArrayList<LegBet> topCards;

    public GraphicLegBetDock(Point pos, ArrayList<LegBet> topCards) {
        this.pos = pos;
        this.topCards = topCards;
    }


    public void draw(Graphics2D graphics2D) {
        int adjX = 0;

        int x = pos.x;
        int y = pos.y;

        for (LegBet legBet : topCards) {
            GraphicLegBet graphicLegBet = new GraphicLegBet(new Point(x + adjX, y), legBet);
            graphicLegBet.draw(graphics2D);
            adjX += 60;
        }
    }




}
