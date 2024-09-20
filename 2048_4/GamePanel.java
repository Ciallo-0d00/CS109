
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    private JFrame frame=null;
    private DL dl;
    private GamePanel panel=null;
    private Card[][] cards=new Card[4][4];
    private String Gamezt="Cl";
    private DLframe dlframe=new DLframe();
    private GameState gameState;
    Image bj=Toolkit.getDefaultToolkit().getImage("resource/1716826671322.png");
    int step=0;
    private Timer timer;
    int time=0;
    long stime=0;
    long dtime = 0;
    JButton backdl;
    public String moShi="JD";
    private int[] numb={2,4,8,16,32,64,128,256,512,1024,2048};
    private final int repaintX = 450;
    private final int repaintY = 20;
    private final int repaintWidth = 160;
    private final int repaintHeight = 80;
    private final int repaintX1 = 24;
    private final int repaintY1 = 25;
    private final int repaintWidth1 = 352;
    private final int repaintHeight1 = 352;
    File soundFile =new File("resource/xm2749.wav");
    AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(soundFile);
    Clip clip =AudioSystem.getClip();



    public GamePanel(JFrame frame,DLframe dLframe) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    this.dlframe=dLframe;
    this.setLayout(null);
    this.setOpaque(false);
    this.frame=frame;
    this.panel=this;
    creatKeyLis();
    creatMenu();
    creatCard();

   }

    private void creatzaw() {
       if(moShi.equals("zaw")){
           if(step%5==0) {
               int s1=0;
               int s2=0;
               Card card1;
               Card card2;
               card1=getRCards();

               s1=card1.getnum();
               card1.setnum(s1*10);

               card2=getRCards();

               s2=card2.getnum();
               card2.setnum(s2*10);
           }
       }
    }
    private void cjzaw(){

    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }
    private void load(){
        if(gameState != null){
            GameState gameState1 = GameState.loadGameState(gameState.getPlayerName());
            if (gameState1.isIfSaved() == true){
                gameState = gameState1;
                this.moShi = gameState.getMoShi();
                this.cards = gameState.getCards();
                this.step = gameState.getsteps();
                this.time = gameState.getTime();
                Object[] options={"确定"};
                int res=JOptionPane.showOptionDialog(null,"读档成功!","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);//弹窗
            }else{
                Object[] options={"确定"};
                int res=JOptionPane.showOptionDialog(null,"byd没存档","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);//弹窗
            }
            Gamezt = "Lo";
            repaint();
            if (timer != null) {
                timer.stop();
                timer = null;
            }
        }else{
            Object[] options={"确定"};
            int res=JOptionPane.showOptionDialog(null,"你没登陆，你是游客","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);//弹窗
        }
        //待补充
    }
    private void save(){
       if(gameState != null){
           gameState.setCards(cards);
           gameState.setSteps(step);
           gameState.setTime(time);
           gameState.setMoShi(moShi);
           gameState.setIfSaved(true);
           GameState.saveGameState(this.gameState);
           Object[] options={"确定"};
           int res=JOptionPane.showOptionDialog(null,"存档成功","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);//弹窗
       }else{
           Object[] options={"确定"};
           int res=JOptionPane.showOptionDialog(null,"你没登陆，你是游客。","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);//弹窗
       }
    }

    private void creatKeyLis() {
        KeyAdapter KA=new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(!"St".equals(Gamezt)){
                    return;
                }
                int key=e.getKeyCode();
                switch (key){
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        try {
                            movc("w");
                        } catch (LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        frame.requestFocusInWindow();
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        try {
                            movc("s");
                        } catch (LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        frame.requestFocusInWindow();
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        try {
                            movc("d");
                        } catch (LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        frame.requestFocusInWindow();
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        try {
                            movc("a");
                        } catch (LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        frame.requestFocusInWindow();
                        break;
                }
            }
        };
        frame.addKeyListener(KA);
    }

    private void movc(String s) throws LineUnavailableException, IOException {
       huifu();
       if(s.equals("w")){if(mU(false)){mU(true);creatRandomnum();step++;creatzaw();}}
       else if(s.equals("s")){if(mD(false)){mD(true);creatRandomnum();step++;creatzaw();}}
       else if(s.equals("d")){if(mR(false)){mR(true);creatRandomnum();step++;creatzaw();}}
       else if(s.equals("a")){if(mL(false)){mL(true);creatRandomnum();step++;creatzaw();}}

       clip.start();
       clip.close();

       repaint(repaintX1, repaintY1, repaintWidth1, repaintHeight1);
       repaint(repaintX, repaintY, repaintWidth, repaintHeight);
       gameOverorNot();
    }

    private void gameOverorNot() {
       if(Win()){
           gameWin();
       }else if(CF()){
           if(mL(false)||mR(false)||mU(false)||mD(false)){return ;
       }else {gameOver();}}
    }

    private void gameOver() {
       Gamezt="Cl";
        if (timer != null) {
            timer.stop();
            repaint();
        }
       UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("黑体",Font.ITALIC,18)));
       UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("黑体",Font.ITALIC,18)));
       JOptionPane.showMessageDialog(frame,"水平这么低也配玩游戏？菜就多练！","不是，哥们！",JOptionPane.INFORMATION_MESSAGE);
    }

    private void gameWin() {
       Gamezt="Cl";
        if (timer != null) {
            timer.stop();
        }
       UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("黑体",Font.ITALIC,18)));
       UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("黑体",Font.ITALIC,18)));
       JOptionPane.showMessageDialog(frame,"还行吧，算你过关！");
    }

    private boolean Win() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Card card=cards[i][j];
                if(card.getnum() == 2048){
                    return true;
                }
            }}
        return false;
    }

    private void huifu() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Card card=cards[i][j];
                card.sethbglm(false);
            }}
    }

    private boolean mL(boolean b) {
       boolean k=false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <4; j++) {
                Card card=cards[i][j];
                if(card.getnum()!=0){
                    if(card.cL(cards,b)){k=true;}
                }
            }
        }return k;
    }

    private boolean mR(boolean b) {
        boolean k=false;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >=0; j--) {
                Card card=cards[i][j];
                if(card.getnum()!=0){
                    if(card.cR(cards,b)){k=true;};
                }
            }
        }return k;
    }

    private boolean mD(boolean b) {
        boolean k=false;
        for (int i = 2; i >=0; i--) {
            for (int j = 0; j <4; j++) {
                Card card=cards[i][j];
                if(card.getnum()!=0){
                    if(card.cD(cards,b)){k=true;}
                }
            }
        }return k;
    }

    private boolean mU(boolean b) {
       boolean k=false;
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
               Card card=cards[i][j];
               if(card.getnum()!=0){
                   if(card.cU(cards,b)){k=true;};
               }
            }
        }return k;
    }

    private void creatRandomnum() {
       int num=0;
       Random random=new Random();
       int n=random.nextInt(4)+1;
       if(n==1){
           num=4;
       }else {num=2;}

       if(CF()){
           return;
       }

       Card card=getRCard();

       if(card!=null){
           card.setnum(num);
       }
    }

    private boolean CF() {
       Card card;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                card=cards[i][j];
                if(card.getnum()==0){return false;}
            }
        }
        return true;
    }

    private boolean CFs(Card card){
       for(int i:numb){
           if(card.getnum()==i){return true;}
       }return false;
    }
    private Card getRCard() {
       Card card=null;
        Random random=new Random();
        int ii=random.nextInt(4);
        int jj=random.nextInt(4);
        card=cards[ii][jj];
        if(card.getnum()==0){
            return card;
        }
        return getRCard();
    }

    private Card getRCards() {
        Card card=null;
        Random random=new Random();
        int ii=random.nextInt(4);
        int jj=random.nextInt(4);
        card=cards[ii][jj];
        if(CFs(card)){
            return card;}return getRCard();
        }


    private void creatMenu(){
    JMenuBar jmb=new JMenuBar();


    JMenu jMenu1=new JMenu("游戏");

    JMenuItem jmi1=new JMenuItem("新游戏");
    JMenuItem jmi2=new JMenuItem("退出");

    jMenu1.add(jmi1);
    jMenu1.add(jmi2);


    JMenu jMenu2=new JMenu("帮助");

    JMenuItem jmi3=new JMenuItem("<html>你不会玩吗？<br>（看文字规则）<html>");
    JMenuItem jmi4=new JMenuItem("<html>不会就去学！<br>（看实机视频）<html>");

    jMenu2.add(jmi3);
    jMenu2.add(jmi4);


    jmb.add(jMenu1);
    jmb.add(jMenu2);
    frame.setJMenuBar(jmb);

    jmi1.addActionListener(this);
    jmi2.addActionListener(this);
    jmi3.addActionListener(this);
    jmi4.addActionListener(this);

    jmi1.setActionCommand("restart");
    jmi2.setActionCommand("exit");
    jmi3.setActionCommand("??");
    jmi4.setActionCommand("!!");
   }

    @Override
    public void actionPerformed(ActionEvent e) {
       String command=e.getActionCommand();
       if("restart".equals(command)){
           Object[] options={"我要重开！","真按错了，哥！"};
           int res=JOptionPane.showOptionDialog(null,"你想重开？","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
           if(res==0){
               Card card;
               for (int i = 0; i < 4; i++) {
                   for (int j = 0; j < 4; j++) {
                       card=cards[i][j];
                       card.setnum(0);
                   }
               }
               step=0;
               Gamezt="Cl";
               if (timer != null){
                   timer.stop();
               }
               time = 0;
               repaint();
           }
       }else if("exit".equals(command)){
        Object[] options={"包退的，牢弟！","按错了，尼玛！"};
           int res=JOptionPane.showOptionDialog(null,"真退吗？哥！","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
           if(res==0){System.exit(0);}
       }else if("??".equals(command)){

       }else if("!!".equals(command)){

       }
    }

    public void creatCard(){
       Card card;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                card=new Card(i,j);
                cards[i][j]=card;
            }
        }
    }
    @Override
    public void paint(Graphics g) {
      g.drawImage(bj,0,0,null);
       drawCard(g);
       drawTimeScore(g);
        creatButton();
    }

    private void drawTimeScore(Graphics g) {
       g.setColor(Color.ORANGE);
       g.setFont(new Font("Lavanderia Regular",Font.ITALIC,40));
       g.drawString("time:"+time,450,50);
       g.drawString("step:"+step,450,85);
    }

    private void drawCard(Graphics g){
       Card card;
       for (int i = 0; i < 4; i++) {
           for (int j = 0; j < 4; j++) {
               card=cards[i][j];
               card.draw(g);
           }
       }
    }

    private void creatButton(){
         JButton butw=new JButton();
         JButton buts=new JButton();
         JButton buta=new JButton();
         JButton butd=new JButton();
         JButton butst=new JButton();
        backdl=new JButton("  登录/切换账号");
        JButton butbc=new JButton("保存");
        JButton butdq=new JButton("读取");

        butw.setIcon(new ImageIcon(getClass().getResource("resource/Image_1716812608152.png")));
        buts.setIcon(new ImageIcon(getClass().getResource("resource/IMG_20240527_222126.png")));
        buta.setIcon(new ImageIcon(getClass().getResource("resource/IMG_20240527_222134.png")));
        butd.setIcon(new ImageIcon(getClass().getResource("resource/IMG_20240527_222141.png")));
        butst.setIcon(new ImageIcon(getClass().getResource("resource/1716813126068.png")));
        butw.setBorderPainted(false);
        buts.setBorderPainted(false);
        buta.setBorderPainted(false);
        butd.setBorderPainted(false);
        butst.setBorderPainted(false);


        Font fif=new Font("黑体",Font.BOLD,7);

        panel.add(butw);
        panel.add(buts);
        panel.add(buta);
        panel.add(butd);
        panel.add(butst);
        panel.add(backdl);
        panel.add(butbc);
        panel.add(butdq);
        butw.setBounds(500,200,48,48);
        buts.setBounds(500,300,48,48);
        buta.setBounds(450,250,48,48);
        butd.setBounds(550,250,48,48);
        butst.setBounds(500,250,48,48);
        backdl.setBounds(600,420,80,20);
        butbc.setBounds(600,100,80,20);
        butdq.setBounds(600,130,80,20);
        butw.setBorderPainted(false);
        buts.setBorderPainted(false);
        buta.setBorderPainted(false);
        butd.setBorderPainted(false);
        butst.setFont(fif);

        butbc.addActionListener(e -> {
            save();
            frame.requestFocusInWindow();
        });
        butdq.addActionListener(e -> {
            load();
            frame.requestFocusInWindow();
        });

        butst.addActionListener(e -> {
            frame.requestFocusInWindow();
            if (Gamezt.equals("Cl") || Gamezt.equals("Lo")) {
                if (moShi.equals("djs")) {
                    if (Gamezt.equals("Cl")) {
                        creatRandomnum();
                        creatRandomnum();
                        repaint();
                        time = 600;
                    }
                    timer = new Timer(1000, evt -> {
                        if (time > 0) {
                            time--;
                        } else {
                            timer.stop();
                            gameOver();
                        }
                        if(time%20==0){
                            save();
                        }
                        repaint(repaintX, repaintY, repaintWidth, repaintHeight);
                    });
                    timer.start();
                } else if (moShi.equals("JD")) {
                    if (Gamezt.equals("Cl")) {
                        creatRandomnum();
                        creatRandomnum();
                        repaint();
                        time = 0;
                    }
                    timer = new Timer(1000, evt -> {
                        time++;
                        repaint(repaintX, repaintY, repaintWidth, repaintHeight);
                        if(time%20==0){
                            save();
                        }
                    });
                    timer.start();
                }
                Gamezt = "St";
            }
        });
        backdl.addActionListener(e -> {
            dlframe.setVisible(true);
            frame.requestFocusInWindow();
        });

        butw.addActionListener(e -> {
            huifu();
            if(mU(false)&&"St".equals(Gamezt)){mU(true);creatRandomnum();step++;repaint();gameOverorNot();
            };frame.requestFocusInWindow();
        });
        butd.addActionListener(e -> {
            huifu();
            if(mR(false)&&"St".equals(Gamezt)){mR(true);creatRandomnum();step++;repaint();gameOverorNot();
                }frame.requestFocusInWindow();
        });
        buta.addActionListener(e -> {
            huifu();
            if(mL(false)&&"St".equals(Gamezt)){mL(true);creatRandomnum();step++;repaint();gameOverorNot();
                }frame.requestFocusInWindow();
        });
        buts.addActionListener(e -> {
            huifu();
            if(mD(false)&&"St".equals(Gamezt)){mD(true);creatRandomnum();step++;repaint();gameOverorNot();
                }frame.requestFocusInWindow();
        });



   }









}
