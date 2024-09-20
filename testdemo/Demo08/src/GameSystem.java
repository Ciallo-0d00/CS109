import java.util.ArrayList;

public class GameSystem {
    private ArrayList<Player> playerList = new ArrayList<>();

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public boolean checkPlayer(int pid){
        for (int i = 0; i < playerList.size(); i++) {
            if (pid == playerList.get(i).getPid()){
                return true;
            }
        }
        return false;
    }
    public boolean addPlayer(Player player){
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getPid() == player.getPid()){
                return false;
            }
        }
        playerList.add(player);
        return true;
    }
}
