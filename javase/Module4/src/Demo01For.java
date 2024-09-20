import java.util.Scanner;

public class Demo01For {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        Double i = sc.nextDouble();
        Double d = sc.nextDouble();
        int c = sc.nextInt();
        for (int count = 1;count <= c;count++){
            sum+=d;
        }
        System.out.println(sum);
    }
}
