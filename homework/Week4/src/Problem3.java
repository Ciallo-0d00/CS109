import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();//numbers of balloons
        int m = sc.nextInt();//numbers of rows
        int n = sc.nextInt();//numbers of columns
        int[][] block = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                block[i][j] = sc.nextInt();
            }
        }
        int validBalloons = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (block[j][i] == 0 && (j - 1 < 0 || block[j - 1][i] == 0 || block[j - 1][i] == 3) && (j + 1 >= m || block[j + 1][i] == 0 ||block[j + 1][i] == 3)) {
                    validBalloons++;
                    block[j][i] = 2;
                    if (j - 1 >= 0) {
                        block[j - 1][i] = 3;
                    }
                    if (j + 1 < m) {
                        block[j + 1][i] = 3;
                    }
                }
            }
        }
        if(validBalloons>=num){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(block[i][j]);
//            }
//        }
//        System.out.println("");
//        System.out.println(validBalloons);

    }
}
