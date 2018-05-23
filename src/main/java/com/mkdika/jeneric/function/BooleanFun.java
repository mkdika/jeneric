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

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is collection of all boolean return functions.
 *
 * All static method may return {@link boolean}, {@link java.lang.Boolean} or
 * Array/Collection of {@link java.lang.Boolean}.
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 * @since 2018-04-28
 */
public final class BooleanFun {

    private static final String IPV4_ADDRESS_PATTERN
            = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    /*
        To prevent class from instanate from outside.
     */
    private BooleanFun() {
    }

    /**
     * Check whether given two range of date are overlaps
     * <p>
     * Example: <br>
     * - "2018-01-01","2018-01-20","2018-01-10","2018-01-15" is return true -
     * "2018-01-01","2018-01-20","2018-01-21","2018-01-25" is return false
     *
     * @param startDate1 start date of date range 1.
     * @param endDate1 end date of date range 1.
     * @param startDate2 start date of date range 2.
     * @param endDate2 end date of date range 2.
     * @return {@link boolean}
     * @see java.util.Date Date
     * @see java.time.LocalDateTime LocalDateTime
     */
    public static boolean isDateOverlap(Date startDate1, Date endDate1, Date startDate2, Date endDate2) {
        if ((endDate1.compareTo(startDate1) < 0) || (endDate2.compareTo(startDate2) < 0)) {
            throw new IllegalArgumentException("End date must be equals or greater than start date.");
        }
        return ((startDate1.compareTo(endDate2) <= 0) && (startDate2.compareTo(endDate1) <= 0));
    }

    /**
     * Check wheter the array of String is contains the search string
     * <p>
     * If array is <b>null</b> or <b>empty</b>, it will return <b>false</b>.<br>
     * See
     * {@link com.mkdika.jeneric.function.BooleanFun#isStringContains(String,Collection)}
     *
     * @param searchStr search string.
     * @param arrayToSearch array to search with.
     * @return {@link boolean}
     */
    public static boolean isStringContains(String searchStr, String[] arrayToSearch) {
        return isStringContains(searchStr, Arrays.asList(arrayToSearch));
    }

    /**
     * Check wheter the collection of String is contains the search string.
     * <p>
     * If collection is <b>null</b> or <b>empty</b>, it will return
     * <b>false</b>.<br>
     *
     * @param searchStr search string.
     * @param arrayToSearch array to search with.
     * @return {@link boolean}
     */
    public static boolean isStringContains(String searchStr, Collection<String> arrayToSearch) {
        if (searchStr != null && !searchStr.trim().isEmpty() && arrayToSearch != null && arrayToSearch.size() > 0) {
            Set<String> sets = new HashSet<>(arrayToSearch);
            return sets.contains(searchStr);
        }
        return false;
    }

    /**
     * Null Value Logic (NVL) or Denullify.
     * <p>
     * If argument is <b>null</b>, it will return <b>false</b>.
     *
     * @param bool input argument to check.
     * @return {@link boolean}
     */
    public static boolean nvl(Boolean bool) {
        return (bool == null ? Boolean.FALSE : bool);
    }

    /**
     * Check whether given String argument value is contains a numeric
     * character.
     * <p>
     * If argument is <b>null</b>, it will return <b>false</b>
     *
     * @param str input argument to check.
     * @return {@link boolean}
     */
    public static boolean isStringContainNumeric(String str) {
        return isStringMatch(str, "\\d");
    }

    /**
     * Check whether given String argument value is contains a alphabet
     * character.
     * <p>
     * If argument is <b>null</b>, it will return <b>false</b>
     *
     * @param str input argument to check.
     * @return {@link boolean}
     */
    public static boolean isStringContainAlphabet(String str) {
        return isStringMatch(str, "[a-zA-Z]");
    }

    /**
     * Check whether given String argument value is match to given regex
     * pattern.
     * <p>
     * If argument is <b>null</b>, it will return <b>false</b>
     *
     * @param str input argument to check.
     * @param regexPattern regular expression pattern to match with.
     * @return {@link boolean}
     */
    public static boolean isStringMatch(String str, String regexPattern) {
        if (str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    /**
     * Check whether given Double argument value is have fractional (decimal)
     * element.
     *
     * @param number input argument to check.
     * @return {@link boolean}
     */
    public static boolean isDoubleFractional(Double number) {
        Double fractionalPart = (number % 1);
        return Double.compare(0d, fractionalPart) < 0;
    }

    /**
     * Check whether given String argument value is palindrome or not.
     * <p>
     * Comparisson character will be compare as <b>case sensitive</b>.
     *
     * @param str input argument to check.
     * @return {@link boolean}
     */
    static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }

    /**
     * Check whether given Integer argument value is probably prime number.
     * <p>
     * see {@link com.mkdika.jeneric.function.BooleanFun#isPrime(long, int)}
     *
     * @param number input argument to check
     * @return {@link boolean}
     */
    public static boolean isPrime(int number) {
        return isPrime(number, 1);
    }

    /**
     * Check whether given Integer argument value is probably prime number.
     *
     * @param number input argument to check
     * @param certainty a measure of the uncertainty that the caller is willing
     * to tolerate
     * @return {@link boolean}
     * @see java.math.BigInteger#isProbablePrime(int)
     */
    public static boolean isPrime(long number, int certainty) {
        BigInteger bi = BigInteger.valueOf(number);
        return bi.isProbablePrime(certainty);
    }

    /**
     * Check whether given IP v4 Address is valid.
     * <p>
     * If argument is <b>null</b>, it will return <b>false</b>
     *
     * @param ipV4Address input argument to check
     * @return {@link boolean}
     * @see
     * com.mkdika.jeneric.function.BooleanFun#isStringMatch(java.lang.String,
     * java.lang.String)
     */
    public static boolean isValidIpV4Address(String ipV4Address) {
        return isStringMatch(ipV4Address, IPV4_ADDRESS_PATTERN);
    }

    /**
     * Check whether given Mac (physical) address is valid.
     * <p>
     * If argument is <b>null</b>, it will return <b>false</b>
     *
     * @param macAddress input argument to check
     * @return {@link boolean}
     * @see
     * com.mkdika.jeneric.function.BooleanFun#isStringMatch(java.lang.String,
     * java.lang.String)
     */
    public static boolean isValidMacAddress(String macAddress) {
        return isStringMatch(macAddress, "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");
    }

}
