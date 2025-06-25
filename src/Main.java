import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static String[] daysOfWeek = {"So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"};
    public static String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    public static void main(String[] args) {
        //System.out.println("07-Git - Aufgabe 2: Bonus: Eine Aufgabe wiederholen");
        //System.out.println(add(1,1));

        System.out.println("07-Git - Bonus: Deluxe-Kalender");
        calendar();
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void calendar() {
        Scanner userEntries = new Scanner(System.in);
        System.out.print("Bitte geben Sie das gewünschte Jahr als vierstellige Zahl ein:");
        String entry = userEntries.nextLine();
        int year = Integer.parseInt(entry);
        System.out.println(year);

        // get day of week of January 1st
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, Calendar.JANUARY,1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);


        printWeekDays();
    }

    public static void printWeekDays() {
        for (int i = 0; i < 7; i++) {
            System.out.print(daysOfWeek[i] + " ");
        }
    }
}
