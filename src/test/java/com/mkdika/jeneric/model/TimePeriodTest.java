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
package com.mkdika.jeneric.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class TimePeriodTest {
    
    @Test
    public void test_class_TimePeriod() {
        System.out.println("test_class_TimePeriod_creation");
        
        TimePeriod period = new TimePeriod(15,3,10,30,100);
        
        assertNotNull(period);
        assertThat(period.getDays(), equalTo(15L));
        assertThat(period.getHours(), equalTo(3L));
        assertThat(period.getMinutes(), equalTo(10L));
        assertThat(period.getSeconds(), equalTo(30L));
        assertThat(period.getMilliseconds(), equalTo(100L));     
        
        assertTrue(!period.toString().isEmpty());
    }
    
}
