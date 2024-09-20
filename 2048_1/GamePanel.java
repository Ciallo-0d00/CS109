
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    private JFrame frame=null;
    private GamePanel panel = null;
    private Card[][] cards=new Card[4][4];
    private String Gamezt="St";
    private ArrayList users = new ArrayList<>();
    Image bj=Toolkit.getDefaultToolkit().getImage("resource/IMG_20240519_191636.jpg");
    int step=0;
    long time=0;
    long stime=0;
    long endtime=0;

   public GamePanel(JFrame frame){
    this.setLayout(null);
    this.setOpaque(false);
    this.frame=frame;
    this.panel=this;
    creatMenu();
    creatCard();
    creatRandomnum();
    creatRandomnum();
    creatKeyLis();
   }

    public void saveGame() {
        GameState gameState = new GameState(cards, Gamezt);
        GameUtils.saveGameState(gameState);
        // 可能还要提示用户游戏已保存
    }

    public void loadGame() {
        GameState loadedGameState = GameUtils.loadGameState();
        if (loadedGameState != null) {
            this.cards = loadedGameState.getCards();
            this.Gamezt = loadedGameState.getGameStatus();
            // 可能还需要更新界面等操作
        } else {
            // 处理加载失败的情况
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
                        movc("w");
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        movc("s");
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        movc("d");
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        movc("a");
                        break;
                }
            }
        };
        frame.addKeyListener(KA);
    }

    private void movc(String s){
       huifu();
       if(s.equals("w")){if(mU(false)){mU(true);creatRandomnum();step++;}}
       else if(s.equals("s")){if(mD(false)){mD(true);creatRandomnum();step++;}}
       else if(s.equals("d")){if(mR(false)){mR(true);creatRandomnum();step++;}}
       else if(s.equals("a")){if(mL(false)){mL(true);creatRandomnum();step++;}}
       repaint();
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
       UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("黑体",Font.ITALIC,18)));
       UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("黑体",Font.ITALIC,18)));
       JOptionPane.showMessageDialog(frame,"水平这么低也配玩游戏？菜就多练！","不是，哥们！",JOptionPane.INFORMATION_MESSAGE);
    }

    private void gameWin() {
       Gamezt="Cl";
       UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("黑体",Font.ITALIC,18)));
       UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("黑体",Font.ITALIC,18)));
       JOptionPane.showMessageDialog(frame,"还行吧，算你过关！");
    }

    private boolean Win() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Card card=cards[i][j];
                if(card.getnum()==2048){
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
       int sl=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                card=cards[i][j];
                if(card.getnum()==0){return false;}
            }
        }
        return true;
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
               Gamezt="St";
               creatRandomnum();
               creatRandomnum();
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
       super.paint(g);
       g.drawImage(bj,0,0,null);
       drawCard(g);
       drawTimeScore(g);
    }

    private void drawTimeScore(Graphics g) {
       g.setColor(Color.ORANGE);
       g.setFont(new Font("黑体",Font.BOLD,20));
       g.drawString("时间:",450,50);
       g.drawString("步数:"+step,450,85);
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





}
