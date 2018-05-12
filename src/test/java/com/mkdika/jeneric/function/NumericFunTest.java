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
import java.math.BigDecimal;
import java.math.RoundingMode;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class NumericFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_NumericFun_class_instance");

        try {
            Constructor<NumericFun> c = NumericFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            NumericFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_nvl_bigDecimal_success() {
        System.out.println("test_NumericFun_bigDecimal_nvl_success");

        BigDecimal a = NumericFun.nvl(null);
        assertThat(a, equalTo(BigDecimal.ZERO));

        BigDecimal b = NumericFun.nvl(BigDecimal.TEN);
        assertThat(b, equalTo(BigDecimal.TEN));
    }

    @Test
    public void test_randomDouble_success() {
        System.out.println("test_NumericFun_randomDouble_success");

        double a = NumericFun.randomDouble();
        assertTrue(a > -1);

        double b = NumericFun.randomDouble(1d, 100d);
        assertTrue((Double.compare(1d, b) == -1 && Double.compare(b, 100d) == -1));
    }

    @Test
    public void test_timesPercent_success() {
        System.out.println("test_NumericFun_timesPercent_success");

        BigDecimal a = NumericFun.timesPercent(BigDecimal.valueOf(1000), 10);
        assertThat(a, equalTo(BigDecimal.valueOf(100)));

        BigDecimal b = NumericFun.timesPercent(BigDecimal.valueOf(0), 10);
        assertThat(b, equalTo(BigDecimal.ZERO));

        BigDecimal c = NumericFun.timesPercent(BigDecimal.valueOf(-100), 10);
        assertThat(c, equalTo(BigDecimal.valueOf(-10)));
    }

    @Test(expected = NullPointerException.class)
    public void test_timesPercent_exception() {
        System.out.println("test_NumericFun_timesPercent_exception");

        BigDecimal a = NumericFun.timesPercent(null, 10);
        assertThat(a, equalTo(BigDecimal.valueOf(100)));
    }

    @Test
    public void test_addPercent_sucess() {
        System.out.println("test_NumericFun_addPercent_success");
        BigDecimal a = NumericFun.addPercent(BigDecimal.valueOf(1000), 25);
        assertThat(a, equalTo(BigDecimal.valueOf(1250)));
    }

    @Test(expected = NullPointerException.class)
    public void test_addPercent_exception() {
        System.out.println("test_NumericFun_addPercent_exception");
        BigDecimal a = NumericFun.addPercent(null, 25);
        assertThat(a, equalTo(BigDecimal.valueOf(1250)));
    }

    @Test
    public void test_subPercent_success() {
        System.out.println("test_NumericFun_subPercent_success");
        BigDecimal a = NumericFun.subPercent(BigDecimal.valueOf(1000), 25);
        assertThat(a, equalTo(BigDecimal.valueOf(750)));
    }

    @Test(expected = NullPointerException.class)
    public void test_subPercent_exception() {
        System.out.println("test_NumericFun_subPercent_exception");
        BigDecimal a = NumericFun.subPercent(null, 25);
        assertThat(a, equalTo(BigDecimal.valueOf(750)));
    }

    @Test
    public void test_toPercent_success() {
        System.out.println("test_NumericFun_toPercent_success");
        BigDecimal a = NumericFun.toPercent(BigDecimal.valueOf(750), BigDecimal.valueOf(1000));
        assertThat(a, equalTo(BigDecimal.valueOf(75).setScale(2, RoundingMode.HALF_UP)));
    }

    @Test(expected = NullPointerException.class)
    public void test_toPercent_exception() {
        System.out.println("test_NumericFun_toPercent_exception");
        BigDecimal a = NumericFun.toPercent(null, BigDecimal.valueOf(1000));
         assertThat(a, equalTo(BigDecimal.valueOf(75).setScale(2, RoundingMode.HALF_UP)));
    }

    @Test
    public void test_addVat_success() {
        System.out.println("test_NumericFun_addVat_success");
        BigDecimal a = NumericFun.addVat(BigDecimal.valueOf(1000));
        assertThat(a, equalTo(BigDecimal.valueOf(1100.0)));
    }

    @Test(expected = NullPointerException.class)
    public void test_addVat_exception() {
        System.out.println("test_NumericFun_addVat_exception");
        BigDecimal a = NumericFun.addVat(null);
        assertThat(a, equalTo(BigDecimal.valueOf(1100.0)));
    }

}
