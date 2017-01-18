package com.ryan.java8.datetime;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * LocalDate、LocalTime、Instant、Duration、Period
 *
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2017/1/18 11:58.
 */
public class NewDateTime {

    /**
     *
     */
    public void localDate() {
        LocalDate localDate = LocalDate.of(2017, 03, 18);

        int dayOfYear = localDate.getDayOfYear();
        System.out.println("dayOfYear: " + dayOfYear);
        System.out.println("dayOfMonth : " + localDate.getDayOfMonth());
        System.out.println("dayOfWeek" + localDate.getDayOfWeek());
        System.out.println("month" + localDate.getMonthValue());

        LocalDate now = LocalDate.now();
        int year = now.get(ChronoField.YEAR);

        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();

        LocalDate parse = LocalDate.parse("13:28:00");
        LocalTime of = LocalTime.of(13, 45, 30);

    }

    /**
     * 日期时间
     */
    public void localDateTime() {
        /**
         * 合并日期
         */
        LocalDateTime dateTime = LocalDateTime.of(2017, Month.DECEMBER, 18, 13, 45, 20);
        LocalDateTime now = LocalDateTime.now();

    }

    /**
     * 机器的日期和时间格式
     */
    public void instant() {
        Instant instant = Instant.ofEpochSecond(System.currentTimeMillis());

        Instant now = Instant.now();
    }

    /**
     *
     */
    public void durationAndPeriod(){
        Duration between = Duration.between(Instant.now(), Instant.now());

        Period period = Period.between(LocalDate.of(2017, 01, 18), LocalDate.now());

        Duration duration = Duration.ofMinutes(3);

        Duration of = Duration.of(3, ChronoUnit.MINUTES);
    }

}
