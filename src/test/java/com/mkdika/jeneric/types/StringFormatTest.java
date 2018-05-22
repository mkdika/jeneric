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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
public class StringFormatTest {
    
    @Before
    public void setup() {
    }
           
    @Test
    public void test_StringFormat_values() {
        System.out.println("test_StringFormat_values");        
        assertTrue(StringFormat.values().length > 0);                
    }
    
    @Test
    public void test_StringFormat_valueOf() {
        System.out.println("test_StringFormat_valueOf");        
        
        assertThat(StringFormat.valueOf("MAC_ADDRESS_FORMAT"), equalTo(StringFormat.MAC_ADDRESS_FORMAT));
    }
    
}
