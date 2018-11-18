
public class CamelUpTester
{
	public static void main(String[] args)
	{
		int[] arr = new int[-1];
		CamelUp game = new CamelUp();
		while(!game.won())
		{
			System.out.println(game.currentPlayer());
			game.proceed("roll");
			System.out.println(game);
		}
	}
}
