import java.io.*;
import java.util.HashMap;
public class AccountManager {
    private final HashMap<String, String> accounts;
    public AccountManager() {
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
            System.out.println("用户名已存在");//这里做个弹窗
            return;
        }
        accounts.put(playername, password);
        this.saveAccounts();
        GameState gamestate = new GameState(playername,password);//注册后新建个GameState实例
        System.out.println("注册成功，小飞棍来咯");//这里弹窗
    }

    public void login(String playername,String password,DL dl) {
        if (!accounts.containsKey(playername)) {
            System.out.println("byd没注册");//弹窗
            dl.setSfdl(false);
            return;
        }
        String storedPassword = accounts.get(playername);
        if (password.equals(storedPassword)) {
            System.out.println("登陆成功，欢迎回来");//弹窗
            dl.setSfdl(true);
        } else {
            System.out.println("密码错了，动动脑子");//弹窗
        }
    }

}