import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        int splitLength = sc.nextInt();
        long[] numberParts = split(number, splitLength);
        long sum = 0;
        for (int i = 0; i < numberParts.length; i++) {
            sum += numberParts[i];
        }
        System.out.println(sum);
    }

    public static long[] split(String number, int Length) {
        int size = (int) Math.ceil((double) number.length() / Length);
        String[] parts = new String[size];
        int j = 0;
        for (int i = 0; i < number.length(); i += Length) {
            int end = Math.min(number.length(), i + Length);
            parts[j++] = number.substring(i, end);
        }
        for (int i = 0; i < size; i++) {
            parts[i] = new StringBuilder(parts[i]).reverse().toString();
        }
        long[] numberLong = new long[size];
        for (int i = 0; i < size; i++) {
            numberLong[i] = Long.parseLong(parts[i]);
        }
        return numberLong;
    }
}





