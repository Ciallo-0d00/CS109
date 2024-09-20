import javax.swing.*;
import java.io.*;
import java.util.HashMap;
public class AccountManager {
    private final HashMap<String, String> accounts;
    ZCframe zCframe;
    GamePanel gamePanel;
    public AccountManager(ZCframe zCframe, GamePanel gamePanel) {
        this.gamePanel=gamePanel;
        this.zCframe = zCframe;
        HashMap<String, String> accounts1;
        accounts1 = loadAccounts();
        if (accounts1 == null) {
            accounts1 = new HashMap<>();
        }
        accounts = accounts1;
    }

    private HashMap<String, String> loadAccounts() {
        try {
            FileInputStream fileIn = new FileInputStream("accounts.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            HashMap<String, String> accounts = (HashMap<String, String>) in.readObject();
            in.close();
            fileIn.close();
            return accounts;
        } catch (IOException i) {
            System.out.println("帐号文件丢失");
            return null;
        }catch (ClassNotFoundException i){
            System.out.println("Class丢失");
            return null;
        }
    }

    private void saveAccounts() {
        try {
            FileOutputStream fileOut = new FileOutputStream("accounts.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(accounts);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in accounts.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void register(String playername,String password) {
        if (accounts.containsKey(playername)) {
            Object[] options={"确定"};
            int res= JOptionPane.showOptionDialog(null,"用户名已存在","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            return;
        }
        accounts.put(playername, password);
        this.saveAccounts();
        GameState gamestate = new GameState(playername,password);//注册后新建个GameState实例
        Object[] options={"确定"};
        int res= JOptionPane.showOptionDialog(null,"注册成功，小飞棍来喽！","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
    }

    public void login(String playername,String password,DL dl) {
        if (!accounts.containsKey(playername)) {
            Object[] options={"那我去注册","那我是游客"};
            int res= JOptionPane.showOptionDialog(null,"BYD你没注册","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(res==0){zCframe.setVisible(true);
            }//弹窗
            dl.setSfdl(false);
            return;
        }
        String storedPassword = accounts.get(playername);
        if (password.equals(storedPassword)) {
            Object[] options={"确定"};
            int res= JOptionPane.showOptionDialog(null,"登陆成功，欢迎回来","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            dl.setSfdl(true);
        } else {
            Object[] options={"确定"};
            int res= JOptionPane.showOptionDialog(null,"密码错了，动动脑子","讲真的：",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }

}