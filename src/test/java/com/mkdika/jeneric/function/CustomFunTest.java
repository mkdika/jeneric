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

import com.mkdika.jeneric.model.TimePeriod;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class CustomFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_CustomFun_class_instance");

        try {
            Constructor<CustomFun> c = CustomFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            CustomFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_calculatePeriod_success() {
        System.out.println("test_CustomFun_calculatePeriod_success");

        Date dA1 = DateFun.of(2018, 5, 10, 3, 10, 0);
        Date dA2 = DateFun.of(2018, 7, 10, 5, 12, 50);
        TimePeriod tA = CustomFun.calculatePeriod(dA1, dA2);
        assertNotNull(tA);
        assertThat(tA.getDays(), equalTo(61L));
        assertThat(tA.getHours(), equalTo(2L));
        assertThat(tA.getMinutes(), equalTo(2L));
        assertThat(tA.getSeconds(), equalTo(50L));
        assertThat(tA.getMilliseconds(), equalTo(0L));

        TimePeriod tB = CustomFun.calculatePeriod(1525896600000L, 1525924550000L);
        assertNotNull(tB);
        assertThat(tB.getDays(), equalTo(0L));
        assertThat(tB.getHours(), equalTo(7L));
        assertThat(tB.getMinutes(), equalTo(45L));
        assertThat(tB.getSeconds(), equalTo(50L));
        assertThat(tB.getMilliseconds(), equalTo(0L));
    }

    @Test(expected = NullPointerException.class)
    public void test_calculatePeriod_exception1() {
        System.out.println("test_CustomFun_calculatePeriod_exception1");

        TimePeriod tA = CustomFun.calculatePeriod(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_calculatePeriod_exception2() {
        System.out.println("test_CustomFun_calculatePeriod_exception2");

        Date dA1 = DateFun.of(2018, 5, 10, 3, 10, 0);
        Date dA2 = DateFun.of(2018, 7, 10, 5, 12, 50);
        TimePeriod tA = CustomFun.calculatePeriod(dA2, dA1);
    }

}
