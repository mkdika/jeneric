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

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
public final class NumericFun {

    /*
        To prevent class from instanate from outside.
     */
    private NumericFun() {
    }

    //TODO: finish NumericFun.nvl BigDecimal javadoc
    public static BigDecimal nvl(BigDecimal n) {
        return (n == null ? BigDecimal.ZERO : n);
    }

    //TODO: finish NumericFun.randomDouble javadoc
    public static double randomDouble() {
        return randomDouble(0.0d, Double.MAX_VALUE);
    }

    public static double randomDouble(double min, double max) {
        return (Math.random() * ((max - min) + 1) + min);
    }

    //TODO: finish NumericFun.timesPercent javadoc
    public static BigDecimal timesPercent(BigDecimal numeric, int percent) {
        return numeric.multiply(BigDecimal.valueOf(percent)).divide(BigDecimal.valueOf(100));
    }

    public static BigDecimal addPercent(BigDecimal numeric, int percent) {
        return numeric.add(timesPercent(numeric, percent));
    }

    public static BigDecimal subPercent(BigDecimal numeric, int percent) {
        return numeric.subtract(timesPercent(numeric, percent));
    }

    public static BigDecimal toPercent(BigDecimal numericA, BigDecimal numericB) {
        return numericA.divide(numericB, MathContext.DECIMAL128).multiply(BigDecimal.valueOf(100));
    }

    public static BigDecimal addVat(BigDecimal numeric) {
        return numeric.multiply(BigDecimal.valueOf(1.1));
    }

}
