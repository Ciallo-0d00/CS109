import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 读取测试案例的数量
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(); // 读取区间左端点
            int r = sc.nextInt(); // 读取区间右端点
            int count = 0; // 初始化计数器
            for (int j = l; j <= r; j++) { // 循环从 l 到 r
                if (j % 7 == 0) { // 如果 j 是 7 的倍数直接计数
                    count++;
                } else {
                    int temp = j; // 使用临时变量检查数字中是否包含7
                    while (temp > 0) {
                        if (temp % 10 == 7) { // 检查当前最低位是否为7
                            count++; // 如果包含7，计数
                            break; // 并退出 while 循环
                        }
                        temp /= 10; // 以检查下一个更高位
                    }
                }
            }
            System.out.println(count); // 输出计数结果
        }
    }
}