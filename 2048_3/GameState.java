import java.io.*;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    private String playerName;
    private String playerPassword;
    private Card[][] cards = new Card[4][4];
    private int steps = 0;
    private int time = 0;
    private boolean ifSaved = false;

    public boolean isIfSaved() {
        return ifSaved;
    }

    public void setIfSaved(boolean ifSaved) {
        this.ifSaved = ifSaved;
    }

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

    public int getTime(){
        return time;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

    public void setTime(int time){
        this.time = time;
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