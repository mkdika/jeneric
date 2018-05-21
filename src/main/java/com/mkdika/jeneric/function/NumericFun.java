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
