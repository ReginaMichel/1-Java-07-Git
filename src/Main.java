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
        System.out.println();
        System.out.println("        " + year);

        // get day of week of January 1st
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, Calendar.JANUARY,1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        int dayCounter = dayOfWeek;
        for (int i = 0; i < 12; i++){
            dayCounter = printMonth(i, dayCounter);
            System.out.println();
        }
    }

    public static void printWeekDays() {
        for (int i = 0; i < 7; i++) {
            System.out.print(daysOfWeek[i] + " ");
        }
    }

    public static int printMonth(int month, int dayCounter) {
        String monthName = months[month];
        for (int i=(20-monthName.length())/2; i > 0; i--) {
            System.out.print(" ");
        }

        System.out.println(months[month]);
        printWeekDays();
        System.out.println();

        String emptyDay = "   ";
        for (int i = 0; i < (dayCounter-1)%7; i++) {
            System.out.print(emptyDay);
        }
        for (int dayInMonth = 1; dayInMonth <= daysPerMonth[month]; dayInMonth++) {
            if (dayInMonth < 10) {System.out.print(" ");}
            System.out.print(dayInMonth + " ");
            if (dayCounter % 7 == 0) {
                System.out.println();
            }
            dayCounter++;

        }

        System.out.println();
        return dayCounter;
    }
}
