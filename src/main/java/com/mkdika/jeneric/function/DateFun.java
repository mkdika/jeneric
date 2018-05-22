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
    
    /**
     * To return the last date of the month by the given date.
     * <p>
     * Example:<br>
     * <ul>
     * <li>Input: <b>10 Apr 2018</b>, will return <b>30 Apr 2018</b></li>
     * <li>Input: <b>5 Feb 2020</b>, will return <b>29 Feb 2020</b></li>
     * </ul>
     * <br>
     * <i>Please note this calculation is using system default Time-Zone.</i><br>
     * See {@link java.time.ZoneId#systemDefault()}
     * 
     * @param date input date to check
     * @return {@link java.util.Date}
     * @see java.time.LocalDate
     */
    public static Date lastDay(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate lastDay = localDate.withDayOfMonth(localDate.lengthOfMonth());
        return Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * To return the {@link java.util.Date} Object by given the <b>year, month, dateOfMonth</b> as arguments.
     * <p>
     * <i>Please note this calculation is using system default Time-Zone.</i><br>
     * See {@link java.time.ZoneId#systemDefault()}
     * 
     * @param year input year
     * @param month input month
     * @param dateOfMonth input date (of month and year)
     * @return {@link java.util.Date}
     * @see com.mkdika.jeneric.function.DateFun#of(int, int, int, int, int, int)
     */
    public static Date of(int year, int month, int dateOfMonth) {
        return of(year, month, dateOfMonth, 0, 0, 0);
    }

    /**
     * To return the timestamp of {@link java.util.Date} Object by given the 
     * <b>year, month, dateOfMonth, hour, minute, second</b> as arguments.
     * <p>
     * <i>Please note this calculation is using system default Time-Zone.</i><br>
     * See {@link java.time.ZoneId#systemDefault()}
     * 
     * @param year input year
     * @param month input month
     * @param dateOfMonth input date (of month and year)
     * @param hour input hours
     * @param minute input minutes
     * @param second input seconds
     * @return {@link java.util.Date}
     * @see java.time.LocalDateTime
     */
    public static Date of(int year, int month, int dateOfMonth, int hour, int minute, int second) {
        LocalDateTime ldt = LocalDateTime.of(year, month, dateOfMonth, hour, minute, second);
        long epoch = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new Date(epoch);
    }

    /**
     * To return the current time of {@link java.util.Date} Object.
     * 
     * @return {@link java.util.Date}
     */
    public static Date now() {     
        return new Date();
    }

    /**
     * To return truncated date (remove time element) of given date object.
     * <p>
     * Example:<br>
     * <ul>
     * <li>Input: <b>5 Apr 2018 13:55:45</b>, will return <b>5 Apr 2018 00:00:00</b></li>
     * </ul><br><br>
     * <i>Please note this calculation is using system default Time-Zone.</i><br>
     * See {@link java.time.ZoneId#systemDefault()}
     *
     * @param date input date to be trunc
     * @return {@link java.util.Date}
     */
    public static Date trunc(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime truncDate = LocalDateTime.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), 0, 0, 0, 0);
        return Date.from(truncDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * To return truncate date (remove seconds element only) of given date object.
     * <p>
     * Hour and Minutes element are still remains.<br><br>
     * Example:<br>
     * <ul>
     * <li>Input: <b>5 Apr 2018 13:55:45</b>, will return <b>5 Apr 2018 13:55:00</b></li>
     * </ul><br><br>
     * <i>Please note this calculation is using system default Time-Zone.</i><br>
     * See {@link java.time.ZoneId#systemDefault()}
     * 
     * @param date given date to return date by removing nano-second time part
     * @return {@link java.util.Date}
     */
    public static Date truncSec(Date date) {
        LocalDateTime localDateTime = new java.sql.Timestamp(date.getTime()).toLocalDateTime();
        LocalDateTime truncSecDate = LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(),
                localDateTime.getHour(), localDateTime.getMinute(), 0, 0);
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
