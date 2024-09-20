import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

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
    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter playerrname: ");
        String playername = scanner.nextLine();
        if (accounts.containsKey(playername)) {
            System.out.println("Username already exists!");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        accounts.put(playername, password);
        GameState gamestate = new GameState(playername,password);//注册后新建个GameState实例
        System.out.println("Registration successful!");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter playername: ");
        String username = scanner.nextLine();
        if (!accounts.containsKey(username)) {
            System.out.println("Playername does not exist!");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String storedPassword = accounts.get(username);
        if (password.equals(storedPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Incorrect password!");
        }
    }

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    manager.register();
                    break;
                case 2:
                    manager.login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    manager.saveAccounts();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}