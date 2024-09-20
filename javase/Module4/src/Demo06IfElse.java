import java.util.Scanner;

public class Demo06IfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if ((year%4==0 && year%4!=0) || (year%400==0)){
            System.out.println("闰年");
        }else{
            System.out.println("平年");
        }
    }
}
