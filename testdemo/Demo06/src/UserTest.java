import java.util.Scanner;
public class UserTest {
    public static void main(String[] args) {
//        User user = new User("Lucy");
//        Scanner in = new Scanner(System.in);
//        user.setPassword("123456");
//        user.setMoney(1000);
//        user.introduce();
//        user.expense(2000, in);
//        user.expense(500, in);
//        user.income(1000);
//        user.introduce();
//        in.close();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        User[] users = new User[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Please input the name for the user" + (i+1));
            String name = sc.nextLine();
            users[i] = new User(name);
            System.out.println("Please input the money for the user" + (i+1));
            double money = sc.nextDouble();
            sc.nextLine();
            users[i].setMoney(money);


        }
    }
}