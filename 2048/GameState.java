import java.io.Serializable;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    private Card[][] cards;
    private String gameStatus; // 游戏状态
    // 可以添加更多需要保存的游戏相关信息，比如分数等

    // 构造函数
    public GameState(Card[][] cards, String gameStatus) {
        this.cards = cards;
        this.gameStatus = gameStatus;
    }

    // Getter和Setter方法
    public Card[][] getCards() {
        return cards;
    }

    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    // 可以添加更多方法
}