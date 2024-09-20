import javax.swing.*;
import java.awt.*;

public class DLframe extends JFrame {
    public DLframe() {
        setTitle("登录");
        setSize(400, 450);
        getContentPane().setBackground(new Color(225,225,225));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(false);
        setLocationRelativeTo(null);
        setResizable(true);
    }
}
