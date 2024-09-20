import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println("");
            for (int j = 1; j <= i; j++) {
                int multiple = i*j;
                System.out.print(""+j+"*"+i+"="+multiple+" ");

            }
        }
    }
}
