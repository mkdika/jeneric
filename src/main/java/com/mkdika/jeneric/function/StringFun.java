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
import com.mkdika.jeneric.types.StringFormat;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.Inet4Address;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.xml.bind.DatatypeConverter;

/**
 * This class is collection of all java.lang.String return functions.
 *
 * All of this class static method will return {@link java.lang.String}
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 * @since 2018-04-28
 */
public final class StringFun {

    private static final String[] RCODE = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] BVAL = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /*
        To prevent class from instanate from outside.
     */
    private StringFun() {
    }

    /**
     * Function to return string with given length of left padded character.
     * <p>
     * If padding length less than String length, then return the orginal
     * Str.<br>
     * If Str is empty and padding length greater than 0, then return padding
     * character.<br><br>
     *
     * Example: <br>
     * - lpad("12",5,'0') will return "00012"<br>
     * - lpad("345,4,'X') will return "X345"<br>
     * - lpad("XY",0,'0') will return "XY"
     *
     * @param str Current String to be padded.
     * @param paddingLen Total String length to be return. If padding length
     * less than Str length, then Str is the return.
     * @param paddingChar Character to be used for left padding.
     * @return {@link java.lang.String}
     *
     */
    public static String lpad(String str, int paddingLen, char paddingChar) {
        StringBuilder spad = new StringBuilder();
        for (int i = (str.length() + 1); i <= paddingLen; i++) {
            spad.append(paddingChar);
        }
        spad.append(str);
        return spad.toString();
    }

    //TODO: finish StringFun.lpad javadoc
    public static String lpad(String str, int paddingLen) {
        return lpad(str, paddingLen, ' ');
    }

    //TODO: finish StringFun.rpad javadoc
    public static String rpad(String str, int paddingLen, char paddingChar) {
        StringBuilder spad = new StringBuilder(str);
        for (int i = (str.length() + 1); i <= paddingLen; i++) {
            spad.append(paddingChar);
        }
        return spad.toString();
    }

    //TODO: finish StringFun.rpad javadoc
    public static String rpad(String str, int paddingLen) {
        return rpad(str, paddingLen, ' ');
    }

    /**
     * Function to return string with given java.util.Date and with(out) format
     * pattern
     * <p>
     * Work just like
     * {@link com.mkdika.jeneric.function.StringFun#fromDate(Date,String)} with
     * default date format pattern
     * {@link com.mkdika.jeneric.types.DateFormat#DEFAULT}
     *
     * @param date given date to format
     * @return {@link java.lang.String}
     *
     * @see com.mkdika.jeneric.types.DateFormat#DEFAULT Default Patttern
     *
     */
    public static String fromDate(Date date) {
        return fromDate(date, DateFormat.DEFAULT);
    }

    /**
     * Function to return string with given java.util.Date and with(out) format
     * pattern
     * <p>
     * Work just like
     * {@link com.mkdika.jeneric.function.StringFun#fromDate(Date,String)}
     *
     * @param date given date to format
     * @param pattern pattern for formatting the date from
     * {@link com.mkdika.jeneric.types.DateFormat}
     * @return {@link java.lang.String}
     *
     * @see com.mkdika.jeneric.types.DateFormat#DEFAULT Default Patttern
     *
     */
    public static String fromDate(Date date, DateFormat pattern) {
        return fromDate(date, pattern.getFormat());
    }

    /**
     * Function to return string with given java.util.Date and with(out) format
     * pattern
     * <p>
     * Example: <br>
     * - fromDate(date,"dd MMM yyy") will return "22 May 2018"
     *
     * @param date given date to format
     * @param pattern pattern for formatting the date
     * @return {@link java.lang.String}
     *
     */
    public static String fromDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    //TODO: finish StringFun.nvl javadoc
    /**
     * Null Value Logic (NVL)
     *
     * @param str
     * @return {@link java.lang.String}
     */
    public static String nvl(String str) {
        return (str == null ? "" : str);
    }

    //TODO: finish StringFun.left javadoc
    public static String left(String str, int length) {
        int n = length;
        if (length > str.length()) {
            n = str.length();
        }
        if (length < 0) {
            n = 0;
        }
        return str.substring(0, n);
    }

    //TODO: finish StringFun.right javadoc
    public static String right(String str, int length) {
        int n = length;
        if (length > str.length()) {
            n = str.length();
        }
        if (length < 0) {
            n = 0;
        }
        return str.substring(str.length() - n, str.length());
    }

    //TODO: finish StringFun.mid javadoc
    public static String middle(String str, int startIndex, int length) {
        int n = length;
        if (startIndex > str.length()) {
            startIndex = str.length();
            n = 0;
        }
        if (startIndex < 0) {
            startIndex = 0;
            n = 0;
        }
        return str.substring(startIndex, startIndex + n);
    }

    //TODO: finish StringFun.leftTrim javadoc
    public static String leftTrim(String str, int length) {
        int n = length;
        if (length > str.length()) {
            n = str.length();
        }
        if (length < 0) {
            n = 0;
        }
        return str.substring(n);
    }

    //TODO: finish StringFun.rightTrim javadoc
    public static String rightTrim(String str, int length) {
        int n = length;
        if (length > str.length()) {
            n = str.length();
        }
        if (length < 0) {
            n = 0;
        }
        return str.substring(0, str.length() - n);
    }

    //TODO: finish StringFun.getIpAddress javadoc
    public static Set<String> getIpV4Address() throws SocketException {
        return Collections.list(NetworkInterface.getNetworkInterfaces()).stream()
                .flatMap(i -> Collections.list(i.getInetAddresses()).stream())
                .filter(ip -> ip instanceof Inet4Address && ip.isSiteLocalAddress())
                .map(n -> n.getHostAddress())
                .collect(Collectors.toSet());
    }

    //TODO: finish StringFun.getMacAddress javadoc
    public static Set<String> getMacAddress() throws SocketException {
        Set<String> macSet = new HashSet<>();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface network = networkInterfaces.nextElement();
            byte[] mac = network.getHardwareAddress();
            if (mac != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format(StringFormat.MAC_ADDRESS_FORMAT.getFormat(), mac[i], (i < mac.length - 1) ? ":" : ""));
                }
                macSet.add(sb.toString());
            }
        }
        return macSet;
    }

    /*
        TODO: finish  StringFun.getUUID javadoc
        This is used UUID v4 with random number
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    // TODO: finish StringFun.getSecureMD5 javadoc
    public static String getSecureMD5() throws NoSuchAlgorithmException {
        return toMd5(getUUID());
    }

    /*
        TODO: finish StringFun.toMd5 javadoc
        A lower case retun MD5, UTF-8
     */
    public static String toMd5(String plainText) throws NoSuchAlgorithmException {
        return toHashing(plainText, "MD5");
    }

    /*
        TODO: finish StringFun.toSha128 javadoc
        A lower case retun, UTF-8
     */
    public static String toSha(String plain) throws NoSuchAlgorithmException {
        return toHashing(plain, "SHA");
    }

    /*
        TODO: finish StringFun.toSha256 javadoc
        A lower case retun, UTF-8
     */
    public static String toSha256(String plain) throws NoSuchAlgorithmException {
        return toHashing(plain, "SHA-256");
    }

    private static String toHashing(String plain, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(plain.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }

    // TODO: finish StringFun.toRoman javadoc
    // max allowed int range is 1..4999
    public static String toRoman(int n) {
        if (n < 1 || n > 4999) {
            throw new IllegalArgumentException("toRoman accept range must be in 1..4999");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RCODE.length; i++) {
            while (n >= BVAL[i]) {
                n -= BVAL[i];
                sb.append(RCODE[i]);
            }
        }
        return sb.toString();
    }

    // TODO: finish StringFun.readTextFile javadoc
    public static String readTextFile(String filePath) throws URISyntaxException, IOException {
        Path path = Paths.get(filePath);
        byte[] fileBytes = Files.readAllBytes(path);
        return new String(fileBytes);
    }

    // TODO: finish StringFun.fromFileSize javadoc
    // be able to convert from 0 B .. 999 TB
    public static String fromFileSize(long fileSize) {
        BigDecimal k = new BigDecimal(1024);
        StringBuilder sb = new StringBuilder();
        if (fileSize >= 0L && fileSize < 1024L) { // B
            return sb.append(fileSize).append(" B").toString();
        } else if (fileSize >= 1024L && fileSize < 1048576L) {  // KB            
            BigDecimal n = new BigDecimal(fileSize);
            BigDecimal r = n.divide(k, RoundingMode.HALF_UP);
            return sb.append(String.valueOf(r.longValueExact())).append(" KB").toString();
        } else if (fileSize >= 1048576L && fileSize < 1073741824L) { // MB
            BigDecimal n = new BigDecimal(fileSize);
            BigDecimal r = n.divide(k, RoundingMode.HALF_UP).divide(k, RoundingMode.HALF_UP);
            return sb.append(String.valueOf(r.longValueExact())).append(" MB").toString();
        } else if (fileSize >= 1073741824L && fileSize < 1099511628000L) { // GB
            BigDecimal n = new BigDecimal(fileSize);
            BigDecimal r = n.divide(k, RoundingMode.HALF_UP)
                            .divide(k, RoundingMode.HALF_UP)
                            .divide(k, RoundingMode.HALF_UP);
            return sb.append(String.valueOf(r.longValueExact())).append(" GB").toString();
        } else if (fileSize >= 1099511628000L && fileSize <= 1098412116000000L) { // TB
            BigDecimal n = new BigDecimal(fileSize);
            BigDecimal r = n.divide(k, RoundingMode.HALF_UP)
                            .divide(k, RoundingMode.HALF_UP)
                            .divide(k, RoundingMode.HALF_UP)
                            .divide(k, RoundingMode.HALF_UP);
            return sb.append(String.valueOf(r.longValueExact())).append(" TB").toString();
        } else {
            return "";
        }
    }
}
