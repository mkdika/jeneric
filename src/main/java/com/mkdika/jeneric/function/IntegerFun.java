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

/**
 * This class is collection of all int return functions.
 *
 * All static method may return {@link int}, {@link java.lang.Integer} or
 * Array/Collection of {@link java.lang.Integer}.
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 * @since 2018-04-28
 */
public final class IntegerFun {

    /*
        To prevent class from instanate from outside.
     */
    private IntegerFun() {
    }

    
    /**
     * Null Value Logic (NVL) or Denullify.
     * <p>
     * If argument is <b>null</b>, it will return <b>0</b>.
     *
     * @param number input argument to check.
     * @return {@link java.lang.Integer}
     */
    public static Integer nvl(Integer number) {
        return (number == null ? 0 : number);
    }

    
    /**
     * To return a random value of Integer by given range.
     * 
     * @param min the minimum range value.
     * @param max the minimum range value.
     * @return {@link int}
     */
    public static int random(int min, int max) {                
        return ((int) ((Math.random() * ((max - min) + 1)) + min));
    }
    
    
    /**
     * To return a random value of int.
     * <p>
     * The range of random value is from 0 to {@link java.lang.Integer#MAX_VALUE}.<br>
     * See {@link com.mkdika.jeneric.function.IntegerFun#random(int, int)}
     * 
     * @return {@link int}
     */
    public static int random(){
        return random(0, (Integer.MAX_VALUE-1));
    }
    
}
