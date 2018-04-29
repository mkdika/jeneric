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

import java.util.Date;

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
}
