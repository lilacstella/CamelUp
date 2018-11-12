import java.util.ArrayList;

public class Player {
    private int coins;
    private ArrayList<GameBet> gameBets;
    private ArrayList<LegBet> legBets;
    private ArrayList<RollCard> rollCards;
    private String name;
    private static final String[] camelColors = {"blue", "yellow", "green", "orange", "white"};

    //TO DO
    // ASK SOMEONE HOW THE TRAP CLASS WORKS AS IT IS VERY POORLY COMMENTED
    //ALSO ASK HOW THE RESET METHOD WORKS
    //ALSO CREATE A METHOD THAT GIVES THE PLAYERS THE COINS HE NEEDS AT THE END OF EACH LEG
    //RESOLVE HOW A PLAYER IS GOING TO GET A ROLLCARD
    //RESOLVE HOW TO CREATE GAMEBETS
    //ALSO TELL EVERYONE TO COMMENT THEIR CODE MUCH BETTER.
    //ALSO I HAVE TO COMMENT SOME OF MY METHODS IN MY GAMEBET DOCK AFTER THESE ISSUES ARE RESOLVED
    //SINCERELY SARIM


    public Player(String name) {
        this.name = name;
        setCoins(5); // i assume this is how many coins the player starts out with though not sure
        gameBets = new ArrayList<>(); //initialize gameBets
        for(int i = 0; i < 5; i++) {
            gameBets.add(new GameBet(name, camelColors[i])); // sets the players five gameBets of each camel color;
        }

        legBets = new ArrayList<>(); //initialize leg bets
        rollCards = new ArrayList<>(); //initialize roll cards


    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void betLeg(String color, LegBetDock legBetDock) {
        legBets.add(legBetDock.getLegBet(color));
    }

    public void betGameBets() {

    }

    public void addRollCard() {

    }

    public String getName() {
        return name;
    }




}
