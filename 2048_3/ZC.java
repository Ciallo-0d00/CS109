import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZC implements ActionListener {
    private DLPanel dlpanel;
    private DLframe dLframe;
    private ZCframe zCframe;
    private ZCPanel zcPanel;

    public ZC(ZCframe zCframe, DLPanel dlpanel, DLframe dLframe, ZCPanel zCPanel) {
        this.zCframe = zCframe;
        this.dlpanel = dlpanel;
        this.dLframe = dLframe;
        this.zcPanel = zCPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton) e.getSource();
        String tx=bt.getText();
        if(tx.equals("注册")){
            String zh=zcPanel.getJt1();
            String mm=zcPanel.getJt2();
            AccountManager accountManager = new AccountManager();
            accountManager.register(zh,mm);
        } else if (tx.equals("返回")) {
            zCframe.setVisible(false);
            dLframe.setVisible(true);
        }
    }


}
