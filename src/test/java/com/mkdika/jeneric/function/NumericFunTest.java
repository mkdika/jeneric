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
}
