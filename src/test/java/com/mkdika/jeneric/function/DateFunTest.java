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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class DateFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_DateFun_class_instance");

        try {
            Constructor<DateFun> c = DateFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            DateFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_lastDay_success() {
        System.out.println("test_DateFun_lastDay_success");
        LocalDate localDate = LocalDate.of(2018, Month.MAY, 1);
        Date date = DateFun.lastDay(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        LocalDate localDateCompare = LocalDate.of(2018, Month.MAY, 31);
        Date dateCompare = Date.from(localDateCompare.atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertThat(date, equalTo(dateCompare));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void test_lastDay_exception() {
        System.out.println("test_DateFun_lastDay_exception");

        Date date = DateFun.lastDay(null);
        LocalDate localDateCompare = LocalDate.of(2018, Month.MAY, 31);
        Date dateCompare = Date.from(localDateCompare.atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertThat(date, not(equalTo((dateCompare))));
    }

}
