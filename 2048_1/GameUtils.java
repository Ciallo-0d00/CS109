import java.io.*;

public class GameUtils {
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