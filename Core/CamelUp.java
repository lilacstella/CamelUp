public class CamelUp
{
  Tile[] track;
  Pyramid pyramid;
  HashMap<String, GameBetDock> gameBetDocks;
  HashMap<String, LegBetDock> legBetDocks;
  Player[] players;

  //initialize board
  public CamelUp()
  {
    track = new Tile[16];
    pyramid = new Pyramid();
    gameBetDocks.put("winner", new GameBetDock());
    gameBetDocks.put("loser", new GameBetDock());
    legBetDocks.put("blue", new LegBetDock());
    legBetDocks.put("yellow", new LegBetDock());
    legBetDocks.put("green", new LegBetDock());
    legBetDocks.put("orange", new LegBetDock());
    legBetDocks.put("white", new LegBetDock());
    players = new Player[5];
  }
}
