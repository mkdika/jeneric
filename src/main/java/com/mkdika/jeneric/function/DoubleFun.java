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
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
public final class DoubleFun {

    /*
        To prevent class from instanate from outside.
     */
    private DoubleFun() {
    }

    /**
     * Null Value Logic (NVL)
     * <p>
     * If number is null, it will return 0.0d.
     *
     * @param number input parameter to check.
     * @return {@link java.lang.Double}
     */
    public static Double nvl(Double number) {
        return (number == null ? 0.0d : number);
    }

    //TODO: finish NumericFun.randomDouble javadoc
    public static double random() {
        return random(0.0d, Double.MAX_VALUE);
    }

    public static double random(double min, double max) {
        return (Math.random() * ((max - min) + 1) + min);
    }
}
