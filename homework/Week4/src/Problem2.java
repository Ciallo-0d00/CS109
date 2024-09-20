import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        int[][] movies = new int[3][100];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                movies[i][j] = sc.nextInt();
            }
        }
        int[] totalMovie = new int[1001];
        for (int i = 1; i < 1001; i++) {
            totalMovie[i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < movies[i].length; j++) {
                totalMovie[movies[i][j]]++;
            }
        }
        int countf = 0;
        for (int i = 1; i < 1001; i++) {
            if (totalMovie[i]==3){
                countf++;
            }
        }
        System.out.println(countf);
    }
}
