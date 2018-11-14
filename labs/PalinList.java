import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalinList {
    String s;
    public PalinList(String s) {
        this.s = s;
    }

    public String isPalindrome() {
        String[] sArr = s.split(" ");
        Stack<String> firstHalf = new Stack<>();
        Queue<String> secondHalf = new LinkedList<>();
        for (int i = 0; i < sArr.length / 2; i++) {
            firstHalf.push(sArr[i]);
        }
        for (int i = sArr.length / 2; i < sArr.length; i++) {
            secondHalf.offer(sArr[i]);
        }

        if (firstHalf.size() != secondHalf.size()) {
            secondHalf.poll();
        }

        while (!firstHalf.isEmpty()) {
            if (!firstHalf.pop().equals(secondHalf.poll())) {
                return Arrays.toString(sArr) + " is not a palinlist.\n";
            }
        }

        return Arrays.toString(sArr) + " is a palinlist.\n";
    }

}
