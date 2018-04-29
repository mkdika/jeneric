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
