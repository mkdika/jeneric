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

import com.mkdika.jeneric.model.TimePeriod;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
@RunWith(JUnitParamsRunner.class)
public class ObjectFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_CustomFun_class_instance");

        try {
            Constructor<ObjectFun> c = ObjectFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            ObjectFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_calculatePeriod_success() {
        System.out.println("test_CustomFun_calculatePeriod_success");

        Date dA1 = DateFun.of(2018, 5, 10, 3, 10, 0);
        Date dA2 = DateFun.of(2018, 7, 10, 5, 12, 50);
        TimePeriod tA = ObjectFun.calculatePeriod(dA1, dA2);
        assertNotNull(tA);
        assertThat(tA.getDays(), equalTo(61L));
        assertThat(tA.getHours(), equalTo(2L));
        assertThat(tA.getMinutes(), equalTo(2L));
        assertThat(tA.getSeconds(), equalTo(50L));
        assertThat(tA.getMilliseconds(), equalTo(0L));

        TimePeriod tB = ObjectFun.calculatePeriod(1525896600000L, 1525924550000L);
        assertNotNull(tB);
        assertThat(tB.getDays(), equalTo(0L));
        assertThat(tB.getHours(), equalTo(7L));
        assertThat(tB.getMinutes(), equalTo(45L));
        assertThat(tB.getSeconds(), equalTo(50L));
        assertThat(tB.getMilliseconds(), equalTo(0L));
    }
    
    Object[] calculatePeriodParam1() {
        return new Object[]{      
            new Object[]{DateFun.of(2018, 7, 10, 5, 12, 50), DateFun.of(2018, 7, 10, 5, 12, 50) },            
            new Object[]{DateFun.of(2010, 7, 10, 5, 12, 50), DateFun.of(2018, 7, 10, 3, 10, 0) },            
            new Object[]{DateFun.of(2011, 7, 10, 5, 12, 50), DateFun.of(2018, 5, 10, 3, 10, 0) },            
            new Object[]{DateFun.of(2012, 7, 10, 5, 12, 50), DateFun.of(2018, 1, 10, 3, 10, 0) },            
        };
    }
    
    @Test
    @Parameters(method = "calculatePeriodParam1")
    public void test_calculatePeriod_success2(Date d1, Date d2) {
        System.out.println("test_CustomFun_calculatePeriod_success2");
        
        TimePeriod tA = ObjectFun.calculatePeriod(d1,d2);
        assertNotNull(tA);
    }

    @Test(expected = NullPointerException.class)
    public void test_calculatePeriod_exception1() {
        System.out.println("test_CustomFun_calculatePeriod_exception1");

        TimePeriod tA = ObjectFun.calculatePeriod(null, null);
    }
    
    Object[] calculatePeriodParam2() {
        return new Object[]{            
            new Object[]{DateFun.of(2018, 7, 10, 5, 12, 50), DateFun.of(2018, 7, 10, 3, 10, 0) },            
            new Object[]{DateFun.of(2018, 7, 10, 5, 12, 50), DateFun.of(2018, 5, 10, 3, 10, 0) },            
            new Object[]{DateFun.of(2018, 7, 10, 5, 12, 50), DateFun.of(2018, 1, 10, 3, 10, 0) },            
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "calculatePeriodParam2")
    public void test_calculatePeriod_exception2(Date d1, Date d2) {
        System.out.println("test_CustomFun_calculatePeriod_exception2");
        
        TimePeriod tA = ObjectFun.calculatePeriod(d1, d2);
    }

}
