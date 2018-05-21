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

        Date dtA1 = DateFun.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtA2 = DateFun.of(2018, 1, 25, 10, 30, 45); // 25 Jan 2018 10:30:45
        Date dtA3 = DateFun.of(2018, 1, 10, 10, 30, 45); // 10 Jan 2018 10:30:45
        Date dtA4 = DateFun.of(2018, 1, 20, 10, 30, 45); // 20 Jan 2018 10:30:45
        boolean a = BooleanFun.isDateOverlap(dtA1, dtA2, dtA3, dtA4);
        assertTrue(a);

        Date dtB1 = DateFun.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtB2 = DateFun.of(2018, 1, 25, 10, 30, 45); // 25 Jan 2018 10:30:45
        Date dtB3 = DateFun.of(2018, 1, 10, 10, 30, 45); // 10 Jan 2018 10:30:45
        Date dtB4 = DateFun.of(2018, 2, 20, 10, 30, 45); // 20 Feb 2018 10:30:45
        boolean b = BooleanFun.isDateOverlap(dtB1, dtB2, dtB3, dtB4);
        assertTrue(b);

        Date dtC1 = DateFun.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtC2 = DateFun.of(2018, 1, 25, 10, 30, 45);  // 25 Jan 2018 10:30:45
        Date dtC3 = DateFun.of(2017, 12, 10, 10, 30, 45); // 10 Dec 2017 10:30:45
        Date dtC4 = DateFun.of(2018, 1, 20, 10, 30, 45);  // 20 Feb 2018 10:30:45
        boolean c = BooleanFun.isDateOverlap(dtC1, dtC2, dtC3, dtC4);
        assertTrue(c);

        Date dtD1 = DateFun.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtD2 = DateFun.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtD3 = DateFun.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        Date dtD4 = DateFun.of(2018, 1, 1, 10, 30, 45);  // 1  Jan 2018 10:30:45
        boolean d = BooleanFun.isDateOverlap(dtD1, dtD2, dtD3, dtD4);
        assertTrue(d);

        Date dtE1 = DateFun.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtE2 = DateFun.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtE3 = DateFun.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtE4 = DateFun.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        boolean e = BooleanFun.isDateOverlap(dtE1, dtE2, dtE3, dtE4);
        assertTrue(e);

        Date dtF1 = DateFun.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtF2 = DateFun.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtF3 = DateFun.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtF4 = DateFun.of(2018, 1, 20, 10, 30, 45);  // 20 Jan 2018 10:30:45
        boolean f = BooleanFun.isDateOverlap(dtF1, dtF2, dtF3, dtF4);
        assertTrue(f);

        Date dtG1 = DateFun.of(2018, 1, 1, 10, 30, 45);   // 1  Jan 2018 10:30:45
        Date dtG2 = DateFun.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtG3 = DateFun.of(2018, 1, 10, 10, 30, 46);  // 10 Jan 2018 10:30:45
        Date dtG4 = DateFun.of(2018, 1, 20, 10, 30, 45);  // 20 Jan 2018 10:30:45
        boolean g = BooleanFun.isDateOverlap(dtG1, dtG2, dtG3, dtG4);
        assertFalse(g);

        Date dtH1 = DateFun.of(2018, 1, 1);   // 1  Jan 2018
        Date dtH2 = DateFun.of(2018, 1, 10);  // 10 Jan 2018
        Date dtH3 = DateFun.of(2018, 1, 11);  // 11 Jan 2018
        Date dtH4 = DateFun.of(2018, 1, 20);  // 20 Jan 2018
        boolean h = BooleanFun.isDateOverlap(dtH1, dtH2, dtH3, dtH4);
        assertFalse(h);

        Date dtI1 = DateFun.of(2018, 1, 1);   // 1  Jan 2018
        Date dtI2 = DateFun.of(2018, 1, 3);  // 3 Jan 2018
        Date dtI3 = DateFun.of(2018, 1, 2);  // 2 Jan 2018
        Date dtI4 = DateFun.of(2018, 1, 2);  // 2 Jan 2018
        boolean i = BooleanFun.isDateOverlap(dtI1, dtI2, dtI3, dtI4);
        assertTrue(i);

        Date dtJ1 = DateFun.of(2018, 1, 3);   // 3  Jan 2018
        Date dtJ2 = DateFun.of(2018, 1, 4);  // 4 Jan 2018
        Date dtJ3 = DateFun.of(2018, 1, 2);  // 2 Jan 2018
        Date dtJ4 = DateFun.of(2018, 1, 2);  // 2 Jan 2018
        boolean j = BooleanFun.isDateOverlap(dtJ1, dtJ2, dtJ3, dtJ4);
        assertFalse(j);

        Date dtK1 = DateFun.of(2018, 1, 3);   // 3  Jan 2018
        Date dtK2 = DateFun.of(2018, 1, 4);  // 4 Jan 2018
        Date dtK3 = DateFun.of(2018, 1, 5);  // 5 Jan 2018
        Date dtK4 = DateFun.of(2018, 1, 5);  // 5 Jan 2018
        boolean k = BooleanFun.isDateOverlap(dtK1, dtK2, dtK3, dtK4);
        assertFalse(k);
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
        Date dtA1 = DateFun.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtA2 = DateFun.of(2018, 1, 9, 10, 30, 45);   // 9  Jan 2018 10:30:45
        Date dtA3 = DateFun.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
        Date dtA4 = DateFun.of(2018, 1, 20, 10, 30, 45);  // 20 Jan 2018 10:30:45
        boolean a = BooleanFun.isDateOverlap(dtA1, dtA2, dtA3, dtA4);
        assertTrue(a);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_isDateOverlap_exception3() {
        System.out.println("test_BooleanFun_isDateOverlap_exception3");
        Date dtA1 = DateFun.of(2018, 1, 1, 10, 30, 45);  // 1 Jan 2018 10:30:45
        Date dtA2 = DateFun.of(2018, 1, 9, 10, 30, 45);   // 9  Jan 2018 10:30:45
        Date dtA3 = DateFun.of(2018, 1, 11, 10, 30, 45);  // 11 Jan 2018 10:30:45
        Date dtA4 = DateFun.of(2018, 1, 10, 10, 30, 45);  // 10 Jan 2018 10:30:45
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

        boolean b = BooleanFun.isStringContains("grape", "apple", "banana", "coconut");
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

    @Test
    public void test_isDoubleFractional_success() {
        System.out.println("test_BooleanFun_isDoubleFractional_success");

        boolean a = BooleanFun.isDoubleFractional(3.0d);
        assertFalse(a);

        boolean b = BooleanFun.isDoubleFractional(12.56d);
        assertTrue(b);

    }

    @Test(expected = NullPointerException.class)
    public void test_isDoubleFractional_exception() {
        System.out.println("test_BooleanFun_isDoubleFractional_exception");

        boolean a = BooleanFun.isDoubleFractional(null);
        assertFalse(a);
    }

    @Test
    public void test_isPalindrome_success() {
        System.out.println("test_BooleanFun_isPalindrome_success");

        boolean a = BooleanFun.isPalindrome("madam");
        assertTrue(a);

        boolean b = BooleanFun.isPalindrome("able was I ere I saw elba");
        assertTrue(b);

        boolean c = BooleanFun.isPalindrome("avid siva");
        assertFalse(c);

        boolean d = BooleanFun.isPalindrome("a");
        assertTrue(d);

        boolean e = BooleanFun.isPalindrome("");
        assertTrue(e);
    }

    @Test(expected = NullPointerException.class)
    public void test_isPalindrome_exception() {
        System.out.println("test_BooleanFun_isPalindrome_exception");

        boolean a = BooleanFun.isPalindrome(null);
        assertTrue(a);
    }

    @Test
    public void test_isPrime_success() {
        System.out.println("test_BooleanFun_isPrime_success");

        boolean a = BooleanFun.isPrime(1);
        assertFalse(a);

        boolean b = BooleanFun.isPrime(983);
        assertTrue(b);

        boolean c = BooleanFun.isPrime(179_424_691);
        assertTrue(c);

        boolean d = BooleanFun.isPrime(179_425_321);
        assertFalse(d);

        boolean e = BooleanFun.isPrime(1_000_000L, 10);
        assertFalse(e);
    }

    @Test
    public void test_isValidIpV4Address_success() {
        System.out.println("test_BooleanFun_isValidIpV4Address_success");

        boolean a = BooleanFun.isValidIpV4Address("192.168.1.1");
        assertTrue(a);

        boolean b = BooleanFun.isValidIpV4Address("127.0.0.1");
        assertTrue(b);

        boolean c = BooleanFun.isValidIpV4Address("0.0.0.0");
        assertTrue(c);

        boolean d = BooleanFun.isValidIpV4Address("10.100.090.002");
        assertTrue(d);

        boolean e = BooleanFun.isValidIpV4Address("222.222.2.999");
        assertFalse(e);

        boolean f = BooleanFun.isValidIpV4Address("172.16.230");
        assertFalse(f);

        boolean g = BooleanFun.isValidIpV4Address(null);
        assertFalse(g);
    }

    @Test
    public void test_isValidMacAddress_success() {
        System.out.println("test_BooleanFun_isValidMacAddress_success");

        boolean a = BooleanFun.isValidMacAddress("bc:85:56:20:f3:bf");
        assertTrue(a);

        boolean b = BooleanFun.isValidMacAddress("bc:00:56:20:F3:BF");
        assertTrue(b);

        boolean c = BooleanFun.isValidMacAddress("00:GH:DE:EF:AB:BC");
        assertFalse(c);

        boolean d = BooleanFun.isValidMacAddress(null);
        assertFalse(d);
    }
}
