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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public final class GenericFun {

    /*
        To prevent class from instanate from outside.
     */
    private GenericFun() {
    }

    // TODO: finish GenericFun.mapKeyToSet javadoc
    public static <K, V> Set<K> mapKeyToSet(Map<K, V> map) {
        Set<K> set = new HashSet<>();
        if (map != null && !map.isEmpty()) {
            map.entrySet().stream().forEach(e -> {
                set.add(e.getKey());
            });
        }
        return set;
    }

    public static <K, V> List<K> mapKeyToList(Map<K, V> map) {
        return new ArrayList<>(mapKeyToSet(map));
    }

    // TODO: finish GenericFun.mapValueToSet javadoc
    public static <K, V> Set<V> mapValueToSet(Map<K, V> map) {
        Set<V> set = new HashSet();
        if (map != null && !map.isEmpty()) {
            map.entrySet().stream().forEach(e -> {
                set.add(e.getValue());
            });
        }
        return set;
    }

    public static <K, V> List<V> mapValueToList(Map<K, V> map) {
        List<V> list = new ArrayList<>();
        if (map != null && !map.isEmpty()) {
            map.entrySet().stream().forEach(e -> {
                list.add(e.getValue());
            });
        }
        return list;
    }

}
