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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class is collection of all Java Generic based return functions.
 *
 * All static method may return related generic class or Array/Collection of it.
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 * @since 2018-04-28
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
