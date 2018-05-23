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
 * This class is collection of all String return functions.
 *
 * All static method may return {@link java.lang.String} or Array/Collection of
 * {@link java.lang.String}.
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
     * To return String with given length of left padded character.
     * <p>
     * If padding length less than String length, then return the orginal
     * Str.<br>
     * If Str is empty and padding length greater than 0, then return padding
     * character.<br><br>
     *
     * Example: <br>
     * <ul>
     * <li>lpad("12",5,'0') will return "00012"</li>
     * <li>lpad("345,4,'X') will return "X345"</li>
     * <li>lpad("XY",0,'0') will return "XY"</li>
     * <li>rpad("",4,'X') will return "XXXX"</li>
     * </ul>
     *
     * @param str Current String to be padded.
     * @param paddingLen Total String length to be return.
     * @param paddingChar Character to be used for left padding.
     * @return {@link java.lang.String}
     */
    public static String lpad(String str, int paddingLen, char paddingChar) {
        StringBuilder spad = new StringBuilder();
        for (int i = (str.length() + 1); i <= paddingLen; i++) {
            spad.append(paddingChar);
        }
        spad.append(str);
        return spad.toString();
    }

    /**
     * To return String with given length to be left padded.
     * <p>
     * This will use <b>white-space</b> as the default left padding
     * character.<br>
     * See
     * {@link com.mkdika.jeneric.function.StringFun#lpad(java.lang.String, int, char)}
     *
     * @param str Current String to be padded.
     * @param paddingLen Total String length to be return.
     * @return {@link java.lang.String}
     */
    public static String lpad(String str, int paddingLen) {
        return lpad(str, paddingLen, ' ');
    }

    /**
     * To return String with given length of right padded character.
     * <p>
     * If padding length less than String length, then return the orginal
     * Str.<br>
     * If Str is empty and padding length greater than 0, then return padding
     * character.<br><br>
     *
     * Example: <br>
     * <ul>
     * <li>rpad("12",5,'0') will return "12000"</li>
     * <li>rpad("345,4,'X') will return "345X"</li>
     * <li>rpad("XY",0,'0') will return "XY"</li>
     * <li>rpad("",4,'X') will return "XXXX"</li>
     * </ul>
     *
     * @param str Current String to be padded.
     * @param paddingLen Total String length to be return.
     * @param paddingChar Character to be used for right padding.
     * @return {@link java.lang.String}
     */
    public static String rpad(String str, int paddingLen, char paddingChar) {
        StringBuilder spad = new StringBuilder(str);
        for (int i = (str.length() + 1); i <= paddingLen; i++) {
            spad.append(paddingChar);
        }
        return spad.toString();
    }

    /**
     * To return String with given length to be right padded.
     * <p>
     * This will use <b>white-space</b> as the default right padding
     * character.<br>
     * See
     * {@link com.mkdika.jeneric.function.StringFun#rpad(java.lang.String, int, char)}
     *
     * @param str Current String to be padded.
     * @param paddingLen Total String length to be return.
     * @return {@link java.lang.String}
     */
    public static String rpad(String str, int paddingLen) {
        return rpad(str, paddingLen, ' ');
    }

    /**
     * To return string with given java.util.Date and with(out) format pattern.
     * <p>
     * See {@link com.mkdika.jeneric.function.StringFun#fromDate(Date,String)}
     * with default date format pattern
     * {@link com.mkdika.jeneric.types.DateFormat#DEFAULT}
     *
     * @param date given date to format
     * @return {@link java.lang.String}
     * @see com.mkdika.jeneric.types.DateFormat#DEFAULT Default Patttern
     */
    public static String fromDate(Date date) {
        return fromDate(date, DateFormat.DEFAULT);
    }

    /**
     * To return string with given java.util.Date and with(out) format pattern.
     * <p>
     * See {@link com.mkdika.jeneric.function.StringFun#fromDate(Date,String)}
     *
     * @param date given date to format
     * @param pattern pattern for formatting the date from
     * {@link com.mkdika.jeneric.types.DateFormat}
     * @return {@link java.lang.String}
     * @see com.mkdika.jeneric.types.DateFormat#DEFAULT Default Patttern
     */
    public static String fromDate(Date date, DateFormat pattern) {
        return fromDate(date, pattern.getFormat());
    }

    /**
     * To return string with given java.util.Date and with(out) format pattern.
     * <p>
     * Example:<br>
     * - fromDate(date,"dd MMM yyy") will return "22 May 2018"
     *
     * @param date given date to format
     * @param pattern pattern for formatting the date
     * @return {@link java.lang.String}
     */
    public static String fromDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * Null Value Logic (NVL) or Denullify.
     * <p>
     * If argument is <b>null</b>, it will return <b>empty String</b>.
     *
     * @param str input argument to check.
     * @return {@link java.lang.String}
     */
    public static String nvl(String str) {
        return (str == null ? "" : str);
    }

    /**
     * To return LEFT substring of given String.
     * <p>
     * If String length is less than or equal to substring length, it will
     * return original String.<br>
     * <br>
     * Example:<br>
     * <ul>
     * <li>left("Apple",3), will return "App"</li>
     * <li>left("grape",6), will return "grape"</li>
     * <li>left("grape",-1), will return <b>empty</b></li>
     * </ul>
     *
     * @param str input String to be substring.
     * @param length length of character to be substring.
     * @return {@link java.lang.String}
     */
    public static String left(String str, int length) {
        int n = length;
        if (length > str.length()) {
            n = str.length();
        }else if (length < 0) {
            n = 0;
        }
        return str.substring(0, n);
    }

    /**
     * To return RIGHT substring of given String.
     * <p>
     * If String length is less than or equal to substring length, it will
     * return original String.<br>
     * <br>
     * Example:<br>
     * <ul>
     * <li>right("Chandika",4), will return "dika"</li>
     * <li>right("grape",6), will return "grape"</li>
     * <li>right("grape",-1), will return <b>empty</b></li>
     * </ul>
     *
     * @param str input String to be substring.
     * @param length length of character to be substring.
     * @return {@link java.lang.String}
     */
    public static String right(String str, int length) {
        int n = length;
        if (length > str.length()) {
            n = str.length();
        } else if (length < 0) {
            n = 0;
        }
        return str.substring(str.length() - n, str.length());
    }

    /**
     * To return MIDDLE substring of given String.
     * <p>
     * Example:<br>
     * <ul>
     * <li>middle("Chandika",2,4), will return "andi"</li>
     * <li>middle("grape",6,4), will return <b>empty</b></li>
     * <li>middle("grape",-1,3), will return <b>empty</b></li>
     * </ul>
     *
     * @param str input String to be substring.
     * @param startIndex starting index of substring.
     * @param length length of character to be substring.
     * @return {@link java.lang.String}
     * @see java.lang.String#substring(int, int)
     */
    public static String middle(String str, int startIndex, int length) {
        int n = length;
        if (startIndex >= str.length()) {
            startIndex = str.length();
            n = 0;
        }
        if (startIndex < 0) {
            startIndex = 0;
            n = 0;
        }
        return str.substring(startIndex, startIndex + n);
    }

    /**
     * To return LEFT trimmed of given String.
     * <p>
     * Example:<br>
     * <ul>
     * <li>leftTrim("Chandika",4), will return "dika"</li>
     * <li>leftTrim("grape",6), will return <b>empty</b></li>
     * <li>leftTrim("grape",-1), will return <b>empty</b></li>
     * </ul>
     *
     * @param str input String to be trim
     * @param length lenght of character to be trim
     * @return {@link java.lang.String}
     */
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

    /**
     * To return RIGHT trimmed of given String.
     * <p>
     * Example:<br>
     * <ul>
     * <li>rightTrim("Chandika",4), will return "Chan"</li>
     * <li>rightTrim("grape",6), will return <b>empty</b></li>
     * <li>rightTrim("grape",-1), will return <b>empty</b></li>
     * </ul>
     *
     * @param str input String to be trim
     * @param length lenght of character to be trim
     * @return {@link java.lang.String}
     */
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

    /**
     * To return Set of IP v4 Address from the current machine.
     *
     * @return {@link java.util.Set}
     * @throws SocketException if current machine does not have active network
     * interface.
     */
    public static Set<String> getIpV4Address() throws SocketException {
        return Collections.list(NetworkInterface.getNetworkInterfaces()).stream()
                .flatMap(i -> Collections.list(i.getInetAddresses()).stream())
                .filter(ip -> ip instanceof Inet4Address && ip.isSiteLocalAddress())
                .map(n -> n.getHostAddress())
                .collect(Collectors.toSet());
    }

    /**
     * To return Set of Mac (Physical) Address from the current machine.
     *
     * @return {@link java.util.Set}
     * @throws SocketException if current machine does not have active network
     * physical address.
     */
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

    /**
     * To return random number of UUID version 4.
     * <p>
     * Alphabet character will be in lower-case character.
     *
     * @return {@link java.lang.String}
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * To return MD5 from random value.
     * <p>
     * Alphabet character will be in lower-case character. Encoder: <b>UTF-8</b>
     *
     * @return {@link java.lang.String}
     * @throws NoSuchAlgorithmException if related hashing algorithms does not
     * support by Hash Generator.
     * @see com.mkdika.jeneric.function.StringFun#getUUID()
     */
    public static String getSecureMD5() throws NoSuchAlgorithmException {
        return toMd5(getUUID());
    }

    /**
     * To return MD5 from given plain text.
     * <p>
     * Alphabet character will be in lower-case character. Encoder: <b>UTF-8</b>
     *
     * @param plainText input plain text to be hash.
     * @return {@link java.lang.String}
     * @throws NoSuchAlgorithmException if related hashing algorithms does not
     * support by Hash Generator.
     * @see com.mkdika.jeneric.function.StringFun#toHashing(java.lang.String,
     * java.lang.String)
     */
    public static String toMd5(String plainText) throws NoSuchAlgorithmException {
        return toHashing(plainText, "MD5");
    }

    /**
     * To return SHA from given plain text.
     * <p>
     * Alphabet character will be in lower-case character. Encoder: <b>UTF-8</b>
     *
     * @param plainText input plain text to be hash.
     * @return {@link java.lang.String}
     * @throws NoSuchAlgorithmException if related hashing algorithms does not
     * support by Hash Generator.
     * @see com.mkdika.jeneric.function.StringFun#toHashing(java.lang.String,
     * java.lang.String)
     */
    public static String toSha(String plainText) throws NoSuchAlgorithmException {
        return toHashing(plainText, "SHA");
    }

    /**
     * To return SHA-256 from given plain text.
     * <p>
     * Alphabet character will be in lower-case character. Encoder: <b>UTF-8</b>
     *
     * @param plainText input plain text to be hash.
     * @return {@link java.lang.String}
     * @throws NoSuchAlgorithmException if related hashing algorithms does not
     * support by Hash Generator.
     * @see com.mkdika.jeneric.function.StringFun#toHashing(java.lang.String,
     * java.lang.String)
     */
    public static String toSha256(String plainText) throws NoSuchAlgorithmException {
        return toHashing(plainText, "SHA-256");
    }

    /**
     * To return SHA-512 from given plain text.
     * <p>
     * Alphabet character will be in lower-case character. Encoder: <b>UTF-8</b>
     *
     * @param plainText input plain text to be hash.
     * @return {@link java.lang.String}
     * @throws NoSuchAlgorithmException if related hashing algorithms does not
     * support by Hash Generator.
     * @see com.mkdika.jeneric.function.StringFun#toHashing(java.lang.String,
     * java.lang.String)
     */
    public static String toSha512(String plainText) throws NoSuchAlgorithmException {
        return toHashing(plainText, "SHA-512");
    }

    /**
     * To return Hash cipher text from given plain text and algorithms.
     * <p>
     * Alphabet character will be in lower-case character. Encoder: <b>UTF-8</b>
     *
     * @param plainText input plain text to be hash.
     * @param algorithm input the hashing algorithms
     * @return {@link java.lang.String}
     * @throws NoSuchAlgorithmException if related hashing algorithms does not
     * support by Hash Generator.
     */
    private static String toHashing(String plainText, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(plainText.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }

    /**
     * To return Roman Numerals from given integer.
     * <p>
     * Allowed range is from <b>1 - 4999</b>.
     *
     * @param number input number to be converted.
     * @return {@link java.lang.String}
     */
    public static String toRoman(int number) {
        if (number < 1 || number > 4999) {
            throw new IllegalArgumentException("toRoman accept range must be in 1..4999");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RCODE.length; i++) {
            while (number >= BVAL[i]) {
                number -= BVAL[i];
                sb.append(RCODE[i]);
            }
        }
        return sb.toString();
    }

    /**
     * To return String of text file content base on file location.
     *
     * @param filePath location of the text file.
     * @return {@link java.lang.String}
     * @throws URISyntaxException if any error with class path.
     * @throws IOException if related file can not be access.
     */
    public static String readTextFile(String filePath) throws URISyntaxException, IOException {
        Path path = Paths.get(filePath);
        byte[] fileBytes = Files.readAllBytes(path);
        return new String(fileBytes);
    }

    /**
     * To return a human readable file size UOM (B,KB,MB,GB,TB) base on given
     * size (long).
     * <p>
     * Allowed file size range is from <b>0 B - 999 TB</b><br>
     * <br>
     * Example: <b>950000000</b> will return <b>906 MB</b>
     *
     * @param fileSize the file size to be process
     * @return {@link java.lang.String}
     */
    public static String fromFileSize(long fileSize) {
        if (fileSize > 1098412116000000L) {
            throw new IllegalArgumentException("File size can not more than 999 TB.");
        }

        BigDecimal k = new BigDecimal(1024);
        StringBuilder sb = new StringBuilder();
        if (fileSize >= 0L && fileSize < 1024L) { // B
            sb.append(fileSize).append(" B").toString();
        } else if (fileSize >= 1024L && fileSize < 1048576L) {  // KB            
            BigDecimal n = new BigDecimal(fileSize);
            BigDecimal r = n.divide(k, RoundingMode.HALF_UP);
            sb.append(String.valueOf(r.longValueExact())).append(" KB").toString();
        } else if (fileSize >= 1048576L && fileSize < 1073741824L) { // MB
            BigDecimal n = new BigDecimal(fileSize);
            BigDecimal r = n.divide(k, RoundingMode.HALF_UP).divide(k, RoundingMode.HALF_UP);
            sb.append(String.valueOf(r.longValueExact())).append(" MB").toString();
        } else if (fileSize >= 1073741824L && fileSize < 1099511628000L) { // GB
            BigDecimal n = new BigDecimal(fileSize);
            BigDecimal r = n.divide(k, RoundingMode.HALF_UP)
                    .divide(k, RoundingMode.HALF_UP)
                    .divide(k, RoundingMode.HALF_UP);
            sb.append(String.valueOf(r.longValueExact())).append(" GB").toString();
        } else if (fileSize >= 1099511628000L) { // TB
            BigDecimal n = new BigDecimal(fileSize);
            BigDecimal r = n.divide(k, RoundingMode.HALF_UP)
                    .divide(k, RoundingMode.HALF_UP)
                    .divide(k, RoundingMode.HALF_UP)
                    .divide(k, RoundingMode.HALF_UP);
            sb.append(String.valueOf(r.longValueExact())).append(" TB").toString();
        }
        return sb.toString();
    }

    /**
     * To return information (String) of elapsed time between two
     * {@link java.util.Date}.
     * <p>
     * See {@link com.mkdika.jeneric.function.StringFun#elapsedTime(long, long)}
     *
     * @param startDate input startDate (timestamp).
     * @param endDate input endDate (timestamp).
     * @return {@link java.lang.String}
     */
    public static String elapsedTime(Date startDate, Date endDate) {
        return elapsedTime(startDate.getTime(), endDate.getTime());
    }

    /**
     * To return information (String) of elapsed time between two timestamp.
     * <p>
     * Example:<br>
     * given: <br>
     * date1 = 10 May 2018 03:10:00<br>
     * date2 = 10 Jul 2018 05:12:50<br>
     * will return: 61 days 2 hours 2 minutes 50 seconds 0 milliseconds
     *
     * @param startTime input the startTime (numbers of milliseconds)
     * @param endTime input the endTime (numbers of milliseconds)
     * @return {@link java.lang.String}
     */
    public static String elapsedTime(long startTime, long endTime) {
        TimePeriod period = ObjectFun.calculatePeriod(startTime, endTime);
        StringBuilder sb = new StringBuilder();
        sb.append(period.getDays()).append(" days ");
        sb.append(period.getHours()).append(" hours ");
        sb.append(period.getMinutes()).append(" minutes ");
        sb.append(period.getSeconds()).append(" seconds ");
        sb.append(period.getMilliseconds()).append(" milliseconds");
        return sb.toString();
    }
}
