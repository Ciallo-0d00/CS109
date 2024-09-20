import javax.swing.*;
import java.awt.*;

public class ZCPanel extends JPanel {
    private DLPanel dlPanel;
    private DLframe dLframe;
    private GamePanel gamePanel;
    ZCPanel panel=null;
    ZC zc;
    ZCframe zcf=new ZCframe();
    private JTextField jt1=new JTextField(20);
    private JTextField jt2=new JTextField(20);


    public ZCPanel(ZCframe zcf,DLPanel dlPanel,DLframe dLframe,GamePanel gamePanel){
        this.setLayout(null);
        this.setOpaque(false);
        this.zcf=zcf;
        this.dlPanel=dlPanel;
        this.dLframe=dLframe;
        zc = new ZC(zcf,dlPanel,dLframe,this,gamePanel);
        this.panel=this;
        creatbt();
    }



    private void creatbt(){
        JLabel jl1=new JLabel("账号：");
        JLabel jl2=new JLabel("密码：");
        JButton jb1=new JButton("注册");
        JButton jb2=new JButton("返回");

        jb1.requestFocus();
        jb2.requestFocus();

        jt1.setBounds(120,180,200,20);
        jt2.setBounds(120,210,200,20);
        jl1.setBounds(80,180,40,20);
        jl2.setBounds(80,210,40,20);
        jb1.setBounds(110,240,60,30);
        jb2.setBounds(210,240,60,30);
        jb1.addActionListener(zc);
        jb2.addActionListener(zc);

        this.add(jt1);
        this.add(jt2);
        this.add(jl1);
        this.add(jl2);
        this.add(jb1);
        this.add(jb2);

    }


    public String getJt1(){
        return jt1.getText();
    }//账号
    public String getJt2(){return jt2.getText();}//密码
}
