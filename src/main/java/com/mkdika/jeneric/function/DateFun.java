/*
 * Copyright 2018 Maikel Chandika (mkdika@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mkdika.jeneric.function;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * This class is collection of all Date return functions.
 *
 * All static method may return {@link java.util.Date} or
 * Array/Collection of {@link java.util.Date}.
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 * @since 2018-04-28
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
     * @return {@link java.util.Date}
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
        return new Date();
    }

    /**
     * Function to return truncate date from the given date
     *
     * @param date given date to return date by removing time part
     * @return {@link java.util.Date}
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
     * @return {@link java.util.Date}
     */
    public static Date truncSec(Date date) {
        LocalDateTime localDateTime = new java.sql.Timestamp(date.getTime()).toLocalDateTime();
        LocalDateTime truncSecDate = LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(),
                localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), 0);
        return Date.from(truncSecDate.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * Null Value Logic (NVL) or Denullify.
     * <p>
     * If argument is <b>null</b>, it will return <b>new Date()</b>.
     *
     * @param date input argument to check.
     * @return {@link java.util.Date}
     */
    public static Date nvl(Date date) {
        return (date == null? new Date() : date);
    }
}
