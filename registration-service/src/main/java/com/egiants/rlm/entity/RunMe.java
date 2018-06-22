package com.egiants.rlm.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;

public class RunMe {
    public static void main(String[] args){
        LocalDate xyz = LocalDate.now();
        System.out.println("year"+ xyz.getYear());
        System.out.println("month"+ xyz.getMonth());
        System.out.println("dateFormant"+ xyz.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("dayOfAYear"+ xyz.getDayOfYear());
        System.out.println("dayOfAMonth"+ xyz.getDayOfMonth());
        System.out.println("dayOfAWeek"+ xyz.getDayOfWeek());
        System.out.println("IsLeapYear"+ xyz.isLeapYear());
        System.out.println("ChronoFieldYear"+ xyz.get(ChronoField.YEAR));
        //System.out.println("era"+ xyz.get(T));
        System.out.print("instant"+Instant.now());

    }
}
