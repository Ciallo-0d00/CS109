import java.io.*;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    private String playerName;
    private String playerPassword;

    public String getPlayerName() {
        return playerName;
    }

    private int[][] cards;
    private String gameStatus;

    public GameState(String playerName,String playerPassword) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        // 初始化其他属性 time steps......
    }

    public int[][] getCards() {
        return cards;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setCards(int[][] cards) {
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