package UnitTests;

import Core.CamelUp;

import java.util.Arrays;

public class TextRunner
{
	public static void main(String[] args)
	{
		CamelUp gameState = new CamelUp();
		System.out.println(Arrays.toString(gameState.getTrack()));
	}
}
