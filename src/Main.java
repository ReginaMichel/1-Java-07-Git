import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String[] DAYS_OF_WEEK = {"So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"};
    private static final String[] MONTHS = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    private static Integer[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        System.out.println("07-Git - Bonus: Deluxe-Kalender");
        printCalendar();
    }

    public static int getYearFromUser() {
        Scanner scanner = new Scanner(System.in);
        int year = -1;

        while (true) {
            System.out.print("Bitte geben Sie das gewünschte Jahr als vierstellige Zahl ein: ");
            try {
                year = scanner.nextInt();
                if (year >= 1000 && year <= 9999) {
                    break;
                } else {
                    System.out.println("Bitte eine gültige vierstellige Jahreszahl eingeben!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe! Bitte geben Sie eine vierstellige Zahl ein.");
                // skipping the invalid input
                scanner.next();
            }
        }
        return year;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void printCalendar(){
        int year = getYearFromUser();
        System.out.println();
        System.out.println("        " + year);

        // leap year control
        if (isLeapYear(year)) {
            daysPerMonth[1] = 29;
        } else {
            daysPerMonth[1] = 28;
        }

        // get day of week of January 1st
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, Calendar.JANUARY,1);

        int dayCounter = calendar.get(Calendar.DAY_OF_WEEK);
        for (int i = 0; i < 12; i++){
            dayCounter = printMonth(i, dayCounter);
            System.out.println();
        }
    }

    public static void printWeekDays() {
        for (int i = 0; i < 7; i++) {
            System.out.print(DAYS_OF_WEEK[i] + " ");
        }
    }

    public static int printMonth(int month, int dayCounter) {
        String monthName = MONTHS[month];
        for (int i=(20-monthName.length())/2; i > 0; i--) {
            System.out.print(" ");
        }

        System.out.println(MONTHS[month]);
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
