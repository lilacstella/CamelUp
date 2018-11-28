

public class TextRunner
{
	public static void main(String[] args)
	{
		CamelUp game = new CamelUp();
		while(!game.won())
		{
			System.out.println(game.currentPlayer());
			
			System.out.println(game);
		}
	}
}
