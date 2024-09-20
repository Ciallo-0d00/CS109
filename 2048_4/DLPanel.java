import javax.swing.*;
import java.awt.event.ActionListener;

public class DLPanel extends JPanel{
    private GameFrame gameFrame;
    private DLPanel panel=null;
    private DLframe dlframe=null;
    private GamePanel gamePanel=null;
    private ZCPanel zcPanel=null;
    private ZCframe zcframe=null;
    private JTextField jt1=new JTextField(20);
    private JTextField jt2=new JTextField(20);
    private JLabel jl1=new JLabel("账号：");
    private JLabel jl2=new JLabel("密码：");
    private JButton jb1=new JButton("登录");
    private JButton jb2=new JButton("重置");
    private JButton jb3=new JButton("注册");
    private JButton jb4=new JButton("游客模式");
    private JLabel jl5=new JLabel("选择模式:");
    private ButtonGroup bg=new ButtonGroup();
    private JButton rb1=new JButton("经典模式");

    private JButton rb3=new JButton("倒计时模式");
    DL dl;

    public DLPanel(GameFrame gameFrame,DLframe dLframe,GamePanel gamePanel,ZCframe zCframe) {
        this.gameFrame=gameFrame;
        this.dlframe=dLframe;
        this.gamePanel=gamePanel;
        this.zcframe=zCframe;
        dl=new DL(this,gameFrame,dLframe,gamePanel,zCframe,zcPanel);
        this.setLayout(null);
        this.setOpaque(false);
        this.panel=this;
        creatth();
    }

    public void creatth(){
        this.add(jt1);
        this.add(jt2);
        this.add(jl1);
        this.add(jl2);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jl5);
        this.add(rb1);

        this.add(rb3);
        bg.add(rb1);

        bg.add(rb3);
        jt1.setBounds(120,180,200,20);
        jt2.setBounds(120,210,200,20);
        jl1.setBounds(80,180,40,20);
        jl2.setBounds(80,210,40,20);
        jb1.setBounds(110,240,60,30);
        jb2.setBounds(210,240,60,30);
        jb3.setBounds(300,380,60,20);
        jb4.setBounds(0,380,90,20);
        jl5.setBounds(90,380,90,20);
        rb1.setBounds(160,380,100,20);
        rb3.setBounds(160,360,100,20);
        jb1.addActionListener(dl);
        jb2.addActionListener(dl);
        jb3.addActionListener(dl);
        jb4.addActionListener(dl);
        rb1.addActionListener(dl);
        rb3.addActionListener(dl);

    }

    public void setJt1(String str){
        jt1.setText(str);
    }
    public void setJt2(String str){
        jt2.setText(str);
    }
    public String getJt1(){
        return jt1.getText();
    }//账号
    public String getJt2(){return jt2.getText();}//密码

}
