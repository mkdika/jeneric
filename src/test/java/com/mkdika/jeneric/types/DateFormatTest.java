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
