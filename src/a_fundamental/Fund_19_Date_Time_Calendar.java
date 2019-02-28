package a_fundamental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

public class Fund_19_Date_Time_Calendar {

    public static void main(String[] args) {

        date_examples(); // Date senas datos formatas - nenaudoti
        localDate_examples(); // LocalDate
        localDateTime_examples(); // LocalDateTime
    }

    public static void date_examples() {

        // Date tai senas datos formatas - niekada nenaudoti

//        Date date = new Date("01/02/2017 GMT");
//        System.out.println(date);

//        date = new Date();
//        System.out.println(date);

//        System.out.println(date.before(new Date()) ? "praeityje" : "ateityje");

//        System.out.println(date.equals(new Date(1483315200000L)) ? "lygu" : "nelygu");
    }

    public static void localDate_examples() {

        LocalDate date; // dažniausiai naudojamas

        date = LocalDate.now();// dabartinis laikas
        System.out.println(date);

        date = LocalDate.parse("2017-12-01"); // priskiriama nauja reikšmė
        System.out.println(date); // 2017-12-01

        date = date.plusDays(30);
        System.out.println(date); // 2017-12-31
        date = date.plusDays(-30);

        System.out.println("Year = " + date.getYear()); // Year = 2017
        System.out.println("Month = " + date.getMonth()); // Month = DECEMBER
        System.out.println("MonthValue = " + date.getMonthValue()); // MonthValue = 12
        System.out.println("DayOfMonth = " + date.getDayOfMonth()); // DayOfMonth = 1
        System.out.println("DayOfWeek = " + date.getDayOfWeek()); // DayOfWeek = FRIDAY
        System.out.println("DayOfWeek value = " + date.getDayOfWeek().getValue()); // DayOfWeek value = 5

        // savaitė metuose
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
        System.out.println("weekNumber = " + weekNumber); // weekNumber = 48

    }

    public static void localDateTime_examples() {

        LocalDateTime date; // grubus įrašas, reikia formatuoti

        date = LocalDateTime.now(); // dabartinė data ir laikas
        System.out.println(date);

        date = LocalDateTime.parse("2019-02-17T23:59:59.999"); // priskiriama nauja reikšmė
        System.out.println(date);

        date = date.plusDays(10); // +10 dienų
        System.out.println(date);

        date = date.plusYears(1); // +1 metai
        System.out.println(date);

        date = date.plusSeconds(3600); // + 3600 sekundžių (3600 sec = 1 val)
        System.out.println(date);


        System.out.println("----------------------- formatavimas:");

        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);

        LocalDate date2 = LocalDate.parse("24.12.2014", formatter);
        System.out.println(date2);

//        formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
//        xmas = LocalDate.parse("Dec 24 2014", formatter); // todo kažkodėl neveikia
//        System.out.println(xmas);

        formatter = DateTimeFormatter.ofPattern("yy MMMM d").withLocale(Locale.US);
        System.out.println(date2.format(formatter));

        formatter = DateTimeFormatter.ofPattern("yyyy MMMM d").withLocale(Locale.FRANCE);
        System.out.println(date2.format(formatter));

        formatter = DateTimeFormatter.ofPattern("yyyy MM d").withLocale(Locale.UK);
        System.out.println(date2.format(formatter));


    }
}
