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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
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

    @Test
    public void test_now_success() {
        System.out.println("test_DateFun_now_success");

        Date date = DateFun.now();
        assertThat(date, notNullValue());
    }

    @Test
    public void test_trunc_success() {
        System.out.println("test_DateFun_trunc_success");
        LocalDateTime localDate = LocalDateTime.of(2018, Month.MAY, 1, 12, 10, 30, 22);
        Date truncDate = DateFun.trunc(Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant()));

        LocalDateTime localDateCompare = LocalDateTime.of(2018, Month.MAY, 1, 0, 0, 0, 0);
        Date truncDateCompare = Date.from(localDateCompare.atZone(ZoneId.systemDefault()).toInstant());

        assertThat(truncDate, equalTo(truncDateCompare));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void test_trunc_exception() {
        System.out.println("test_DateFun_trunc_exception");
        Date truncDate = DateFun.trunc(null);

        LocalDateTime localDateCompare = LocalDateTime.of(2018, Month.MAY, 1, 0, 0, 0, 0);
        Date truncDateCompare = Date.from(localDateCompare.atZone(ZoneId.systemDefault()).toInstant());

        assertThat(truncDate, not(equalTo(truncDateCompare)));
    }

    @Test
    public void test_truncSec_success() {
        System.out.println("test_DateFun_truncSec_success");
        LocalDateTime localDateTime = LocalDateTime.of(2018, Month.MAY, 1, 12, 10, 30, 22);
        Date truncSecDate = DateFun.truncSec(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));

        LocalDateTime localDateTimeCompare = LocalDateTime.of(2018, Month.MAY, 1, 12, 10, 30, 0);
        Date truncSecDateCompare = Date.from(localDateTimeCompare.atZone(ZoneId.systemDefault()).toInstant());

        assertThat(truncSecDate, equalTo(truncSecDateCompare));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void test_truncSec_exception() {
        System.out.println("test_DateFun_truncSec_exception");
        Date truncSecDate = DateFun.truncSec(null);

        LocalDateTime localDateTimeCompare = LocalDateTime.of(2018, Month.MAY, 1, 12, 10, 30, 0);
        Date truncSecDateCompare = Date.from(localDateTimeCompare.atZone(ZoneId.systemDefault()).toInstant());

        assertThat(truncSecDate, not(equalTo(truncSecDateCompare)));
    }
    
    @Test
    public void test_nvl_success() {
        System.out.println("test_DateFun_nvl_success");
        Date a = DateFun.nvl(null);
        assertNotNull(a);

        Date b = DateFun.nvl(DateFun.of(2018, 4, 30));
        assertThat(b, equalTo(DateFun.of(2018, 4, 30)));
    }
}
