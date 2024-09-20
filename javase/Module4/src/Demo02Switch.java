import java.util.Scanner;

public class Demo02Switch {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int month = sc.nextInt();
        switch(month){
            case 1:
            case 2:
            case 3:
                System.out.println("Spring");
        }

    }
}
