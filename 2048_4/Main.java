import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        GameFrame frame=new GameFrame();
        DLframe dlframe = new DLframe();
        ZCframe zCframe=new ZCframe();
        GamePanel panel=new GamePanel(frame,dlframe);


        DLPanel dlPanel=new DLPanel(frame,dlframe,panel,zCframe);
        ZCPanel zcPanel=new ZCPanel(zCframe,dlPanel,dlframe,panel);

        frame.add(panel);
        dlframe.add(dlPanel);

        zCframe.add(zcPanel);
        frame.setVisible(false);;
        dlframe.setVisible(true);
        zCframe.setVisible(false);


    }
}
