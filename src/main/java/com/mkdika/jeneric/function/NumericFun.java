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

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This class is collection of all Numeric/BigDecimal return functions.
 *
 * All static method may return {@link java.math.BigDecimal}, Array/Collection
 * of {@link java.math.BigDecimal} or other related numeric class.
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 * @author Reja (rejaluo24@gmail.com)
 * @since 2018-04-28
 */
public final class NumericFun {

    /*
        To prevent class from instanate from outside.
     */
    private NumericFun() {
    }

    /**
     * Null Value Logic (NVL) or Denullify.
     * <p>
     * If argument is <b>null</b>, it will return <b>BigDecimal.ZERO</b>.
     *
     * @param number input argument to check.
     * @return {@link java.math.BigDecimal}
     */
    public static BigDecimal nvl(BigDecimal number) {
        return (number == null ? BigDecimal.ZERO : number);
    }

    /**
     * To return calculation of numeric times to percentage.
     * <p>
     * Exampe:
     * <ul>
     * <li>timesPercent(1000,10), will return 100</li>
     * <li>timesPercent(12500,25), will return 3125</li>
     * <li>timesPercent(12577,3), will return 377.31</li>
     * </ul>
     *
     * @param numeric input numeric to be calculated.
     * @param percent the percentage to be calculated.
     * @return {@link java.math.BigDecimal}
     */
    public static BigDecimal timesPercent(BigDecimal numeric, double percent) {
        return numeric.multiply(BigDecimal.valueOf(percent)).divide(BigDecimal.valueOf(100));
    }

    /**
     * To return calculation of numeric addition to percentage.
     * <p>
     * Exampe:
     * <ul>
     * <li>addPercent(1000,10), will return 1100</li>
     * <li>addPercent(10000,30), will return 13000</li>
     * <li>addPercent(250000,25), will return 312500</li>
     * </ul>
     *
     * @param numeric input numeric to be calculated.
     * @param percent the percentage value to be added.
     * @return {@link java.math.BigDecimal}
     */
    public static BigDecimal addPercent(BigDecimal numeric, double percent) {
        return numeric.add(timesPercent(numeric, percent));
    }

    /**
     * To return calculation of numeric subtraction to percentage.
     * <p>
     * Exampe:
     * <ul>
     * <li>subPercent(1000,30), will return 700</li>
     * <li>subPercent(5000, 25), will return 3750</li>
     * <li>subPercent(250000,50), will return 125000</li>
     * </ul>
     *
     * @param numeric input numeric to be calculated.
     * @param percent the percentage value to be subtract.
     * @return {@link java.math.BigDecimal}
     */
    public static BigDecimal subPercent(BigDecimal numeric, double percent) {
        return numeric.subtract(timesPercent(numeric, percent));
    }

    /**
     * To return calculation percentage of given two numeric.
     * <p>
     * Exampe:
     * <ul>
     * <li>toPercent(700,1000), will return 70</li>
     * <li>toPercent(1250, 5000), will return 25</li>
     * <li>toPercent(3000,1500), will return 200</li>
     * </ul>
     *
     * @param numericA input Numerator to be calculated.
     * @param numericB input Denominator to be calculated.
     * @return {@link java.math.BigDecimal}
     */
    public static BigDecimal toPercent(BigDecimal numericA, BigDecimal numericB) {
        return numericA.divide(numericB, MathContext.DECIMAL128).multiply(BigDecimal.valueOf(100));
    }
}
