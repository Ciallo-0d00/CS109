import java.util.Scanner;
public class lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n>100){
            System.out.println(n+1);
        } else if (n%2==0) {
            System.out.println(n-1);
        }else {
            System.out.println(n*2);
        }
    }
}
