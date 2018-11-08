import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PreFix {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("PreFix.txt"));

        while (in.hasNextLine()) {

            String s = in.nextLine();
            String[] expr = s.split(" ");

            Stack<Double> numStack = new Stack<Double>();

            for(int i = expr.length-1; i >-1; i--) {
                if(!isSign(expr[i]))
                    numStack.push(Double.parseDouble(expr[i]));
                else
                    numStack.push(eval(numStack.pop(), numStack.pop(), expr[i]));
            }
            System.out.println(s + " = " + numStack.pop());
        }
    }



    public static boolean isSign(String sign) {
        switch (sign) {
            case "+":
            case "-":
            case "/":
            case "*":
                return true;
        }
        return false;
    }

    public static double eval(double a, double b, String operator) {
        if (operator.equals("*"))
            return a*b;
        else if (operator.equals("/"))
            return a/b;
        else if (operator.equals("+"))
            return a+b;
        return a-b;
    }

}