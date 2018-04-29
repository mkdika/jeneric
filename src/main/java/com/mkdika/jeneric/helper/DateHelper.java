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
package com.mkdika.jeneric.helper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public final class DateHelper {

    public static Date of(int year, int month, int dayOfMonth) {
        return of(year, month, dayOfMonth, 0, 0, 0);
    }

    public static Date of(int year, int month, int dayOfMonth, int hour, int minute, int second) {
        LocalDateTime ldt = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
        long epoch = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new Date(epoch);
    }

    public static Date now() {
        LocalDateTime ldt = LocalDateTime.now();
        long epoch = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new Date(epoch);
    }
}
