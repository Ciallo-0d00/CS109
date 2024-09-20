import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        double[] problems = new double[count];
        for (int i = 0; i < count; i++) {
            problems[i] = sc.nextDouble();
        }
        int[] judgeQi = new int[count];
        int[] judgeCompetitor = new int[count];
        for (int i = 0; i < count; i++) {
            judgeQi[i] = sc.nextInt();
        }
        for (int i = 0; i < count; i++) {
            judgeCompetitor[i] = sc.nextInt();
        }
        double scoreQi = 0;
        double scoreCompetitor = 0;
        for (int i = 0; i < count; i++) {
            if (judgeQi[i] == 2){
                scoreQi+=problems[i];
            } else if (judgeQi[i] == 1) {
                scoreQi-=problems[i];
            }else{
                scoreQi-=problems[i]/2;
            }
        }
        for (int i = 0; i < count; i++) {
            if (judgeCompetitor[i] == 2){
                scoreCompetitor+=problems[i];
            } else if (judgeCompetitor[i] == 1) {
                scoreCompetitor-=problems[i];
            }else{
                scoreCompetitor-=problems[i]/2;
            }
        }

//        System.out.println(scoreCompetitor);
//        System.out.println(scoreQi);

        if (scoreQi>scoreCompetitor){
            System.out.println("Qi won");
        }else if (scoreQi<scoreCompetitor){
            System.out.println("Qi lost");
        }else{
            System.out.println("Qi need another round");
        }
    }
}
