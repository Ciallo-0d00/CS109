import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int yeari = sc.nextInt();
            int monthi = sc.nextInt();
            int dayi = sc.nextInt();
            int yearf = sc.nextInt();
            int monthf = sc.nextInt();
            int dayf = sc.nextInt();
            int last = caculateLast(yeari,yearf,monthi,monthf,dayi,dayf);
            System.out.println(last);
        }
        sc.close();
    }
    public static int daysPerMonth(int month,int year){
        if (month==5){
            return 62;
        } else if (month==3 && year%13==0) {
            return 62;
        }else {
            return 61;
        }
    }
    public static int daysPerYear(int year){
        if (year%13==0) {
            return 917;
        }else {
            return 916;
        }
    }

    public static int yearDay(int yeari,int yearf){
        int subyear = (yearf-1)/13-yeari/13;
        int dayPast = subyear*917+(yearf-yeari-subyear-1)*916;
        return dayPast;
    }

    public static int monthDay(int month,int year){
        int dayPast = 0;
        if (month != 1){
            for (int i = 1; i < month; i++) {
                dayPast += daysPerMonth(i,year);
            }
        }
        return dayPast;
    }

    public static int caculateLast(int initialYear,int finalYear,int initialMonth,int finalMonth,int initialDay,int finalDay){
        if (finalYear-initialYear>0){
            int startDay = daysPerYear(initialYear)-monthDay(initialMonth,initialYear)-initialDay;
            int stopDay = monthDay(finalMonth,finalYear)+finalDay;
            return stopDay + startDay +yearDay(initialYear,finalYear);
        }else{
            int startDay = monthDay(initialMonth,initialYear)+initialDay;
            int stopDay = monthDay(finalMonth,finalYear)+finalDay;
            return stopDay - startDay;
        }
    }
}