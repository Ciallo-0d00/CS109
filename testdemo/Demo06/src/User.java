import java.util.Scanner;

public class User {
    String name;
    String account;
    String password;
    double money;
    public User(String name){
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void expense(double value, Scanner in){
        System.out.println("Please input your password:");
        String newPassword = in.nextLine();
        if (newPassword.equals(password)){
            if ((money - value) > 0){
                money -= value;
                System.out.println("Plan to expense " + value + " dollar");
            }else {
                System.out.println("Plan to expense " + value + " dollar" + " but no sufficient funds");
            }
        }
    }
    public void income(double value){
        money += value;
        System.out.println("Got " + value + " as income, balance is " + money + " dollar");

    }
    public void introduce(){
        System.out.println(name + "'s account has a balance of " + money + " dollar");
    }
}
