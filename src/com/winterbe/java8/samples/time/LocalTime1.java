package com.winterbe.java8.samples.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;

import static java.time.Instant.now;

/**
 * @author Benjamin Winterberg
 */
public class LocalTime1 {

    public static void main(String[] args) throws InterruptedException {

        // get the current time
        Clock clock = Clock.systemDefaultZone();
        long t0 = clock.millis();
        System.out.println(t0);

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);


        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        //TimeZones
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT+0"));
        System.out.println(dtf.format(gmt));

        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(dtf.format(ny));

        Set<String> zones = ZoneId.getAvailableZoneIds();
        Predicate<String> condition = str -> str.contains("London");
        zones.forEach(z -> {
            if(condition.test(z))
                System.out.println(z);
        });

        // time
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1);
        System.out.println(now2);

        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween);
        System.out.println(minutesBetween);


        // create time

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);

        DateTimeFormatter germanFormatter =DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);

        // to legacy date


    }

}