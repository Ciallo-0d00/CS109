import java.util.InputMismatchException;
import java.util.Scanner;

public class Main { // 确保类名与文件名相同
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        do {
            try {
                System.out.print("Enter an integer numerator: ");
                int numerator = scanner.nextInt();
                System.out.print("Enter an integer denominator: ");
                int denominator = scanner.nextInt();
                int result = numerator / denominator;
                System.out.printf("Result: %d / %d = %d\n", numerator, denominator, result);
                continueLoop = false;
            } catch(InputMismatchException inputMismatchException) {
                System.err.printf("Exception: %s\n", inputMismatchException);
                scanner.nextLine(); // discard input so user can try again
            } catch(ArithmeticException arithmeticException) {
                System.err.printf("Exception: %s\n", arithmeticException);
            } finally {
                // 只有在循环结束时才关闭scanner
                if (!continueLoop) {
                    scanner.close();
                }
            }
        } while(continueLoop);
    }
}