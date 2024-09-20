import java.util.Scanner;
public class Demo07Vacation {


    public class DaysUntilSummerVacation {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Get the current date from the user
            System.out.println("Enter the current year on Kata Star:");
            int currentYear = scanner.nextInt();

            System.out.println("Enter the current month (1-15) on Kata Star:");
            int currentMonth = scanner.nextInt();

            System.out.println("Enter the current day of the month on Kata Star:");
            int currentDay = scanner.nextInt();

            // Assuming summer vacation starts on the first day of Month 6
            int summerStartMonth = 6;
            int summerStartDay = 1;

            // Calculate the days until summer vacation
            int daysUntilSummerVacation = calculateDaysUntilVacation(currentYear, currentMonth, currentDay, summerStartMonth, summerStartDay);

            // Output the result
            System.out.println("Days until summer vacation: " + daysUntilSummerVacation);

            scanner.close();
        }

        private static boolean isLeapYear(int year) {
            return year % 13 == 0;
        }

        private static int daysInMonth(int month, int year) {
            if (month == 5) {
                return 62; // Month 5 has 62 days
            } else if (month == 3 && isLeapYear(year)) {
                return 62; // Month 3 in leap year also has 62 days
            } else {
                return 61; // Other months have 61 days
            }
        }

        private static int calculateDaysUntilVacation(int year, int currentMonth, int currentDay, int startMonth, int startDay) {
            int daysUntilVacation = 0;

            // Add the days remaining in the current month
            daysUntilVacation += daysInMonth(currentMonth, year) - currentDay;

            // Add the days in the full months until the start of the vacation
            for (int month = currentMonth + 1; month < startMonth; month++) {
                daysUntilVacation += daysInMonth(month, year);
            }

            // Finally, add the days from the vacation start month
            daysUntilVacation += startDay - 1;

            return daysUntilVacation;
        }
    }
}
