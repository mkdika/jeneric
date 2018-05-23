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

import com.mkdika.jeneric.types.DateFormat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Set;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
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

    Object[] lpadParam() {
        return new Object[]{
            new Object[]{"123", 6, '0', "000123"},
            new Object[]{"A", 10, 'X', "XXXXXXXXXA"},
            new Object[]{"XYZ", 0, '0', "XYZ"},
            new Object[]{"", 4, '0', "0000"},};
    }

    @Test
    @Parameters(method = "lpadParam")
    public void test_lpad_success(String s, int n, char c, String result) {
        System.out.println("test_StringFun_lpad_success");

        String a = StringFun.lpad(s, n, c);
        assertThat(a, equalTo(result));
    }

    @Test
    public void test_lpad_success2() {
        System.out.println("test_StringFun_lpad_succes2");

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

    Object[] rpadParam() {
        return new Object[]{
            new Object[]{"123", 6, '0', "123000"},
            new Object[]{"A", 10, 'X', "AXXXXXXXXX"},
            new Object[]{"XYZ", 0, '0', "XYZ"},
            new Object[]{"", 4, '0', "0000"},};
    }

    @Test
    @Parameters(method = "rpadParam")
    public void test_rpad_success(String s, int n, char c, String result) {
        System.out.println("test_StringFun_rpad_success");

        String a = StringFun.rpad(s, n, c);
        assertThat(a, equalTo(result));
    }

    @Test
    public void test_rpad_success2() {
        System.out.println("test_StringFun_rpad_succes2");
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

    Object[] leftParam1() {
        return new Object[]{
            new Object[]{"apple", -1, ""},
            new Object[]{"apple", 0, ""},
            new Object[]{"apple", 1, "a"},
            new Object[]{"apple", 3, "app"},
            new Object[]{"apple", 5, "apple"},
            new Object[]{"apple", 6, "apple"},
            new Object[]{"apple", 10, "apple"},};
    }

    @Test
    @Parameters(method = "leftParam1")
    public void test_left_success1(String s, int n, String result) {
        System.out.println("test_StringFun_left_success1");

        String a = StringFun.left(s, n);
        assertThat(a, equalTo(result));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void test_left_exception() {
        System.out.println("test_StringFun_left_exception");

        String a = StringFun.left(null, 3);
        assertThat(a, equalTo("app"));
    }

    Object[] rightParam() {
        return new Object[]{
            new Object[]{"pineapple", 5, "apple"},
            new Object[]{"pineapple", 15, "pineapple"},
            new Object[]{"pineapple", 9, "pineapple"},
            new Object[]{"pineapple", -2, ""},
            new Object[]{"pineapple", 0, ""},
            new Object[]{"pineapple", 3, "ple"}};
    }

    @Test
    @Parameters(method = "rightParam")
    public void test_right_success(String s, int n, String result) {
        System.out.println("test_StringFun_right_success");

        String a = StringFun.right(s, n);
        assertThat(a, equalTo(result));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void test_right_exception() {
        System.out.println("test_StringFun_right_exception");

        String a = StringFun.right(null, 3);
        assertThat(a, equalTo("app"));
    }

    Object[] middleParam() {
        return new Object[]{
            new Object[]{"banana", 2, 3, "nan"},
            new Object[]{"banana", 6, 3, ""},
            new Object[]{"banana", 15, 2, ""},
            new Object[]{"banana", -2, 2, ""},
            new Object[]{"banana", 0, 2, "ba"},
            new Object[]{"banana", 1, 3, "ana"}
        };
    }

    @Test
    @Parameters(method = "middleParam")
    public void test_middle_success(String s, int start, int len, String result) {
        System.out.println("test_StringFun_middle_success");

        String a = StringFun.middle(s, start, len);
        assertThat(a, equalTo(result));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void test_middle_exception() {
        System.out.println("test_StringFun_middle_exception");

        String a = StringFun.middle(null, 3, 3);
        assertThat(a, equalTo("xxx"));
    }

    Object[] leftTrimParam() {
        return new Object[]{
            new Object[]{"pineapple", 4, "apple"},
            new Object[]{"pineapple", 15, ""},
            new Object[]{"pineapple", 9, ""},
            new Object[]{"pineapple", -2, "pineapple"},
            new Object[]{"pineapple", 0, "pineapple"},
            new Object[]{"pineapple", 3, "eapple"},};
    }

    @Test
    @Parameters(method = "leftTrimParam")
    public void test_leftTrim_success(String s, int n, String result) {
        System.out.println("test_StringFun_leftTrim_success");

        String a = StringFun.leftTrim(s, n);
        assertThat(a, equalTo(result));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void test_leftTrim_exception() {
        System.out.println("test_StringFun_leftTrim_exception");

        String a = StringFun.leftTrim(null, 3);
        assertThat(a, equalTo("app"));
    }

    Object[] rightTrimParam() {
        return new Object[]{
            new Object[]{"pineapple", 4, "pinea"},
            new Object[]{"pineapple", 15, ""},
            new Object[]{"pineapple", 9, ""},
            new Object[]{"pineapple", -2, "pineapple"},
            new Object[]{"pineapple", 0, "pineapple"},
            new Object[]{"pineapple", 3, "pineap"},};
    }

    @Test
    @Parameters(method = "rightTrimParam")
    public void test_rightTrim_success(String s, int n, String result) {
        System.out.println("test_StringFun_rightTrim_success");

        String a = StringFun.rightTrim(s, n);
        assertThat(a, equalTo(result));
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
    @Parameters({
        "f25a2fc72690b780b2a14e140ef6a9e0,iloveyou",
        "ce491ffa534d26fe1cfaa089fc21f616,I Miss Youabc123"
    })
    public void test_toMd5_success(String hash, String plain) throws NoSuchAlgorithmException, UnsupportedEncodingException, UnsupportedEncodingException {
        System.out.println("test_StringFun_toMd5_success");

        String a = StringFun.toMd5(plain);
        assertNotNull(a);
        assertThat(a.length(), equalTo(32));
        assertThat(a, equalTo(hash));
    }

    @Test(expected = NullPointerException.class)
    public void test_toMd5_exception() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("test_StringFun_toMd5_exception");

        String a = StringFun.toMd5(null);
        assertThat(a.length(), equalTo(32));
    }

    @Test
    @Parameters({
        "ee8d8728f435fd550f83852aabab5234ce1da528,iloveyou",
        "5165baf7b1eabd262e553ea5f0d8c02f0db88d70,I Miss Youabc123"
    })
    public void test_toSha_success(String hash, String plain) throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_toSha_success");

        String a = StringFun.toSha(plain);
        assertNotNull(a);
        assertThat(a, equalTo(hash));
    }

    @Test(expected = NullPointerException.class)
    public void test_toSha_exception() throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_toSha_exception");

        String a = StringFun.toSha(null);
        assertThat(a.length(), equalTo(32));
    }

    @Test
    @Parameters({
        "e4ad93ca07acb8d908a3aa41e920ea4f4ef4f26e7f86cf8291c5db289780a5ae,iloveyou",
        "e06d6c9ef50e95ab3520f211866f3f9503357b76675cdaf29a592f28182a5607,I Miss Youabc123"
    })
    public void test_toSha256_success(String hash, String plain) throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_toSha256_success");

        String a = StringFun.toSha256(plain);
        assertNotNull(a);
        assertThat(a, equalTo(hash));
    }

    @Test(expected = NullPointerException.class)
    public void test_toSha256_exception() throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_toSha256_exception");

        String a = StringFun.toSha256(null);
        assertThat(a.length(), equalTo(32));
    }

    @Test
    @Parameters({"50e0dc4455bcb1ee80adb942d153c6b0eb17b31d603b017fa77f60f60f68fd7d0565cb486783f29cea210313c97f0f9d49e64e6730053bfa1448d5b826309184,"
        + "iloveyou",
        "7c431129049001626202effe2760ac0702e9a971b82ba9148f4a73975c4c27d25de875d9765f926c11d87c25cdcaf3a87080a9cdf026127a17859923643778b2,"
        + "I Miss Youabc123"
    })
    public void test_toSha512_success(String hash, String plain) throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_toSha512_success");

        String a = StringFun.toSha512(plain);
        assertNotNull(a);
        assertThat(a, equalTo(hash));
    }

    @Test(expected = NullPointerException.class)
    public void test_toSha512_exception() throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_toSha512_exception");

        String a = StringFun.toSha512(null);
        assertThat(a.length(), equalTo(32));
    }

    @Test
    public void test_getUUID_success() {
        System.out.println("test_StringFun_getUUID_success");

        String a = StringFun.getUUID();
        assertNotNull(a);
    }

    @Test
    public void test_getSecureMD5_success() throws NoSuchAlgorithmException {
        System.out.println("test_StringFun_getSecureMD5_success");

        String a = StringFun.getSecureMD5();
        assertNotNull(a);
        assertThat(a.length(), equalTo(32));
    }

    @Test
    @Parameters({"1, I",
        "17, XVII",
        "79, LXXIX",
        "365, CCCLXV",
        "1983, MCMLXXXIII",
        "2018, MMXVIII",
        "4999, MMMMCMXCIX"
    })
    public void test_toRoman_success(int input, String result) {
        System.out.println("test_StringFun_toRoman_success");

        String a = StringFun.toRoman(input);
        assertThat(a, equalTo(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_toRoman_exception1() {
        System.out.println("test_StringFun_toRoman_exception1");

        String a = StringFun.toRoman(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_toRoman_exception2() {
        System.out.println("test_StringFun_toRoman_exception2");

        String a = StringFun.toRoman(5000);
    }

    @Test
    @Parameters({"resource/hello.txt",
        "resource/test.txt"
    })
    public void test_readTextFile_success(String input) throws URISyntaxException, IOException {
        System.out.println("test_StringFun_readTextFile_success");

        String a = StringFun.readTextFile(input);
        assertNotNull(a);
    }

    Object[] fromFileSizeParam() {
        return new Object[]{
            new Object[]{-1L, ""},
            new Object[]{0L, "0 B"},
            new Object[]{700L, "700 B"},
            new Object[]{1024L, "1 KB"},
            new Object[]{27648L, "27 KB"},
            new Object[]{1048576L, "1 MB"},
            new Object[]{75254592L, "72 MB"},
            new Object[]{950000000L, "906 MB"},
            new Object[]{1073741824L, "1 GB"},
            new Object[]{134217728000L, "125 GB"},
            new Object[]{1099511628000L, "1 TB"},
            new Object[]{8796093022208L, "8 TB"},
            new Object[]{1098412116000000L, "999 TB"},};
    }

    @Test
    @Parameters(method = "fromFileSizeParam")
    public void test_fromFileSize_success(long fileSize, String result) {
        System.out.println("test_StringFun_fromFileSize_success");

        String a = StringFun.fromFileSize(fileSize);
        assertThat(a, equalTo(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_fromFileSize_exception() {
        System.out.println("test_StringFun_fromFileSize_exception");

        String a = StringFun.fromFileSize(1098412116000001L);
    }

    @Test
    public void test_elapsedTime_success() {
        System.out.println("test_StringFun_elapsedTime_success");

        String a = StringFun.elapsedTime(1525896600000L, 1525924550000L);
        assertNotNull(a);
        assertTrue(a.length() > 0);

        Date dA1 = DateFun.of(2018, 5, 10, 3, 10, 0);
        Date dA2 = DateFun.of(2018, 7, 10, 5, 12, 50);
        String b = StringFun.elapsedTime(dA1, dA2);
        assertNotNull(b);
        assertTrue(b.length() > 0);
    }

    @Test(expected = NullPointerException.class)
    public void test_elapsedTime_exception() {
        System.out.println("test_StringFun_elapsedTime_exception");

        String a = StringFun.elapsedTime(null, null);
    }
}
