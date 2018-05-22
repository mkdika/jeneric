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
 * All of this class static method will return {@link boolean} or
 * {@link java.lang.Boolean}
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
     * Function to check whether 2 given range of date are overlaps
     * <p>
     * Example: <br>
     * - "2018-01-01","2018-01-20","2018-01-10","2018-01-15" is return true -
     * "2018-01-01","2018-01-20","2018-01-21","2018-01-25" is return false
     *
     * @param startDate1 start date of date range 1
     * @param endDate1 end date of date range 1
     * @param startDate2 start date of date range 2
     * @param endDate2 end date of date range 2
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
     * Function to check wheter the array of String is contains the search string
     * <p>
     * If array is null or array is empty, it will return false.<br>
     * See {@link com.mkdika.jeneric.function.BooleanFun#isStringContains(String,Collection)}
     * 
     * @param searchStr search string
     * @param arrayToSearch array to search with.
     * @return {@link boolean}
     */
    public static boolean isStringContains(String searchStr, String[] arrayToSearch) {
        return isStringContains(searchStr, Arrays.asList(arrayToSearch));
    }

    /**
     * Function to check wheter the collection of String is contains the search string
     * <p>
     * If array is null or array is empty, it will return false.
     * 
     * @param searchStr search string
     * @param arrayToSearch array to search with.
     * @return {@link boolean}
     */
    public static boolean isStringContains(String searchStr, Collection<String> arrayToSearch) {
        if (searchStr == null || searchStr.trim().isEmpty() || arrayToSearch == null || arrayToSearch.size() < 1) {
            return false;
        }
        Set<String> sets = new HashSet<>(arrayToSearch);        
        return sets.contains(searchStr);
    }

    /**
     * Null Value Logic (NVL)
     * <p>
     * If bool is null, it will return false.
     *
     * @param bool input parameter to check.
     * @return {@link boolean}
     */
    static boolean nvl(Boolean bool) {
        return (bool == null ? Boolean.FALSE : bool);
    }

    //TODO: finish BooleanFun.isStringContainNumeric javadoc
    public static boolean isStringContainNumeric(String str) {
        return isStringMatch(str, "\\d");
    }

    //TODO: finish BooleanFun.isStringContainAlphabet javadoc
    public static boolean isStringContainAlphabet(String str) {
        return isStringMatch(str, "[a-zA-Z]");
    }

    //TODO: finish BooleanFun.isStringMatch javadoc
    public static boolean isStringMatch(String str, String regexPattern) {
        if (str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    //TODO: finish BooleanFun.isDoubleFractional javadoc
    public static boolean isDoubleFractional(Double d) {
        Double fractionalPart = (d % 1);
        return Double.compare(0d, fractionalPart) < 0;
    }

    //TODO: finish BooleanFun.isPalindrome javadoc
    static boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }

    //TODO: finish BooleanFun.isPrime javadoc
    public static boolean isPrime(int i) {
        return isPrime(i, 1);
    }

    public static boolean isPrime(long l, int certainty) {
        BigInteger bi = BigInteger.valueOf(l);
        return bi.isProbablePrime(certainty);
    }

    //TODO: finish BooleanFun.isValidIpV4Address javadoc
    public static boolean isValidIpV4Address(String ipV4Address) {
        return isStringMatch(ipV4Address, IPV4_ADDRESS_PATTERN);
    }

    //TODO: finish BooleanFun.isValidMacAddress javadoc
    public static boolean isValidMacAddress(String macAddress) {
        return isStringMatch(macAddress, "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");
    }

}
