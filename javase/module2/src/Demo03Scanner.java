import java.util.Scanner;

public class Demo03Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data1 = sc.next();
        sc.nextLine();
        String data2 = sc.nextLine();
        System.out.println(data1);
        System.out.println(data2);
    }
}
