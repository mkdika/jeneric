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

import com.mkdika.jeneric.helper.DateHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertFalse;
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
public class BooleanFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_BooleanFun_class_instance");

        try {
            Constructor<BooleanFun> c = BooleanFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            BooleanFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_isDateOverlap_success() {
        System.out.println("test_BooleanFun_isDateOverlap_success");

        Date dtA1 = DateHelper.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtA2 = DateHelper.of(2018, 1, 25, 10, 30, 45); // 25 Jan 2018 10:30:45
        Date dtA3 = DateHelper.of(2018, 1, 10, 10, 30, 45); // 10 Jan 2018 10:30:45
        Date dtA4 = DateHelper.of(2018, 1, 20, 10, 30, 45); // 20 Jan 2018 10:30:45
        boolean a = BooleanFun.isDateOverlap(dtA1, dtA2, dtA3, dtA4);
        assertTrue(a);

        Date dtB1 = DateHelper.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtB2 = DateHelper.of(2018, 1, 25, 10, 30, 45); // 25 Jan 2018 10:30:45
        Date dtB3 = DateHelper.of(2018, 1, 10, 10, 30, 45); // 10 Jan 2018 10:30:45
        Date dtB4 = DateHelper.of(2018, 2, 20, 10, 30, 45); // 20 Feb 2018 10:30:45
        boolean b = BooleanFun.isDateOverlap(dtB1, dtB2, dtB3, dtB4);
        assertTrue(b);

        Date dtC1 = DateHelper.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtC2 = DateHelper.of(2018, 1, 25, 10, 30, 45);  // 25 Jan 2018 10:30:45
        Date dtC3 = DateHelper.of(2017, 12, 10, 10, 30, 45); // 10 Dec 2017 10:30:45
        Date dtC4 = DateHelper.of(2018, 1, 20, 10, 30, 45);  // 20 Feb 2018 10:30:45
        boolean c = BooleanFun.isDateOverlap(dtC1, dtC2, dtC3, dtC4);
        assertTrue(c);

        Date dtD1 = DateHelper.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtD2 = DateHelper.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtD3 = DateHelper.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtD4 = DateHelper.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        boolean d = BooleanFun.isDateOverlap(dtD1, dtD2, dtD3, dtD4);
        assertTrue(d);

        Date dtE1 = DateHelper.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtE2 = DateHelper.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtE3 = DateHelper.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtE4 = DateHelper.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        boolean e = BooleanFun.isDateOverlap(dtE1, dtE2, dtE3, dtE4);
        assertTrue(e);

        Date dtF1 = DateHelper.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtF2 = DateHelper.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtF3 = DateHelper.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtF4 = DateHelper.of(2018, 1, 20, 10, 30, 45);  // 20 Jan 2018 10:30:45
        boolean f = BooleanFun.isDateOverlap(dtF1, dtF2, dtF3, dtF4);
        assertTrue(f);

        Date dtG1 = DateHelper.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtG2 = DateHelper.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtG3 = DateHelper.of(2018, 1, 10, 10, 30, 46);  // 10 Jan 2018 10:30:45
        Date dtG4 = DateHelper.of(2018, 1, 20, 10, 30, 45);  // 20 Jan 2018 10:30:45
        boolean g = BooleanFun.isDateOverlap(dtG1, dtG2, dtG3, dtG4);
        assertFalse(g);

        Date dtH1 = DateHelper.of(2018, 1, 1);   // 1  Jan 2018
        Date dtH2 = DateHelper.of(2018, 1, 10);  // 10 Jan 2018
        Date dtH3 = DateHelper.of(2018, 1, 11);  // 10 Jan 2018
        Date dtH4 = DateHelper.of(2018, 1, 20);  // 20 Jan 2018
        boolean h = BooleanFun.isDateOverlap(dtH1, dtH2, dtH3, dtH4);
        assertFalse(h);
    }
    
    @Test(expected = NullPointerException.class)
    public void test_isDateOverlap_exception1() {
        System.out.println("test_BooleanFun_isDateOverlap_exception1");
        boolean a = BooleanFun.isDateOverlap(null, null, null, null);
        assertFalse(a);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_isDateOverlap_exception2() {
        System.out.println("test_BooleanFun_isDateOverlap_exception2");
        Date dtA1 = DateHelper.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtA2 = DateHelper.of(2018, 1, 9, 10, 30, 45);   // 9  Jan 2018 10:30:45
        Date dtA3 = DateHelper.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtA4 = DateHelper.of(2018, 1, 20, 10, 30, 45);  // 20 Jan 2018 10:30:45
        boolean a = BooleanFun.isDateOverlap(dtA1, dtA2, dtA3, dtA4);
        assertTrue(a);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_isDateOverlap_exception3() {
        System.out.println("test_BooleanFun_isDateOverlap_exception3");
        Date dtA1 = DateHelper.of(2018, 1, 1, 10, 30, 45);  // 1 Jan 2018 10:30:45
        Date dtA2 = DateHelper.of(2018, 1, 9, 10, 30, 45);   // 9  Jan 2018 10:30:45
        Date dtA3 = DateHelper.of(2018, 1, 11, 10, 30, 45);  // 11 Jan 2018 10:30:45
        Date dtA4 = DateHelper.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        boolean a = BooleanFun.isDateOverlap(dtA1, dtA2, dtA3, dtA4);
        assertTrue(a);
    }
    
    @Test
    public void test_isStringContains_success() {
        System.out.println("test_BooleanFun_isStringContains_success");
        
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        boolean a = BooleanFun.isStringContains("banana", list);
        assertTrue(a);
        
        boolean b = BooleanFun.isStringContains("grape", "apple","banana","coconut");
        assertFalse(b);
    }
    
    @Test
    public void test_isStringContains_unsuccess() {
        System.out.println("test_BooleanFun_isStringContains_unsuccess");
        
        boolean a = BooleanFun.isStringContains(null, "apple");
        assertFalse(a);
        
        boolean b = BooleanFun.isStringContains("", "apple");
        assertFalse(b);
        
        List<String> listA = null;
        boolean c = BooleanFun.isStringContains("grape", listA);
        assertFalse(c);
        
        List<String> listB = new ArrayList<>();
        boolean d = BooleanFun.isStringContains("grape", listB);
        assertFalse(d);        
    }
    
    @Test
    public void test_nvl_success() {
        System.out.println("test_BooleanFun_nvl_success");
        
        boolean a = BooleanFun.nvl(Boolean.TRUE);
        assertTrue(a);
        
        boolean b = BooleanFun.nvl(null);
        assertFalse(b);
    }
    
    @Test
    public void test_isStringContainNumeric_success() {
        System.out.println("test_BooleanFun_isStringContainNumeric_success");
        
        boolean a = BooleanFun.isStringContainNumeric("maikel");
        assertFalse(a);
        
        boolean b = BooleanFun.isStringContainNumeric("app1e");
        assertTrue(b);
        
        boolean c = BooleanFun.isStringContainNumeric("G0O6LE");
        assertTrue(c);
    }
    
    @Test
    public void test_isStringContainNumeric_unsuccess() {
        System.out.println("test_BooleanFun_isStringContainNumber_unsuccess");
        
        boolean a = BooleanFun.isStringContainNumeric(null);
        assertFalse(a);

        boolean b = BooleanFun.isStringContainNumeric("+-*/");
        assertFalse(b);
    }
    
    @Test
    public void test_isStringContainAlphabet_success() {
        System.out.println("test_BooleanFun_isStringContainAlphabet_success");
        
        boolean a = BooleanFun.isStringContainAlphabet("123456");
        assertFalse(a);
        
        boolean b = BooleanFun.isStringContainAlphabet("125O00");
        assertTrue(b);
        
        boolean c = BooleanFun.isStringContainAlphabet("maikel7369");
        assertTrue(c);
    }
    
    @Test
    public void test_isStringContainAlphabet_unsuccess() {
        System.out.println("test_BooleanFun_isStringContainAlphabet_unsuccess");
        
        boolean a = BooleanFun.isStringContainAlphabet(null);
        assertFalse(a);

        boolean b = BooleanFun.isStringContainAlphabet("+-*/");
        assertFalse(b);
    }
}
