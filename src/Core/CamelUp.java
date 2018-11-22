import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CamelUp
{
	Tile[] track; //array of all the tiles
	int[] indecies; //keeps track of each camel
	Pyramid pyramid; //what is yet to be rolled - just the pyramid
	HashSet<Dice> rolled; //to store the dice rolled out of pyramid for display
	HashMap<String, GameBetDock> gameBetDocks;// 2 gameBetDocks called by winner/loser
	HashMap<String, LegBetDock> legBetDocks; //5 legBetDocks called by color
	Player[] players; //array of all players in game to be iterated thru with the var current
	int current; //current player number

	// initialize board
	public CamelUp()
	{
		track = new Tile[16];
		for(int i = 0; i < track.length; i++)
			track[i] = new Tile();
		indecies = new int[5]; //0 = blue, 1 = yellow, 2 = green, 3 = orange, 4 = white
		Arrays.fill(indecies, 0);
		pyramid = new Pyramid();
		rolled = new HashSet<>();
		gameBetDocks = new HashMap<>();
		gameBetDocks.put("winner", new GameBetDock());
		gameBetDocks.put("loser", new GameBetDock());
		legBetDocks = new HashMap<>();
		legBetDocks.put("blue", new LegBetDock());
		legBetDocks.put("yellow", new LegBetDock());
		legBetDocks.put("green", new LegBetDock());
		legBetDocks.put("orange", new LegBetDock());
		legBetDocks.put("white", new LegBetDock());
		players = new Player[5];
		current = 0;
	}

//called each move, triggers the continuation of the game
	public void proceed(String toDo)
	{
		current = ++current%5;
		switch(toDo)
		{
		case("roll"): //if the player rolls
			Dice temp = pyramid.roll();
			roll(temp.color(),temp.getDieFace());
			rolled.add(temp);
		}
	}

	

//current player playing the game
	public Player currentPlayer()
	{
		return players[current];
	}

//if the game has been won
	public boolean won()
	{
		return track[15].empty();
	}

	//converts color of camel to index in array
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
