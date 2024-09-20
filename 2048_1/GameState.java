import java.io.Serializable;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    private String playerName;
    private String playerPassword;

    public String getPlayerName() {
        return playerName;
    }

    private Card[][] cards;
    private String gameStatus;

    public GameState(Card[][] cards, String gameStatus) {
        this.cards = cards;
        this.gameStatus = gameStatus;
        // 初始化其他属性 time steps......
    }

    public Card[][] getCards() {
        return cards;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

}