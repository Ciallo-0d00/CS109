import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budget = sc.nextInt();
        System.out.println("Your budget:"+ budget);
        if (budget<5588){
            System.out.println("You do not have sufficient money");
        }else{
            for(PhoneModel phoneModel : PhoneModel.values()){
                if (phoneModel.getPrice() <= budget){
                    System.out.printf("%-10s%s%d",phoneModel,"price:",phoneModel.getPrice());
                    System.out.println();
                }
            }
        }
    }
}
