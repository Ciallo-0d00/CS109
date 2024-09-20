package controller;

import model.GridNumber;
import view.GameFrame;
import view.GamePanel;

import java.io.*;


/**
 * This class is used for interactive with JButton in GameFrame.
 */
public class GameController {
    private GamePanel view;
    private GridNumber model;
    public GameController(GamePanel view, GridNumber model) {
        this.view = view;
        this.model = model;
    }
    public void restartGame() {
        System.out.println("Do restart game here");
        model.initialNumbers();
        view.initialGame();
    }public void saveGame(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(model); // 保存model对象
            System.out.println("游戏已保存到 " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("无法保存游戏: " + e.getMessage());
        }
    }
    public void loadGame(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            GridNumber loadedModel = (GridNumber) ois.readObject();
            this.model = loadedModel;
            view.setModel(loadedModel);
            view.updateGridsNumber();
            System.out.println("游戏已从 " + filename + " 加载");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("无法加载游戏: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("找不到GridNumber类: " + e.getMessage());
        }
    }



    //todo: add other methods such as loadGame, saveGame...

}
