import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            String m = "";
            if (d == 0){
                m = 0+m;
            }
            while (d > 0) {
                int a = d%7;
                m = a + m;
                d/=7;
            }
            System.out.println(m);
        }
    }
}
