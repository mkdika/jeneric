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
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class DoubleFunTest {
    
    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_DoubleFun_class_instance");

        try {
            Constructor<DoubleFun> c = DoubleFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            DoubleFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }
    
    @Test
    public void test_randomDouble_success() {
        System.out.println("test_DoubleFun_randomDouble_success");

        double a = DoubleFun.random();
        assertTrue(a > -1);

        double b = DoubleFun.random(1d, 100d);
        assertTrue((Double.compare(1d, b) == -1 && Double.compare(b, 100d) == -1));
    }
    
    @Test
    public void test_nvl_double_success() {
        System.out.println("test_DoubleFun_double_nvl_success");

        Double a = DoubleFun.nvl(null);
        assertThat(a, equalTo(0.0d));

        Double b = DoubleFun.nvl(10d);
        assertThat(b, equalTo(10d));
    }
    
}
