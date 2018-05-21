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

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
public enum DateFormat {
    /**
     * Pattern: <b>yyyy-MM-dd.HH:mm:ss</b>
     */
    DEFAULT("yyyy-MM-dd.HH:mm:ss"),
    /**
     * Pattern: <b>yyyy-MM-dd</b>
     */
    ISO_LOCAL_DATE("yyyy-MM-dd"), 
    /**
     * Pattern: <b>HH:mm:ss</b>
     */
    ISO_LOCAL_TIME("HH:mm:ss"),    
    /**
     * Pattern: <b>yyyyMMddHHmmss</b>
     */
    BASIC_ISO_DATE_TIME("yyyyMMddHHmmss"),
    /**
     * Pattern: <b>dd MMM yyyy</b>
     */
    BASIC_DATE("dd MMM yyyy"),
    /**
     * Pattern: <b>dd MMM yyyy HH:mm:ss</b>
     */
    BASIC_DATE_TIME("dd MMM yyyy HH:mm:ss");
    
    private final String format;

    private DateFormat(String format) {
        this.format = format;
    }  

    public String getFormat() {
        return format;
    }        
}
