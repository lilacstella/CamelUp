import java.util.Stack;
import java.util.TreeMap;
import java.util.Map;
public class SyntaxChecker 
{
	private Stack<Character> stack;
	private Map<Character, Character> map;
	private boolean correct;
	public SyntaxChecker(String line)
	{
		stack = new Stack<>();
		for(int i = 0; i < line.length(); i++)
			stack.push(line.charAt(i));
		map = new TreeMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		map.put('<', '>');
		correct = correct();
	}
	public boolean correct()
	{
		Stack<Character> temp = new Stack<>();
		temp.addAll(stack);
		int count = 0;
		Character x;
		while(!temp.isEmpty())
		{
			x = temp.pop();
			if(x.equals('(') || x.equals(map.get('('))
			|| x.equals('[') || x.equals(map.get('['))
			|| x.equals('{') || x.equals(map.get('{'))
			||x.equals('<') || x.equals(map.get('<')))
				count += 1;
		}
		if(count % 2 == 0)
			return true;
		return false;
	}
	public String toString()
	{
		String s = "";
		Stack<Character> rep = stack;
		Stack<Character> temp = new Stack<>();
		while(!rep.isEmpty())
			temp.push(rep.pop());
		while(!temp.isEmpty())
			s += temp.pop();
		if(correct)
			s += " is correct.";
		else
			s += " is incorrect.";
		return s;
	}
}

------------------------------------------------------------------------------------------------------
import java.io.*;
import java.util.Scanner;
public class SyntaxCheckRunner
{

	public static void main(String[] args) throws IOException
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
