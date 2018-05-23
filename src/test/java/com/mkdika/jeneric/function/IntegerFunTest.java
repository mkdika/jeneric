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
import static org.hamcrest.CoreMatchers.not;
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
public class IntegerFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_IntegerFun_class_instance");

        try {
            Constructor<IntegerFun> c = IntegerFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            IntegerFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_nvl_success() {
        System.out.println("test_IntegerFun_nvl_success");

        Integer a = IntegerFun.nvl(125);
        assertThat(a, equalTo(125));
        
        Integer b = IntegerFun.nvl(null);
        assertThat(b, equalTo(0));
    }
    
    @Test
    public void test_rand_success() {
        System.out.println("test_IntegerFun_nvl_success");
                        
        Integer a = IntegerFun.random();        
        assertTrue(a > -1);
        
        Integer b = IntegerFun.random(1, 1000);        
        assertTrue((b > 1 && b <= 1000));        
    }
}
