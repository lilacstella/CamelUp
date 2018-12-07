package graphics;

import core.GameBet;
import core.LegBet;
import core.Player;

import java.awt.*;
import java.util.ArrayList;

public class GraphicPlayer {

    Point pos;
    Player player;

    public GraphicPlayer(Point pos, Player player) {
        this.pos = pos;
        this.player = player;
    }

    public void draw(Graphics2D graphics2D) {
        drawPlayerGameBets(graphics2D);
        drawPlayerLegBets(graphics2D);
        drawRollCards(graphics2D);
    }

    public void drawRollCards(Graphics2D graphics2D) {
        int rollCards = player.getRollCards();
        int adjX = 0;

        for(int i = 0; i < rollCards; i++) {
            GraphicRollCard graphicRollCard = new GraphicRollCard(new Point(pos.x + adjX, pos.y));
            graphicRollCard.draw(graphics2D);
            adjX += 125;
        }
    }

    public void drawPlayerLegBets(Graphics2D graphics2D) {
        ArrayList<LegBet> legBets = player.getLegBets();
        int adjX = 0;
        for (LegBet legBet : legBets) {
            GraphicLegBet graphicLegBet = new GraphicLegBet(new Point(pos.x + adjX,  pos.y + 300), legBet);
            graphicLegBet.draw(graphics2D);
            adjX += 125;
        }
    }

    public void drawPlayerGameBets(Graphics2D graphics2D) {
        ArrayList<GameBet> gameBets = player.getGameBets();
        int adjX = 0;
        for (GameBet gameBet : gameBets) {
            GraphicGameBet graphicGameBet = new GraphicGameBet(new Point(pos.x + adjX, pos.y + 600), gameBet);
            graphicGameBet.draw(graphics2D);
            adjX += 125;
        }
    }




}
