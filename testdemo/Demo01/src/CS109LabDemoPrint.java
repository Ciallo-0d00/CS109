import java.util.Random;

public class CS109LabDemoPrint {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Random rd = new Random();
        double a = rd.nextDouble();
        System.out.println(a);
        int b = rd.nextInt(4);
        System.out.println(b);

        switch (b) {
            case 1:
                System.out.println("pig");
                break;
            case 2:
                System.out.println("mouse");
                break;
            case 3:
                System.out.println("cat");
                break;
            default:
                System.out.println("rabbit");
                break;
        }

    }
}
