import java.util.ArrayList;

public class IntQueue {
    ArrayList<Integer> list;

    public IntQueue() {
        list = new ArrayList<>();
    }

    public void add(int a) {
        list.add(a);
    }

    public int peek() {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int remove() {
        return list.remove(0);
    }

    public String toString() {
        return list.toString();
    }
}
