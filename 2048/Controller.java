import java.io.*;

public class Controller {
    private GamePanel view;
    public Controller(GamePanel view) {
        this.view = view;
    }
    public void saveGame(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(view); // 保存model对象
            System.out.println("游戏已保存到 " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("无法保存游戏: " + e.getMessage());
        }
    }
    public void loadGame(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            GamePanel loadedView = (GamePanel) ois.readObject();
            this.view = loadedView;
            System.out.println("游戏已从 " + filename + " 加载");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("无法加载游戏: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("找不到: " + e.getMessage());
        }
    }
}
