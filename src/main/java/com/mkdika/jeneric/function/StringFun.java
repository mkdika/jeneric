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

/**
 * This class is collection of all java.lang.String return functions.
 * 
 * @author Maikel Chandika <mkdika@gmail.com>
 * @since 2018-04-28
 */
public final class StringFun {
    
    /*
        To prevent class from instanate from outside.
    */
    private StringFun() {        
    }
    
    /**
     * Function to return string with given length of left padded character.<br>
     * Example: <br>
     * - lpad("12",5,'0') will return "00012"<br>
     * - lpad("345,4,'X') will return "X345"<br>
     * - lpad("XY",0,'0') will return "XY"<br>
     * 
     * @param str Current String to be padded.
     * @param paddingLen Total String length to be return. If padding length < Str length,
     *                   then Str is the return.
     * @param paddingChar Character to be used for left padding.
     * @return java.lang.String
    */
    public static String lpad(String str, int paddingLen, char paddingChar) {
        StringBuilder spad = new StringBuilder();        
        for (int i = (str.length()+1); i <= paddingLen; i++) {
            spad.append(paddingChar);
        }
        spad.append(str);
        return spad.toString();
    }   
}
