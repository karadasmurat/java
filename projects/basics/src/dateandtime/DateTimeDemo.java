package dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import util.Util;

public class DateTimeDemo {

    void basics() {

        // LocalDate d = new LocalDate(); // DOES NOT COMPILE The constructor
        // LocalDate() is undefined

        System.out.println(LocalDate.now()); // 2025-01-28
        System.out.println(LocalTime.now()); // 19:19:27.949728
        System.out.println(LocalDateTime.now()); // 2025-01-28T19:19:27.949774

        LocalDate date2 = LocalDate.of(2015, Month.JANUARY, 20);

        LocalDate date3 = LocalDate.of(2015, Month.JANUARY, 32); // throws DateTimeException
    }

    void manipulate() {

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);

        System.out.println(date); // 2014-01-20

        LocalDate nextDay = date.plusDays(1);
        System.out.println(nextDay); // 2014-01-21

        LocalDate dayBefore = nextDay.minusDays(1);
        System.out.println(dayBefore); // 2014-01-20

        date = date.plusWeeks(1);
        System.out.println(date); // 2014-01-27

        date = date.plusMonths(1);
        System.out.println(date); // 2014-02-27

        date = date.plusYears(5); // 2019-02-27
        System.out.println(date);

        // chaining
        System.out.println(LocalTime.now().plusHours(1).plusMinutes(30));

        // Neglecting the result
        // Create an immutable LocalDate object representing December 31, 1999.
        LocalDate date01 = LocalDate.of(1999, Month.DECEMBER, 31);

        // The method plusDays(1) does not modify the date01 object.
        // Instead, it returns a new LocalDate object representing January 1, 2000.
        date01.plusDays(1);

        // prints the original LocalDate instance (1999-12-31) because
        // the plusDays(1) call had no effect on the date01 reference.
        System.out.println(date01); // 1999-12-31
    }

    void periods() {
        // There are five ways to create a Period class:
        Period annually = Period.ofYears(1); // every 1 year
        Period quarterly = Period.ofMonths(3); // every 3 monthsWorking with Dates and Times 147
        Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
        Period everyOtherDay = Period.ofDays(2); // every 2 days
        Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

        System.out.println(quarterly); // P3M
        System.out.println(everyYearAndAWeek); // P1Y7D

        LocalDate date02 = LocalDate.of(1999, 12, 31);
        LocalTime time02 = LocalTime.of(13, 00);
        LocalDateTime dateTime02 = LocalDateTime.of(date02, time02);
        Period period = Period.ofMonths(1);

        System.out.println(date02.plus(period)); // 2000-01-31
        System.out.println(dateTime02.plus(period)); // 2000-01-31T13:00
        System.out.println(time02.plus(period)); // UnsupportedTemporalTypeException: Unsupported unit: Months
    }

    void formatting() {

        LocalDate date = LocalDate.of(2025, Month.JUNE, 28);
        LocalTime time = LocalTime.of(14, 1, 34);
        LocalDateTime datetime = LocalDateTime.of(date, time);

        System.out.println(date.getDayOfWeek()); // SATURDAY
        System.out.println(date.getDayOfMonth()); // 28
        System.out.println(date.getDayOfYear()); // 179
        System.out.println(date.getMonth()); // JUNE
        System.out.println(date.getYear()); // 2025

        // Predefined Formatters
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2025-06-28
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME)); // 14:01:34
        System.out.println(datetime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2025-06-28T14:01:34

        DateTimeFormatter dfmt = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println(date.format(dfmt)); // June 28, 2025

    }

    void parsing() {
        String dateSTR = "01 02 2015";
        String timeSTR = "11:22";

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM dd yyyy");

        LocalDate date = LocalDate.parse(dateSTR, fmt);
        LocalTime time = LocalTime.parse(timeSTR);

        System.out.println(date.getYear()); // 2015
        System.out.println(time); // 11:22
    }

    public static void main(String[] args) {
        Util.header("DateTimeDemo");
        DateTimeDemo dt = new DateTimeDemo();
        // dt.basics();
        // dt.manipulate();
        // dt.periods();
        // dt.formatting();
        dt.parsing();

    }
}
