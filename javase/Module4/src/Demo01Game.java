import java.util.Random;
import java.util.Scanner;

public class Demo01Game {
    public static void main(String[] args) {
        //flase answer:
        //        Random rd = new Random();
//        int i = rd.nextInt(100);
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            int input = sc.nextInt();
//            int count = 0;
//            if (input > i) {
//                System.out.println("big");
//            } else if (input < i) {
//                System.out.println("small");
//            } else {
//                System.out.println("right!!!!");
//
//                System.out.println(count);
//                break;
//            }
//            count++;
//
//        }
        Random rd = new Random(); // 创建 Random 实例用于生成随机数
        int i = rd.nextInt(100);  // 生成一个0到99之间的随机数
        Scanner sc = new Scanner(System.in); // 创建 Scanner 实例用于读取用户输入
        int count = 0; // 将计数器初始化，并且移到循环外面

        while (true) {
            System.out.println("Please enter a number (0-99):");
            int input = sc.nextInt(); // 读取用户输入的数字
            count++; // 每次用户输入一个数字，计数器递增

            if (input > i) {
                System.out.println("It's too big!");
            } else if (input < i) {
                System.out.println("It's too small!");
            } else {
                System.out.println("You got it right!!!!");
                break; // 如果猜对了，跳出循环
            }

        }
        System.out.println("You tried " + count + " times."); // 输出用户尝试的次数
        sc.close(); // 关闭 Scanner

    }
}
