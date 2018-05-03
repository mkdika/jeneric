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
 * All of this class static method will return {@link boolean} or {@link java.lang.Boolean}
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 * @since 2018-04-28
 */
public final class BooleanFun {      
                
    /*
        To prevent class from instanate from outside.
     */
    private BooleanFun() {        
    }
    
    /**
     * Function to check whether 2 given range of date are overlaps
     * <p>     
     * Example: <br>
     * - "2018-01-01","2018-01-20","2018-01-10","2018-01-15" is return true
     * - "2018-01-01","2018-01-20","2018-01-21","2018-01-25" is return false
     *     
     * @param startDate1 start date of date range 1
     * @param endDate1 end date of date range 1
     * @param startDate2 start date of date range 2
     * @param endDate2 end date of date range 2
     * @return {@link boolean}
     * @see java.util.Date Date
     * @see java.time.LocalDateTime LocalDateTime
     */
    public static boolean isDateOverlap(Date startDate1, Date endDate1, Date startDate2, Date endDate2){
        if ((endDate1.compareTo(startDate1) < 0)||(endDate2.compareTo(startDate2) < 0)) {
            throw new IllegalArgumentException("End date must be equals or greater than start date.");
        }                
        return ((startDate1.compareTo(endDate2) == 0 || startDate1.compareTo(endDate2) < 0)) && ((startDate2.compareTo(endDate1) == 0) || (startDate2.compareTo(endDate1) < 0));        
    }
    
    // TODO: finish BooleanFun.isStringContains javadoc
    public static boolean isStringContains(String str,String ... strToCheck) {
        return isStringContains(str, Arrays.asList(strToCheck));
    }
    
    // TODO: finish BooleanFun.isStringContains javadoc
    public static boolean isStringContains(String str,Collection<String> strToCheck) {
        if (str == null || str.trim().isEmpty() || strToCheck == null ||  strToCheck.size() < 1) {
            return false;
        }
        Set<String> sets = new HashSet<>();
        sets.addAll(strToCheck);        
        return sets.contains(str);
    }       
    
    // TODO: finish BooleanFun.nvl javadoc
    static boolean nvl(Boolean bool) {
        return (bool == null? Boolean.FALSE:bool);
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
    public static boolean isStringMatch(String str,String regexPattern) {
        if (str == null) return false;
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
}
