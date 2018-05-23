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
import java.math.BigDecimal;
import java.math.RoundingMode;
import static org.hamcrest.CoreMatchers.equalTo;
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
    public void test_timesPercent_success() {
        System.out.println("test_NumericFun_timesPercent_success");

        BigDecimal a = NumericFun.timesPercent(BigDecimal.valueOf(1000), 10);
        assertThat(a, equalTo(BigDecimal.valueOf(100.0d)));

        BigDecimal b = NumericFun.timesPercent(BigDecimal.valueOf(0), 10);
        assertThat(b, equalTo(BigDecimal.valueOf(0.0d)));

        BigDecimal c = NumericFun.timesPercent(BigDecimal.valueOf(-100), 10);
        assertThat(c, equalTo(BigDecimal.valueOf(-10.0d)));
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
        assertThat(a, equalTo(BigDecimal.valueOf(1250.0d)));
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
        assertThat(a, equalTo(BigDecimal.valueOf(750.0d)));
    }

    @Test(expected = NullPointerException.class)
    public void test_subPercent_exception() {
        System.out.println("test_NumericFun_subPercent_exception");
        BigDecimal a = NumericFun.subPercent(null, 25);
        assertThat(a, equalTo(BigDecimal.valueOf(750.0d)));
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
}
