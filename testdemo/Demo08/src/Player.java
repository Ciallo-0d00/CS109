public class Player {
    private int pid;
    private String name;
    private static int playerCnt = 1;
    public Player(String name){
        this.name = name;
        pid = playerCnt;
        playerCnt++;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getPlayerCnt() {
        return playerCnt-1;
    }

    @Override
    public String toString() {
        return String.format("Player:%s,pid:%d",name,pid);
    }
}
