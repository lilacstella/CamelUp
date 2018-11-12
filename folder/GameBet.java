public class GameBet {
    private String playerName;
    private String camelColor;

    public GameBet(String playerName, String camelName) {
        this.playerName = playerName;
        this.camelColor = camelName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getCamelColor() {
        return camelColor;
    }
}
