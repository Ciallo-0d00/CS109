import java.io.*;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    private String playerName;
    private String playerPassword;
    private Card[][] cards;
    private String gameStatus;
    private int steps;

    public String getPlayerName() {
        return playerName;
    }
    public GameState(String playerName, String playerPassword) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        saveGameState(this);
        // 初始化其他属性 time steps......
    }

    public Card[][] getCards() {
        return cards;
    }

    public int getsteps(){return steps;}
    public String getGameStatus() {
        return gameStatus;
    }

    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
    public static void saveGameState(GameState gameState) {
        String filePath = "gamestate_" + gameState.getPlayerName() + ".ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(gameState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static GameState loadGameState(String playerName) {
        String filePath = "gamestate_" + playerName + ".ser";
        GameState gameState = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            gameState = (GameState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gameState;
    }

}