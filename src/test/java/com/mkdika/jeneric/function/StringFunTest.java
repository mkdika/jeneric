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
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class StringFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_StringFun_class_instance");
        
        try {
            Constructor<StringFun> c = StringFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            StringFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_lpad_success() {
        System.out.println("test_StringFun_lpad_success");

        String a = StringFun.lpad("123", 6, '0');
        assertThat(a, equalTo("000123"));

        String b = StringFun.lpad("A", 10, 'X');
        assertThat(b, equalTo("XXXXXXXXXA"));

        String c = StringFun.lpad("XYZ", 0, '0');
        assertThat(c, equalTo("XYZ"));

        String d = StringFun.lpad("", 4, '0');
        assertThat(d, equalTo("0000"));
    }

    @Test
    public void test_lpad_unsuccess() {
        System.out.println("test_StringFun_lpad_unsuccess");

        String a = StringFun.lpad("", 0, 'X');
        assertThat(a, not(equalTo(("XXXX"))));

        String b = StringFun.lpad("", 5, ' ');
        assertThat(b, not(equalTo((" "))));
    }

}
