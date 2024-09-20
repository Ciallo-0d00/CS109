import java.util.Arrays;
import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        double[] myList1 = new double[20];
        double[] myList2 = new double[20];
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            myList1[i] = sc.nextDouble();
        }
        for (int i = 0; i < 20; i++) {
            myList2[i] = myList1[i];
        }
        for (int i = 0; i < count; i++) {
            System.out.print(myList1[i]+" ");

        }
       }
}
