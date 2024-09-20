import java.io.*;

public class GameUtils {
    // 保存游戏状态到文件
    public static void saveGameState(GameState gameState, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(gameState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从文件加载游戏状态
    public static GameState loadGameState(String filePath) {
        GameState gameState = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            gameState = (GameState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gameState;
    }
}