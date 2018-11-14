import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalinListRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("PalinList.txt"));
        while (in.hasNextLine()) {
            String s = in.nextLine();
            PalinList temp = new PalinList(s);
            System.out.println(temp.isPalindrome());

        }
    }
}
