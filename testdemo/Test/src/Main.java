import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    public static void main(String[] args) {
        //private lcon welcomelcon = new Imagelcon("welcome.png");
        //private JLabel lbWelcome =new Jabel(welcomelcon):
        JLabel IbAccount= new JLabel("请您输入账号");
        JTextField tfAccount = new JTextField(10);
        JLabel lbPassword= new JLabel("请您输入密码");
        JPasswordField pfPassword= new JPasswordField(10);
        JButton btLogin = new JButton("登录");
        JButton btRegister = new JButton("注册");
        JButton btExit = new JButton("退出");
    }
    //private lcon welcomelcon = new Imagelcon("welcome.png");
    //private JLabel lbWelcome =new Jabel(welcomelcon):
//     private JLabel IbAccount= new JLabel("请您输入账号");
//     private JTextField tfAccount = new JTextField(10);
//    private JLabel lbPassword= new JLabel("请您输入密码");
//    private JPasswordField pfPassword= new JPasswordField(10);
//    private JButton btLogin = new JButton("登录");
//    private JButton btRegister = new JButton("注册");
//    private JButton btExit = new JButton("退出");

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

