package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CamelUp
{
	private Tile[] track; // array of all the tiles
	private int[] indices; // keeps track of each camel
	private Pyramid pyramid; // what is yet to be rolled - just the pyramid
	private ArrayList<Dice> rolled; // to store the dice rolled out of pyramid for display
	private HashMap<String, GameBetDock> gameBetDocks;// 2 gameBetDocks called by winner/loser
	private HashMap<String, LegBetDock> legBetDocks; // 5 legBetDocks called by getColor
	private Player[] players; // array of all players in game to be iterated through with the variable current
	private int current; // current player number
	private boolean won;
	
	// initialize board
	public CamelUp()
	{
		track = new Tile[16];
		for (int i = 0; i < track.length; i++)
			track[i] = new Tile();
		track[0].add(new ArrayList<Camel>(Arrays.asList(new Camel[]
		{ new Camel("blue"), new Camel("yellow"), new Camel("green"), new Camel("orange"), new Camel("white") })));
		// need to determine the orders these start
		indices = new int[5]; // 0 = blue, 1 = yellow, 2 = green, 3 = orange, 4 = white
		pyramid = new Pyramid();
		rolled = new ArrayList<>();
		gameBetDocks = new HashMap<>();
		gameBetDocks.put("winner", new GameBetDock());
		gameBetDocks.put("loser", new GameBetDock());
		legBetDocks = new HashMap<>();
		legBetDocks.put("blue", new LegBetDock("blue"));
		legBetDocks.put("yellow", new LegBetDock("yellow"));
		legBetDocks.put("green", new LegBetDock("green"));
		legBetDocks.put("orange", new LegBetDock("orange"));
		legBetDocks.put("white", new LegBetDock("white"));
		players = new Player[5];
		for (int i = 0; i < players.length; i++)
			players[i] = new Player("P" + (i + 1));

	}

//called before each move, checks background processes
	public void proceed()
	{
		current = ++current % 5;
		if (rolled.size() == 5)
		{
			pyramid.reset();
			rolled.clear();
			legBetDocks.get("blue").reset();
			legBetDocks.get("yellow").reset();
			legBetDocks.get("green").reset();
			legBetDocks.get("orange").reset();
			legBetDocks.get("white").reset();
			legCalc();
		}
	}

	public ArrayList<Dice> getRolled()
	{
		return rolled;
	}

	public boolean roll() // will always be true because if there are no more roll cards the leg will reset
	{
		players[current].addRollCard();
		Dice temp = pyramid.roll();
		String color = temp.getColor();
		int dieFace = temp.getDieFace();
		rolled.add(temp);
		int index = indices[color2Num(color)];
		ArrayList<Camel> list = track[index].remCamels(color);
		if(index + dieFace > 15)
		{
			index = (index + dieFace)%15;
			won= true;
		}
		else
			index += dieFace;
//		System.out.println(indices[color2Num(list.get(0).getCamelColor())]);
		for (Camel item : list)
			indices[color2Num(item.getCamelColor())] = index;
		System.out.println(index);
		
		if (track[indices[color2Num(color)]].add(list) != 0)
		{

			for (int i = 0; i < players.length; i++) {
//				System.out.println(players[i].getName() + " " + track[indices[color2Num(color)]].getTrap().getPlayerName());
				if (players[i].getName().equals(track[indices[color2Num(color)]].getTrap().getPlayerName())) {
					players[i].setCoins(players[i].getCoins() + 1);
				}
			}
			int dir = track[indices[color2Num(color)]].add(list);
			if (dir == 1)
				track[++indices[color2Num(color)]].add(list);
			else if (dir == -1)
				track[--indices[color2Num(color)]].add(list, 0);

		}
		return true;
	}

	public boolean trap(int index, int dir)
	{
		if (index == 0)
			return false;
		try
		{
			if (!track[index].empty() || !track[index].getTrap().getPlayerName().equals(players[current].getName()))
				return false;
		} catch (NullPointerException e)
		{
		}
		int oldIndex = -1;
		Trap oldTrap = null;

		if (getCurrentPlayer().placedTrap())
		{
			for (int i = 0; i < track.length; i++)
			{
				if (track[i].getTrap() == null)
					continue;
				if (track[i].getTrap().getPlayerName().equals(getCurrentPlayer().getName()))
				{
					oldTrap = track[i].removeTrap();
					oldIndex = i;
				}
			}
		}
		
		if(oldIndex == index)
		{
			if(oldTrap.getDir()==dir)
			{
				track[index].setTrap(oldTrap);
				return false;
			}
			else
				track[index].setTrap(new Trap(players[current],dir));
			return true;
		}
		
		if (!track[index].empty())
		{// if the tile already has camels on it
			if (getCurrentPlayer().placedTrap())
				track[oldIndex].setTrap(oldTrap);
			return false;
		}

		try // testing if the surrounding tiles have traps
		{
			if (track[index].hasTrap() || track[index + 1].hasTrap() || track[index - 1].hasTrap())
			{
				if (getCurrentPlayer().placedTrap())
					track[oldIndex].setTrap(oldTrap);
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException e)
		{
			if ((index == 15 && track[index - 1].hasTrap()) || (index == 0 && track[index + 1].hasTrap()))
			{
				if (getCurrentPlayer().placedTrap())
					track[oldIndex].setTrap(oldTrap);
				return false;
			}

		}
		track[index].setTrap(new Trap(getCurrentPlayer(), dir));
		getCurrentPlayer().trap();
		return true;
	}

	public boolean legBet(String color) // takes top legBet from legBetDock of getColor and put it into current player
	{
		return players[current].addLegBet(legBetDocks.get(color).getLegBet());
	}

	public boolean gameBet(String color, boolean winner)
	{
		return gameBetDocks.get((winner) ? "winner" : "loser").addGameBet(players[current].remGameBet(color));
	}

//current player playing the game
	public Player getCurrentPlayer()
	{
		return players[current];
	}

//if the game has been won and cash out if yes
	public boolean won()
	{
		if(!won)
			return won;

		Camel winner = track[15].getCamels().get(track[15].getCamels().size() - 1);
		Camel loser = null;
		for (Tile item : track)
			if (!item.empty())
			{
				loser = item.getCamels().get(0);
				break; // issue #26
			}
		gameBetDocks.get("winner").calc(players, winner);
		gameBetDocks.get("loser").calc(players, loser);
		legCalc();
		return true;
	}

	public void legCalc()
	{
		// gives player coins according to roll cards and leg bets from their inventory

		for (Player item : players)
			item.legClear(getRankCamel(1), getRankCamel(2));

		// trap
		for (Tile item : track)
			item.removeTrap();

	}

	// converts getColor of camel to index in array
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

	public Tile[] getTrack()
	{
		return track;
	}

	public Camel getRankCamel(int place) // gets the camel given a rank ex. first place
	{
		int camelRank = 1;
		for (int i = track.length - 1; i > -1; i--)
		{
			ArrayList<Camel> camelList = track[i].getCamels();
			for (int j = camelList.size() - 1; j > -1; j--)
			{
				if (camelRank++ == place)
				{
					return camelList.get(j);
				}
			}
		}
		return null;
	}

	public Player[] getPlayers()
	{
		return players;
	}

	public ArrayList<LegBet> getTopLegs()
	{
		ArrayList<LegBet> topCards = new ArrayList<>();
		for (LegBetDock legBetDock : legBetDocks.values())
		{
			topCards.add(legBetDock.getTopLeg());
		}
		return topCards;
	}
}
