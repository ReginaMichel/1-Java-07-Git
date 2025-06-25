import java.util.Calendar;
import java.util.Scanner;

public class Main {
    private static final String[] daysOfWeek = {"So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"};
    private static final String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    private static Integer[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        System.out.println("07-Git - Bonus: Deluxe-Kalender");
        printCalendar();
    }

    public static void printCalendar(){
        Scanner userEntries = new Scanner(System.in);
        System.out.print("Bitte geben Sie das gewünschte Jahr als vierstellige Zahl ein:");
        String entry = userEntries.nextLine();
        int year = Integer.parseInt(entry);
        System.out.println(year);

        // get day of week of January 1st
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, Calendar.JANUARY,1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        int dayCounter = dayOfWeek;
        for (int i = 0; i < 12; i++){
            printMonth(i);
        }
    }

    public static void printWeekDays() {
        for (int i = 0; i < 7; i++) {
            System.out.print(daysOfWeek[i] + " ");
        }
        System.out.println();
    }

    public static void printMonth(int month) {
        System.out.println(months[month]);
        printWeekDays();
        System.out.println();

    }
}
