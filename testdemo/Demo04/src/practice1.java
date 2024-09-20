//import java.util.Scanner;
//
//public class practice1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int sNum = sc.nextInt();
//        int cNum = sc.nextInt();
//        int[][] arr = new int[sNum][cNum];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        System.out.printf("%10s%10s%10s%10s","Course1","Course2","Course3","Course4");
//        System.out.println();
//        System.out.printf("%s%10d%10d%10d%10d","Student1",arr[0][0],arr[0][1],arr[0][2],(arr[0][0]+arr[0][1]+arr[0][2])/3);
//
//
//
//    }
import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int sNum = sc.nextInt();
        System.out.print("Enter the number of courses: ");
        int cNum = sc.nextInt();

        double[][] scores = new double[sNum][cNum];
        double[] studentAverages = new double[sNum];
        double[] courseAverages = new double[cNum];


        for (int i = 0; i < sNum; i++) {
            for (int j = 0; j < cNum; j++) {
                scores[i][j] = sc.nextDouble();
                studentAverages[i] += scores[i][j];
            }
        }

        for (int i = 0; i < sNum; i++) {
            for (int j = 0; j < cNum; j++) {
                courseAverages[j] += scores[i][j];
            }
            courseAverages[i] /= sNum;
        }

        for (int i = 0; i < sNum; i++) {
            studentAverages[i] /= cNum;
        }


        for (int j = 0; j < sNum; j++) {
            System.out.printf("%22s", "Course " + (j + 1));
        }
        System.out.printf("%15s\n", "Average");

        for (int i = 0; i < sNum; i++) {
            System.out.printf("%15s", "Student " + (i + 1));
            for (int j = 0; j < cNum; j++) {
                System.out.printf("%15.1f", scores[i][j]);
            }
            System.out.printf("%15.2f\n", studentAverages[i]);
        }

        System.out.printf("%15s", "Average");
        for (int j = 0; j < sNum; j++) {
            System.out.printf("%15.2f", courseAverages[j]);
        }

    }
}

