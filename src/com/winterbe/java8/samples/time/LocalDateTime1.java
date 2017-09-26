package com.winterbe.java8.samples.time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;

import static java.time.Instant.now;

/**
 * @author Benjamin Winterberg
 */
public class LocalDateTime1 {

    public static void main(String[] args) throws InterruptedException {

        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);      // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439

        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = parsed.format(formatter);
        System.out.println(string);     // Nov 03, 2014 - 07:13

        /**
         * @desc Instant使用
         *****************************************
         * Using Instant                         *
         *****************************************
         */
        Instant start = now();
        System.out.println(start);

        Thread.sleep(1000);

        Instant end = now();
        System.out.println(end);

        Duration elapsed = Duration.between(start, end);
        System.out.println("Elapsed: "+ elapsed +" milliseconds");
        // to legacy date

        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014

        /**
         * @desc DateTimeFormatter使用
         *****************************************
         * Using DateTimeFormatter               *
         *****************************************
         */
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        System.out.println(df.format(currentDate));

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter dt = DateTimeFormatter.ISO_TIME;
        System.out.println(dt.format(currentTime));

        LocalDateTime currentDT = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(dtf.format(currentDT));

        DateTimeFormatter f_long = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(f_long.format(currentDT));

        DateTimeFormatter f_short = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(f_short.format(currentDT));

        String fr_short = f_short.withLocale(Locale.FRENCH).format(currentDT);
        String fr_long = f_long.withLocale(Locale.FRENCH).format(currentDT);

        System.out.println(fr_short);
        System.out.println(fr_long);

        DateTimeFormatterBuilder b = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.DAY_OF_YEAR)
                .appendLiteral("||")
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral("||")
                .appendValue(ChronoField.YEAR);

        DateTimeFormatter f = b.toFormatter();
        System.out.println(f.format(currentDT));

    }

}