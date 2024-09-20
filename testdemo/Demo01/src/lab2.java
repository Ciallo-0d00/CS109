import java.util.Random;
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length:");
        double a = sc.nextDouble();
        System.out.print("Enter the width:");
        double b = sc.nextDouble();
        double area = a*b;
        double peri = 2*(a+b);
        System.out.printf("The area is %.2f\n",area);
        System.out.printf("The perimeter is %-40f\n",peri);

        if (area > 33){
            System.out.println("too big");
        }else if (area < 33){
            System.out.println("too small");
        }else{
            System.out.println("Well done");
        }







    }




}
