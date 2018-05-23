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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
@RunWith(JUnitParamsRunner.class)
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
    @Parameters({"2018,1 ,1 ,10,30,45,"
        + "2018,1 ,25,10,30,45,"
        + "2018,1 ,10,10,30,45,"
        + "2018,1 ,20,10,30,45,true",
        "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,25,10,30,45,"
        + "2018,1 ,10,10,30,45,"
        + "2018,2 ,20,10,30,45,true",
        "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,25,10,30,45,"
        + "2017,12,10,10,30,45,"
        + "2018,1 ,20,10,30,45,true",
        "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,1 ,10,30,45,true",
        "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,10,10,30,45,"
        + "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,10,10,30,45,true",
        "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,10,10,30,45,"
        + "2018,1 ,10,10,30,45,"
        + "2018,1 ,20,10,30,45,true",
        "2018,1 ,1 ,10,30,45,"
        + "2018,1 ,10,10,30,45,"
        + "2018,1 ,10,10,30,45,"
        + "2018,1 ,20,10,30,45,true",
        "2018,1 ,1 ,1 ,1 ,1 ,"
        + "2018,1 ,10,1 ,1 ,1 ,"
        + "2018,1 ,11,1 ,1 ,1 ,"
        + "2018,1 ,20,1 ,1 ,1 ,false",
        "2018,1 ,1 ,1 ,1 ,1 ,"
        + "2018,1 ,3 ,1 ,1 ,1 ,"
        + "2018,1 ,2 ,1 ,1 ,1 ,"
        + "2018,1 ,2 ,1 ,1 ,1 ,true",
        "2018,1 ,3 ,1 ,1 ,1 ,"
        + "2018,1 ,4 ,1 ,1 ,1 ,"
        + "2018,1 ,2 ,1 ,1 ,1 ,"
        + "2018,1 ,2 ,1 ,1 ,1 ,false",
        "2018,1 ,3 ,1 ,1 ,1 ,"
        + "2018,1 ,4 ,1 ,1 ,1 ,"
        + "2018,1 ,5 ,1 ,1 ,1 ,"
        + "2018,1 ,5 ,1 ,1 ,1 ,false"
    })
    public void test_isDateOverlap_success(int a1, int b1, int c1, int d1, int e1, int f1,
            int a2, int b2, int c2, int d2, int e2, int f2,
            int a3, int b3, int c3, int d3, int e3, int f3,
            int a4, int b4, int c4, int d4, int e4, int f4, boolean result) {
        System.out.println("test_BooleanFun_isDateOverlap_success");

        Date dtA1 = DateFun.of(a1, b1, c1, d1, e1, f1);
        Date dtA2 = DateFun.of(a2, b2, c2, d2, e2, f2);
        Date dtA3 = DateFun.of(a3, b3, c3, d3, e3, f3);
        Date dtA4 = DateFun.of(a4, b4, c4, d4, e4, f4);
        boolean b = BooleanFun.isDateOverlap(dtA1, dtA2, dtA3, dtA4);
        assertThat(b, equalTo(result));
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

    Object[] isStringContainsParam1() {
        return new Object[]{
            new Object[]{"apple", Arrays.asList("apple"), true},
            new Object[]{"banana", Arrays.asList("apple", "banana"), true},
            new Object[]{"apple", Arrays.asList("apple", "banana"), true},
            new Object[]{"grape", Arrays.asList("apple", "banana", "coconut"), false},
            new Object[]{"apple", Arrays.asList("mango"), false},
        };
    }

    @Test
    @Parameters(method = "isStringContainsParam1")
    public void test_isStringContains_success(String s, List<String> list, boolean result) {
        System.out.println("test_BooleanFun_isStringContains_success");

        boolean a = BooleanFun.isStringContains(s, list);
        assertThat(a, equalTo(result));

        boolean b = BooleanFun.isStringContains(s, list.toArray(new String[list.size()]));
        assertThat(b, equalTo(result));
    }

    Object[] isStringContainsParam2() {
        return new Object[]{
            new Object[]{null, Arrays.asList("apple"), false},
            new Object[]{"", Arrays.asList("apple"), false},
            new Object[]{"grape", null, false},
            new Object[]{"grape", new ArrayList<>(), false},
            new Object[]{null, null, false},
            new Object[]{null, new ArrayList<>(), false},
            new Object[]{"", new ArrayList<>(), false},
            new Object[]{"", null, false},};
    }

    @Test
    @Parameters(method = "isStringContainsParam2")
    public void test_isStringContains_unsuccess(String s, List<String> list, boolean result) {
        System.out.println("test_BooleanFun_isStringContains_unsuccess");
        
        boolean c = BooleanFun.isStringContains(s, list);
        assertThat(c, equalTo(result));
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
    @Parameters({"maikel, false",
        "app1e, true",
        "G0O6LE, true"
    })
    public void test_isStringContainNumeric_success(String input, boolean result) {
        System.out.println("test_BooleanFun_isStringContainNumeric_success");

        boolean a = BooleanFun.isStringContainNumeric(input);
        assertThat(a, equalTo(result));
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
    @Parameters({"123456, false",
        "125O00, true",
        "maikel7369, true"
    })
    public void test_isStringContainAlphabet_success(String input, boolean result) {
        System.out.println("test_BooleanFun_isStringContainAlphabet_success");

        boolean a = BooleanFun.isStringContainAlphabet(input);
        assertThat(a, equalTo(result));
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
    @Parameters({"3.0d, false",
        "12.56d, true"
    })
    public void test_isDoubleFractional_success(Double d, boolean result) {
        System.out.println("test_BooleanFun_isDoubleFractional_success");

        boolean a = BooleanFun.isDoubleFractional(d);
        assertThat(a, equalTo(result));
    }

    @Test(expected = NullPointerException.class)
    public void test_isDoubleFractional_exception() {
        System.out.println("test_BooleanFun_isDoubleFractional_exception");

        boolean a = BooleanFun.isDoubleFractional(null);
        assertFalse(a);
    }

    @Test
    @Parameters({"madam, true",
        "able was I ere I saw elba,true",
        "avid siva,false",
        "a,true",
        ",true"

    })
    public void test_isPalindrome_success(String input, boolean result) {
        System.out.println("test_BooleanFun_isPalindrome_success");

        boolean a = BooleanFun.isPalindrome(input);
        assertThat(a, equalTo(result));
    }

    @Test(expected = NullPointerException.class)
    public void test_isPalindrome_exception() {
        System.out.println("test_BooleanFun_isPalindrome_exception");

        boolean a = BooleanFun.isPalindrome(null);
        assertTrue(a);
    }

    @Test
    @Parameters({
        "1,false",
        "983,true",
        "179424691,true",
        "179425321,false",
        "1000000,false"
    })
    public void test_isPrime_success(int input, boolean result) {
        System.out.println("test_BooleanFun_isPrime_success");

        boolean a = BooleanFun.isPrime(input);
        assertThat(a, equalTo(result));
    }

    @Test
    @Parameters({
        "192.168.1.1,true",
        "127.0.0.1,true",
        "0.0.0.0,true",
        "10.100.090.002,true",
        "222.222.2.999,false",
        "172.16.230,false",
        ",false"
    })
    public void test_isValidIpV4Address_success(String input, boolean result) {
        System.out.println("test_BooleanFun_isValidIpV4Address_success");

        boolean a = BooleanFun.isValidIpV4Address(input);
        assertThat(a, equalTo(result));
    }

    @Test
    @Parameters({
        "bc:85:56:20:f3:bf,true",
        "bc:00:56:20:F3:BF,true",
        "00:GH:DE:EF:AB:BC,false",
        ",false"
    })
    public void test_isValidMacAddress_success(String input, boolean result) {
        System.out.println("test_BooleanFun_isValidMacAddress_success");

        boolean a = BooleanFun.isValidMacAddress(input);
        assertThat(a, equalTo(result));
    }
}
