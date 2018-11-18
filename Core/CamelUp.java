import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CamelUp
{
	Tile[] track;
	int[] indecies; //keeps track of each camel
	Pyramid pyramid;
	HashSet<Dice> rolled;
	HashMap<String, GameBetDock> gameBetDocks;
	HashMap<String, LegBetDock> legBetDocks;
	Player[] players;
	int current;

	// initialize board
	public CamelUp()
	{
		track = new Tile[16];
		indecies = new int[5]; //0 = blue, 1 = yellow, 2 = green, 3 = orange, 4 = white
		Arrays.fill(indecies, 0);
		pyramid = new Pyramid();
		rolled = new HashSet<>();
		gameBetDocks.put("winner", new GameBetDock());
		gameBetDocks.put("loser", new GameBetDock());
		legBetDocks.put("blue", new LegBetDock());
		legBetDocks.put("yellow", new LegBetDock());
		legBetDocks.put("green", new LegBetDock());
		legBetDocks.put("orange", new LegBetDock());
		legBetDocks.put("white", new LegBetDock());
		players = new Player[5];
		current = 0;
	}

	public void proceed(String toDo)
	{
		current = ++current%5;
		switch(toDo)
		{
		case("roll"):
			Dice temp = pyramid.roll();
			roll(temp.color(),temp.getDieFace());
			rolled.add(temp);
		}
	}
	
	private void roll(String color, int dieFace)
	{
		int camel = color2Num(color);
		try
		{
			track[indecies[camel]].getCamel();
			indecies[camel] += dieFace;
		}
		
	}

	public Player currentPlayer()
	{
		return players[current];
	}

	public boolean won()
	{
		return track[31].empty();
	}
	
	private int color2Num(String color)
	{
		switch(color)
		{
		case("blue"):return 0;
		case("yellow"):return 1;
		case("green"):return 2;
		case("orange"):return 3;
		case("white"):return 4;
		default: return -1;
		}
	}
}
