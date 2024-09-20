import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DL implements ActionListener {
    private GameFrame gameFrame;
    private DLPanel dlpanel;
    private DLframe dLframe;
    private GamePanel gamePanel;
    private ZCframe zCframe;
    private ZCPanel zcPanel;
    private boolean sfdl=false;
    private ZC zc;
    public DL(DLPanel dlpanel , GameFrame gameFrame,DLframe dLframe,GamePanel gamePanel,ZCframe zCframe,ZCPanel zcPanel) {
        this.dLframe=dLframe;
        this.dlpanel = dlpanel;
        this.gameFrame = gameFrame;
        this.gamePanel = gamePanel;
        this.zCframe = zCframe;
        this.zcPanel = zcPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton) e.getSource();
        String tx=bt.getText();
        switch (tx) {
            case "登录":
                String zh=dlpanel.getJt1();
                String mm=dlpanel.getJt2();
                AccountManager accountManager = new AccountManager();
                accountManager.login(zh,mm,this);
                if(sfdl){
                    gamePanel.setGameState(GameState.loadGameState(zh));
                    dLframe.setVisible(false);
                    gameFrame.setVisible(true);
                    gameFrame.setFocusable(true);
                    gameFrame.requestFocusInWindow();
                }
                break;
            case "重置":
                dlpanel.setJt1("");
                dlpanel.setJt2("");
                break;
            case "注册":
                zCframe.setVisible(true);
                break;
            case "游客模式":
                dLframe.setVisible(false);
                gameFrame.setVisible(true);
                break;
        }
    }

    public boolean isSfdl(){
        return sfdl;
    }

    public void setSfdl(boolean sfdl){
        this.sfdl=sfdl;
    }

}
