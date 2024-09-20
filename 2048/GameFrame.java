import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(){
        setTitle("2048");
        setSize(400, 450);
        getContentPane().setBackground(new Color(225,100,111));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(false);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }   
}
