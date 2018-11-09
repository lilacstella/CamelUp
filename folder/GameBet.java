public class GameBet {
    private String playerName;
    private String camelName;

    public GameBet(String playerName, String camelName) {
        this.playerName = playerName;
        this.camelName = camelName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getCamelName() {
        return camelName;
    }
}
