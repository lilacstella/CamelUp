import java.io.FileNotFoundException;
import java.util.Scanner;
public class SyntaxCheckRunner
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("SyntaxChecker.txt"));
		while(scan.hasNext())
		{
      SyntaxChecker s = new SyntaxChecker(scan.nextLine());
			System.out.println(s + "\n");
		}
		scan.close();
	}
}
