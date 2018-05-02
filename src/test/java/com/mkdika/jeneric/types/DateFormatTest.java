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
package com.mkdika.jeneric.types;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class DateFormatTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_dateFormat_formatter() {
        System.out.println("test_DateFormat_formatter");

        LocalDateTime dt = LocalDateTime.of(2018, Month.FEBRUARY, 28, 23, 59, 59); // 28 Feb 2018 23:59:59
        long epoch = dt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Date date = new Date(epoch);

        SimpleDateFormat dateFormatFixture = new SimpleDateFormat();

        dateFormatFixture.applyPattern(DateFormat.DEFAULT.getFormat());
        assertThat(dateFormatFixture.format(date), equalTo("2018-02-28.23:59:59"));
        
        dateFormatFixture.applyPattern(DateFormat.ISO_LOCAL_DATE.getFormat());
        assertThat(dateFormatFixture.format(date), equalTo("2018-02-28"));
        
        dateFormatFixture.applyPattern(DateFormat.ISO_LOCAL_TIME.getFormat());
        assertThat(dateFormatFixture.format(date), equalTo("23:59:59"));                
        
        dateFormatFixture.applyPattern(DateFormat.BASIC_ISO_DATE_TIME.getFormat());
        assertThat(dateFormatFixture.format(date), equalTo("20180228235959"));
        
        dateFormatFixture.applyPattern(DateFormat.BASIC_DATE.getFormat());
        assertThat(dateFormatFixture.format(date), equalTo("28 Feb 2018"));
        
        dateFormatFixture.applyPattern(DateFormat.BASIC_DATE_TIME.getFormat());
        assertThat(dateFormatFixture.format(date), equalTo("28 Feb 2018 23:59:59"));
    }        
    
    @Test
    public void test_dateFormat_values() {
        System.out.println("test_DateFormat_values");        
        assertTrue(DateFormat.values().length > 0);                
    }
    
    @Test
    public void test_dateFormat_valueOf() {
        System.out.println("test_DateFormat_valueOf");        
        
        assertThat(DateFormat.valueOf("DEFAULT"), equalTo(DateFormat.DEFAULT));
    }        
}
