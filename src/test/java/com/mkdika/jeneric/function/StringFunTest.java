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

import com.mkdika.jeneric.types.DateFormat;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
        
        String e = StringFun.lpad("ABC", 5);
        assertThat(e, equalTo("  ABC"));
    }
    
    @Test
    public void test_lpad_unsuccess() {
        System.out.println("test_StringFun_lpad_unsuccess");
        
        String a = StringFun.lpad("", 0, 'X');
        assertThat(a, not(equalTo(("XXX"))));
        
        String b = StringFun.lpad("", 5, ' ');
        assertThat(b, not(equalTo((" "))));
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void test_lpad_exception() {
        System.out.println("test_StringFun_lpad_exception");
        
        String a = StringFun.lpad(null, 5, ' ');
        assertThat(a, not(equalTo((" "))));
    }
    
    @Test
    public void test_rpad_success() {
        System.out.println("test_StringFun_rpad_success");
        
        String a = StringFun.rpad("123", 6, '0');
        assertThat(a, equalTo("123000"));
        
        String b = StringFun.rpad("A", 10, 'X');
        assertThat(b, equalTo("AXXXXXXXXX"));
        
        String c = StringFun.rpad("XYZ", 0, '0');
        assertThat(c, equalTo("XYZ"));
        
        String d = StringFun.rpad("", 4, '0');
        assertThat(d, equalTo("0000"));
        
        String e = StringFun.rpad("ABC", 5);
        assertThat(e, equalTo("ABC  "));
    }
    
    @Test
    public void test_rpad_unsuccess() {
        System.out.println("test_StringFun_rpad_unsuccess");
        
        String a = StringFun.rpad("", 0, 'X');
        assertThat(a, not(equalTo(("XXX"))));
        
        String b = StringFun.rpad("", 5, ' ');
        assertThat(b, not(equalTo(("    "))));
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void test_rpad_exception() {
        System.out.println("test_StringFun_rpad_exception");
        
        String a = StringFun.rpad(null, 5, ' ');
        assertThat(a, not(equalTo((" "))));
    }
    
    @Test
    public void test_fromDate_success() {
        System.out.println("test_StringFun_fromDate_success");

        // 10 Dec 2018 15:15:30
        Date date = DateFun.of(2018, 12, 10, 15, 15, 30);
        
        String a = StringFun.fromDate(date);
        assertThat(a, equalTo("2018-12-10.15:15:30"));
        
        String b = StringFun.fromDate(date, DateFormat.BASIC_ISO_DATE_TIME);
        assertThat(b, equalTo("20181210151530"));
        
        String c = StringFun.fromDate(date, "MMM yy");
        assertThat(c, equalTo("Dec 18"));
    }
    
    @Test
    public void test_fromDate_unsuccess() {
        System.out.println("test_StringFun_fromDate_unsuccess");

        // 10 Dec 2018 15:15:30
        Date date = DateFun.of(2018, 12, 10, 15, 15, 30);
        
        String a = StringFun.fromDate(date, "");
        assertThat(a, not(equalTo("Dec 18")));
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void test_fromDate_exception() {
        System.out.println("test_StringFun_fromDate_exception");
        
        String a = StringFun.fromDate(null, DateFormat.DEFAULT);
        assertThat(a, not(equalTo("Dec 18")));
    }
    
    @Test
    public void test_nvl_success() {
        System.out.println("test_StringFun_nvl_success");
        
        String a = StringFun.nvl(null);
        assertThat(a, equalTo(""));
        
        String b = StringFun.nvl("abc");
        assertThat(b, equalTo("abc"));
    }
    
    @Test
    public void test_left_success() {
        System.out.println("test_StringFun_left_success");
        
        String a = StringFun.left("apple", 3);
        assertThat(a, equalTo("app"));
        
        String b = StringFun.left("apple", 10);
        assertThat(b, equalTo("apple"));
        
        String c = StringFun.left("apple", -2);
        assertThat(c, equalTo(""));
        
        String d = StringFun.left("apple", 3);
        assertThat(d, not(equalTo("ap")));
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void test_left_exception() {
        System.out.println("test_StringFun_left_exception");
        
        String a = StringFun.left(null, 3);
        assertThat(a, equalTo("app"));
    }
    
    @Test
    public void test_right_success() {
        System.out.println("test_StringFun_right_success");
        
        String a = StringFun.right("pineapple", 5);
        assertThat(a, equalTo("apple"));
        
        String b = StringFun.right("pineapple", 15);
        assertThat(b, equalTo("pineapple"));
        
        String c = StringFun.right("pineapple", -2);
        assertThat(c, equalTo(""));
        
        String d = StringFun.right("pineapple", 3);
        assertThat(d, not(equalTo("apple")));
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void test_right_exception() {
        System.out.println("test_StringFun_right_exception");
        
        String a = StringFun.right(null, 3);
        assertThat(a, equalTo("app"));
    }
    
    @Test
    public void test_middle_success() {
        System.out.println("test_StringFun_middle_success");
        
        String a = StringFun.middle("banana", 2, 3);
        assertThat(a, equalTo("nan"));
        
        String b = StringFun.middle("banana", 15, 2);
        assertThat(b, equalTo(""));
        
        String c = StringFun.middle("banana", -2, 2);
        assertThat(c, equalTo(""));
        
        String d = StringFun.middle("banana", 1, 3);
        assertThat(d, not(equalTo("nan")));
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void test_middle_exception() {
        System.out.println("test_StringFun_middle_exception");
        
        String a = StringFun.middle(null, 3, 3);
        assertThat(a, equalTo("xxx"));
    }
    
    @Test
    public void test_leftTrim_success() {
        System.out.println("test_StringFun_leftTrim_success");
        
        String a = StringFun.leftTrim("pineapple", 4);
        assertThat(a, equalTo("apple"));
        
        String b = StringFun.leftTrim("pineapple", 15);
        assertThat(b, equalTo(""));
        
        String c = StringFun.leftTrim("pineapple", -2);
        assertThat(c, equalTo("pineapple"));
        
        String d = StringFun.leftTrim("pineapple", 3);
        assertThat(d, not(equalTo("apple")));
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void test_leftTrim_exception() {
        System.out.println("test_StringFun_leftTrim_exception");
        
        String a = StringFun.leftTrim(null, 3);
        assertThat(a, equalTo("app"));
    }
    
    @Test
    public void test_rightTrim_success() {
        System.out.println("test_StringFun_rightTrim_success");
        
        String a = StringFun.rightTrim("pineapple", 4);
        assertThat(a, equalTo("pinea"));
        
        String b = StringFun.rightTrim("pineapple", 15);
        assertThat(b, equalTo(""));
        
        String c = StringFun.rightTrim("pineapple", -2);
        assertThat(c, equalTo("pineapple"));
        
        String d = StringFun.rightTrim("pineapple", 3);
        assertThat(d, not(equalTo("pine")));
        
    }
    
    @Test(expected = java.lang.NullPointerException.class)
    public void test_rightTrim_exception() {
        System.out.println("test_StringFun_rightTrim_exception");
        
        String a = StringFun.rightTrim(null, 3);
        assertThat(a, equalTo("app"));
    }
    
    @Test
    public void test_getIpV4Addres_success() throws SocketException {
        System.out.println("test_StringFun_getIpV4Address_success");        
        
        Set<String> a = StringFun.getIpV4Address();        
        assertNotNull(a);
        
        if (a.size() > 0) {
            a.stream().map((s) -> BooleanFun.isValidIpV4Address(s)).forEachOrdered((c) -> {
                assertTrue(c);
            });
        }        
    }
    
    @Test
    public void test_getMacAddress_success() throws SocketException {
        System.out.println("test_StringFun_getMacAddress_success");        
        
        Set<String> a = StringFun.getMacAddress();        
        assertNotNull(a);        
        
        if (a.size() > 0) {
            a.stream().map((s) -> BooleanFun.isValidMacAddress(s)).forEachOrdered((c) -> {
                assertTrue(c);
            });
        }               
    }
    
    @Test
    public void test_toMd5_success() throws NoSuchAlgorithmException, UnsupportedEncodingException, UnsupportedEncodingException {
        System.out.println("test_StringFun_toMd5_success");
        
        String hashA = "F25A2FC72690B780B2A14E140EF6A9E0";
        String a = StringFun.toMd5("iloveyou");        
        assertNotNull(a);        
        assertThat(a.length(), equalTo(32));
        assertThat(a.toUpperCase(),equalTo(hashA));
        
        String hashB = "ce491ffa534d26fe1cfaa089fc21f616";
        String b = StringFun.toMd5("I Miss Youabc123");        
        assertNotNull(b);        
        assertThat(b.length(), equalTo(32));
        assertThat(b,equalTo(hashB));
    }
    
    @Test(expected = NullPointerException.class)
    public void test_toMd5_exception() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("test_StringFun_toMd5_exception");
        
        String a = StringFun.toMd5(null);          
        assertThat(a.length(), equalTo(32));        
    }
    
    @Test
    public void test_toSha_success() throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_toSha_success");
        
        String hashA = "ee8d8728f435fd550f83852aabab5234ce1da528";
        String a = StringFun.toSha("iloveyou");        
        assertNotNull(a);                
        assertThat(a,equalTo(hashA));   
        
        String hashB = "5165baf7b1eabd262e553ea5f0d8c02f0db88d70";
        String b = StringFun.toSha("I Miss Youabc123");        
        assertNotNull(b);                
        assertThat(b,equalTo(hashB));
    }
    
    @Test(expected = NullPointerException.class)
    public void test_toSha_exception()throws NoSuchAlgorithmException {
         System.out.println("test_StringFun_toSha_exception");
        
        String a = StringFun.toSha(null);          
        assertThat(a.length(), equalTo(32));     
    }
    
    @Test
    public void test_toSha256_success() throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_toSha256_success");
        
        String hashA = "e4ad93ca07acb8d908a3aa41e920ea4f4ef4f26e7f86cf8291c5db289780a5ae";
        String a = StringFun.toSha256("iloveyou");        
        assertNotNull(a);                
        assertThat(a,equalTo(hashA));   
        
        String hashB = "e06d6c9ef50e95ab3520f211866f3f9503357b76675cdaf29a592f28182a5607";
        String b = StringFun.toSha256("I Miss Youabc123");        
        assertNotNull(b);                
        assertThat(b,equalTo(hashB));
    }
    
    @Test(expected = NullPointerException.class)
    public void test_toSha256_exception()throws NoSuchAlgorithmException {
         System.out.println("test_StringFun_toSha256_exception");
        
        String a = StringFun.toSha256(null);          
        assertThat(a.length(), equalTo(32));     
    }
}
