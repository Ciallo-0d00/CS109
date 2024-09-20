import java.util.Scanner;

public class checkBingoGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(check(board,m,n));

    }

    public static int check(int[][] board, int row, int column) {
        int count = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < column - 1; j++) {
                if (board[i + 1][j] == 1 && board[i][j + 1] == 1 &&
                        board[i][j - 1] == 1 && board[i - 1][j] == 1 &&
                        board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
