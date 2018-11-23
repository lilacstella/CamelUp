import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CamelUp
{
	Tile[] track; // array of all the tiles
	int[] indices; // keeps track of each camel
	Pyramid pyramid; // what is yet to be rolled - just the pyramid
	HashSet<Dice> rolled; // to store the dice rolled out of pyramid for display
	HashMap<String, GameBetDock> gameBetDocks;// 2 gameBetDocks called by winner/loser
	HashMap<String, LegBetDock> legBetDocks; // 5 legBetDocks called by color
	Player[] players; // array of all players in game to be iterated thru with the variable current
	int current; // current player number

	// initialize board
	public CamelUp()
	{
		track = new Tile[16];
		for (int i = 0; i < track.length; i++)
			track[i] = new Tile();
		indices = new int[5]; // 0 = blue, 1 = yellow, 2 = green, 3 = orange, 4 = white
		Arrays.fill(indices, 0);
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

//called before each move, checks background processes
	public void proceed()
	{
		current = ++current % 5;
		if (rolled.size() == 5)
		{
			pyramid.reset();
			rolled.clear();
		}
	}

	public boolean trap(int index, int dir)
	{
		if (!players[current].trap()) // if player already has trap then don't put another one
			return false;
		try // testing if the surrounding tiles have traps
		{
			if(track[index].hasTrap()||track[index+1].hasTrap()||track[index-1].hasTrap())
				return false;
		} catch (ArrayIndexOutOfBoundsException e)
		{
			if((index==15 && track[index-1].hasTrap())||(index==0&&track[index+1].hasTrap()))
				return false;
		}
		track[index].setTrap(new Trap(players[current],dir));
		return true;
	}

	public boolean roll() // will always be true because if there are no more roll cards the leg will reset
	{
		players[current].addRollCard();
		Dice temp = pyramid.roll();
		String color = temp.color();
		int dieFace = temp.getDieFace();
		rolled.add(temp);
		int index = indices[color2Num(color)];
		ArrayList<Camel> list = track[index].getCamel(color);
		for (Camel item : list)
			indices[color2Num(item.getCamelColor())] = (index + dieFace > 15) ? 15 : index + dieFace;
		track[indices[color2Num(color)]].add(list);
		return true;
	}

	public boolean legBet(String color)
	{
		
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

	// converts color of camel to index in array
	private int color2Num(String color)
	{
		switch (color)
		{
		case ("blue"):
			return 0;
		case ("yellow"):
			return 1;
		case ("green"):
			return 2;
		case ("orange"):
			return 3;
		case ("white"):
			return 4;
		default:
			return -1;
		}
	}
}
