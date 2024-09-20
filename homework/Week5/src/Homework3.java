import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        int[][] grids = new int[2000][2000];
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 1001; i < 1001+m; i++) {
            for (int j = 1001; j < 1001+n; j++) {
                grids[i][j] = sc.nextInt();
            }
        }
        int start = sc.nextInt();
        int k = sc.nextInt();
        int x = 0;
        int y = 0;
        boolean found = false;
        for (int i = 1001; i < 1001+m; i++) {
            for (int j = 1001; j < 1001+n; j++) {
                if (grids[i][j] == start) {
                    found = true;
                    y = i;
                    x = j;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        int count = 0;
        outLoop:
        for (int i = 1; i < Math.max(m, n); i++) {
            for (int j = 1; j <= 2*i-1; j++) {
                x+=1;
                if(x <= 1000+n && x>=1001 && y<=1000+m && y>=1001){
                    count++;
                }
                if (count==k){
                    break outLoop;
                }
            }
            for (int j = 1; j <= 2*i-1; j++) {
                y+=1;
                if(x <= 1000+n && x>=1001 && y<=1000+m && y>=1001){
                    count++;
                }
                if (count==k){
                    break outLoop;
                }
            }
            for (int j = 1; j <= 2*i; j++) {
                x-=1;
                if(x <= 1000+n && x>=1001 && y<=1000+m && y>=1001){
                    count++;
                }
                if (count==k){
                    break outLoop;
                }
            }
            for (int j = 1; j <= 2*i; j++) {
                y-=1;
                if(x <= 1000+n && x>=1001 && y<=1000+m && y>=1001){
                    count++;
                }
                if (count==k){
                    break outLoop;
                }
            }

        }

        System.out.println(grids[y][x]);
    }
}