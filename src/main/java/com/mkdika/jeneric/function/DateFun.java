/*
 * The MIT License
 *
 * Copyright 2018 Maikel Chandika <mkdika@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mkdika.jeneric.function;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
public final class DateFun {

    /*
        To prevent class from instanate from outside.
     */
    private DateFun() {
    }

    //TODO: review Reja's contribute functions Javadoc
    /**
     * Function to return last day from the given date
     *
     * @param date given date to return last day from that month
     * @return java.util.Date
     */
    public static Date lastDay(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate lastDay = localDate.withDayOfMonth(localDate.lengthOfMonth());
        return Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    //TODO: finihsh DateFun.of javadoc
    public static Date of(int year, int month, int dayOfMonth) {
        return of(year, month, dayOfMonth, 0, 0, 0);
    }

    //TODO: finihsh DateFun.of javadoc
    public static Date of(int year, int month, int dayOfMonth, int hour, int minute, int second) {
        LocalDateTime ldt = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
        long epoch = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new Date(epoch);
    }

    //TODO: finihsh DateFun.now javadoc
    public static Date now() {
        LocalDateTime ldt = LocalDateTime.now();
        long epoch = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new Date(epoch);
    }

    /**
     * Function to return truncate date from the given date
     *
     * @param date given date to return date by removing time part
     * @return java.util.Date
     */
    public static Date trunc(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime truncDate = LocalDateTime.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), 0, 0, 0, 0);
        return Date.from(truncDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Function to return truncate date from the given date
     * 
     * @param date given date to return date by removing nano-second time part
     * @return 
     */
    public static Date truncSec(Date date) {
        LocalDateTime localDateTime = new java.sql.Timestamp(date.getTime()).toLocalDateTime();
        LocalDateTime truncSecDate = LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(),
                localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), 0);
        return Date.from(truncSecDate.atZone(ZoneId.systemDefault()).toInstant());
    }
}
