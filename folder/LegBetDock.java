import java.util.Map;
import java.util.Stack;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class LegBetDock {
    private Map<String, Stack<LegBet>> legBets;
    private static final int[] cardValues = {2, 3, 5};
    private static final String[] camelColors = {"blue", "yellow", "green", "orange", "white"};

    public LegBetDock() {

        legBets = new HashMap<>();

        for (String s : camelColors) {
            legBets.put(s, new Stack<LegBet>());
            for (Integer i : cardValues) {
                legBets.get(s).push(new LegBet(i, s));
            }
        }
    }

    public LegBet getLegBet(String camelColor) {
        return legBets.get(camelColor).pop();
    }

    public Set<LegBet> getTopCards() {
        Set<LegBet> topCards = new TreeSet<>();

        for (String s : legBets.keySet()) {
            topCards.add(legBets.get(s).peek());
        }

        return topCards;
    }

    public void reset() {

    }
}
