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
            System.out.println("Accounts file not found, creating a new one.");
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
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
            System.out.println("Playername already exists!");
            return;
        }
        accounts.put(playername, password);
        this.saveAccounts();
        GameState gamestate = new GameState(playername,password);//注册后新建个GameState实例
        System.out.println("Registration successful!");
    }

    public void login(String playername,String password,DL dl) {
        if (!accounts.containsKey(playername)) {
            System.out.println("Playername does not exist!");
            return;
        }
        String storedPassword = accounts.get(playername);
        if (password.equals(storedPassword)) {
            System.out.println("Login successful!");
            dl.setSfdl(true);
        } else {
            System.out.println("Incorrect password!");
        }
    }
//下面是测试类
//    public static void main(String[] args) {
//        AccountManager manager = new AccountManager();
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//            System.out.println("3. Exit");
//            System.out.print("Choose an option: ");
//            int option = scanner.nextInt();
//            scanner.nextLine();
//            switch (option) {
//                case 1:
//                    manager.register();
//                    break;
//                case 2:
//                    manager.login();
//                    break;
//                case 3:
//                    System.out.println("Exiting...");
//                    manager.saveAccounts();
//                    return;
//                default:
//                    System.out.println("Invalid option!");
//            }
//        }
//    }
}