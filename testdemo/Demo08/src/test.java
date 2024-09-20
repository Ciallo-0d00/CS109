public class test {
    public static void main(String[] args) {
        GameSystem gs = new GameSystem();
        Player p1 = new Player("zhangsan");
        Player p2 = new Player("Lisi");
        Player p3 = new Player("Wangwu");
        System.out.println(Player.getPlayerCnt());
        gs.addPlayer(p1);
        gs.addPlayer(p3);
        System.out.println(gs.checkPlayer(1));
        System.out.println(gs.checkPlayer(2));
        System.out.println(gs.checkPlayer(3));
        System.out.println(gs.getPlayerList());
    }

}
