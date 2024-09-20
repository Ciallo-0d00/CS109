public class lab3 {
    public static void main(String[] args) {
        myLabel: // 这是标签
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i * j > 6) {
                    System.out.println("Breaking out of nested loop at i=" + i + ", j=" + j);
                    break myLabel; // 跳出外层循环
                }
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
        System.out.println("End of outer loop.");
    }
}
