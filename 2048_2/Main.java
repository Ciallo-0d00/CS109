import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GameFrame frame=new GameFrame();
        DLframe dlframe = new DLframe();
        ZCframe zCframe=new ZCframe();
        GamePanel panel=new GamePanel(frame,dlframe);

        DLPanel dlPanel=new DLPanel(frame,dlframe,panel,zCframe);
        ZCPanel zcPanel=new ZCPanel(zCframe,dlPanel,dlframe);





        frame.add(panel);
        dlframe.add(dlPanel);
        zCframe.add(zcPanel);
        frame.setVisible(false);;
        dlframe.setVisible(true);
        zCframe.setVisible(false);


    }
}
