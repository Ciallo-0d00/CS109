import java.util.HashMap;
import java.util.Scanner;

public class AccountManager {
    private final HashMap<String, String> accounts = new HashMap<>();
    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter playername: ");
        String playername = scanner.nextLine();
        if (accounts.containsKey(playername)) {
            System.out.println("Playername already exists!");
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
        String playername = scanner.nextLine();
        if (!accounts.containsKey(playername)) {
            System.out.println("Playername does not exist!");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String storedPassword = accounts.get(playername);
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
            scanner.nextLine(); // consume newline
            switch (option) {
                case 1:
                    manager.register();
                    break;
                case 2:
                    manager.login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}