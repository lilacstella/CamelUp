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
        drawTitles(graphics2D);
        drawCoins(graphics2D);
    }

    public void drawRollCards(Graphics2D graphics2D) {
        int rollCards = player.getRollCards();
        int adjX = 125;

        for(int i = 0; i < rollCards; i++) {
            GraphicRollCard graphicRollCard = new GraphicRollCard(new Point(pos.x + adjX, pos.y+50));
            graphicRollCard.draw(graphics2D);
            adjX += 60;
        }
    }

    public void drawPlayerLegBets(Graphics2D graphics2D) {
        ArrayList<LegBet> legBets = player.getLegBets();
        int adjX = 125;
        for (LegBet legBet : legBets) {
            GraphicLegBet graphicLegBet = new GraphicLegBet(new Point(pos.x + adjX,  pos.y + 125+50), legBet);
            graphicLegBet.draw(graphics2D);
            adjX += 60;
        }
    }

    public void drawPlayerGameBets(Graphics2D graphics2D) {
        ArrayList<GameBet> gameBets = player.getGameBets();
        int adjX = 125;
        for (GameBet gameBet : gameBets) {
            GraphicGameBet graphicGameBet = new GraphicGameBet(new Point(pos.x + adjX, pos.y + 250+50), gameBet);
            graphicGameBet.draw(graphics2D);
            adjX += 60;
        }
    }

    public void drawTitles(Graphics2D graphics2D) {
        graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        graphics2D.drawString(player.getName(), pos.x, pos.y);

        graphics2D.drawString("Roll Cards: ", pos.x, pos.y+100);
        graphics2D.drawString("Leg Bets: ", pos.x, pos.y+225);
        graphics2D.drawString("Game Bets: ", pos.x, pos.y+350);
    }

    public void drawCoins(Graphics2D graphics2D) {
        graphics2D.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        graphics2D.drawString("Coins: ", pos.x, pos.y+30);

        int adjX =125;
        int coins = player.getCoins();
        while (coins != 0) {

            if (coins >= 10) {
                GraphicCoin coin = new GraphicCoin(new Point(pos.x + adjX, pos.y + 7), 10);
                coins -= 10;
                coin.draw(graphics2D);
            } else if (coins >= 5) {
                GraphicCoin coin = new GraphicCoin(new Point(pos.x + adjX, pos.y + 7), 5);
                coins -= 5;
                coin.draw(graphics2D);
            } else {
                GraphicCoin coin = new GraphicCoin(new Point(pos.x + adjX, pos.y + 7), 1);
                coins -= 1;
                coin.draw(graphics2D);
            }

            adjX += 45;

        }


    }
}
