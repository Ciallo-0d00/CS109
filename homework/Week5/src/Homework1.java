import java.util.Arrays;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        int[][][] mixedInformation = new int[2][3][101];
        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(",");
            if (parts[0].equals("C")){
                if (parts[1].equals("theory")){
                    mixedInformation[0][0][i] = Integer.parseInt(parts[2]);
                }else if(parts[1].equals("lab")){
                    mixedInformation[0][1][i] = Integer.parseInt(parts[2]);
                }else{
                    mixedInformation[0][2][i] = Integer.parseInt(parts[2]);
                }
            }else{
                if (parts[1].equals("theory")){
                    mixedInformation[1][0][i] = Integer.parseInt(parts[2]);
                }else if(parts[1].equals("lab")){
                    mixedInformation[1][1][i] = Integer.parseInt(parts[2]);
                }else{
                    mixedInformation[1][2][i] = Integer.parseInt(parts[2]);
                }
            }
        }
        boolean outcome = check(mixedInformation);
        if (outcome){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
    public static boolean check(int[][][] mixedInformation){
        for (int[][] ints : mixedInformation) {
            for (int j = 0; j < ints.length; j++) {
                Arrays.sort(ints[j]);
            }
        }
        for (int i = 0; i < mixedInformation.length; i++) {
            for (int j = 0; j < mixedInformation[i].length; j++) {
                for (int k = 0; k < mixedInformation[i][j].length/2; k++) {
                    int temp = mixedInformation[i][j][k];
                    mixedInformation[i][j][k] = mixedInformation[i][j][mixedInformation.length - 1 - i];
                    mixedInformation[i][j][mixedInformation.length - 1 - i] = temp;
                }
            }
        }

        boolean outcome = true;
        outLoop:
        for (int i = 0; i < mixedInformation[0].length; i++) {
            for (int j = 0; j < mixedInformation[0][i].length; j++) {
                if (mixedInformation[0][i][j] > mixedInformation[1][i][j]){
                    outcome = false;
                    break outLoop;
                }
            }
        }
        return outcome;
    }

}
