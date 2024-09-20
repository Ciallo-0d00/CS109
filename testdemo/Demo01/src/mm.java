import java.util.Scanner;
public class mm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = a;
        int m = 0;
        int l = 0;

        while (c >= a & c <= b) {
            if (c % 7 == 0) {
                m += 1;
                c += 1;
            } else {
                String d = String.valueOf(c);
                l=0;
                while (l < d.length() ) {
                    if (d.charAt(l) == '7') {
                        m += 1;
                        c += 1;
                        l += 1;
                    } else {
                        l += 1;
                    }
                }

            }

        }
        System.out.println(m);}}