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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
public class GenericFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_GenericFun_class_instance");

        try {
            Constructor<GenericFun> c = GenericFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            GenericFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_mapKeyToSet_success() {
        System.out.println("test_GenericFun_mapKeyToSet_success");

        Map<String, Double> itemPrice = new HashMap<>();
        itemPrice.put("apple", 4.5d);
        itemPrice.put("banana", 2.2d);
        itemPrice.put("coconut", 3.45d);

        Set<String> set1 = GenericFun.mapKeyToSet(itemPrice);
        assertTrue(set1 != null);
        assertThat(set1.size(), equalTo(3));
        assertTrue(set1.contains("banana"));
        assertFalse(set1.contains("grape"));

        Set<String> set2 = GenericFun.mapKeyToSet(null);
        assertTrue(set2 != null);
        assertThat(set2.size(), equalTo(0));

        Set<String> set3 = GenericFun.mapKeyToSet(new HashMap<>());
        assertTrue(set3 != null);
        assertThat(set3.size(), equalTo(0));
    }

    @Test
    public void test_mapKeyToList_success() {
        System.out.println("test_GenericFun_mapKeyToList_success");

        Map<String, Double> itemPrice = new HashMap<>();
        itemPrice.put("apple", 4.5d);
        itemPrice.put("banana", 2.2d);
        itemPrice.put("coconut", 3.45d);

        List<String> list1 = GenericFun.mapKeyToList(itemPrice);
        assertTrue(list1 != null);
        assertThat(list1.size(), equalTo(3));
        assertTrue(list1.contains("banana"));
        assertFalse(list1.contains("grape"));
    }

    @Test
    public void test_mapValueToSet_success() {
        System.out.println("test_GenericFun_mapValueToSet_success");

        Map<Integer, String> itemPrice = new HashMap<>();
        itemPrice.put(1, "apple");
        itemPrice.put(2, "grape");
        itemPrice.put(3, "apple");
        itemPrice.put(4, "grape");

        Set<String> set1 = GenericFun.mapValueToSet(itemPrice);
        assertTrue(set1 != null);
        assertThat(set1.size(), equalTo(2));
        assertTrue(set1.contains("apple"));
        assertFalse(set1.contains("banana"));

        Set<String> set2 = GenericFun.mapValueToSet(null);
        assertTrue(set2 != null);
        assertThat(set2.size(), equalTo(0));

        Set<String> set3 = GenericFun.mapValueToSet(new HashMap<>());
        assertTrue(set3 != null);
        assertThat(set3.size(), equalTo(0));
    }

    @Test
    public void test_mapValueToList_success() {
        System.out.println("test_GenericFun_mapValueToList_success");

        Map<Integer, String> itemPrice = new HashMap<>();
        itemPrice.put(1, "apple");
        itemPrice.put(2, "grape");
        itemPrice.put(3, "apple");
        itemPrice.put(4, "grape");

        List<String> list1 = GenericFun.mapValueToList(itemPrice);
        assertTrue(list1 != null);
        assertThat(list1.size(), equalTo(4));
        assertTrue(list1.contains("apple"));
        assertFalse(list1.contains("banana"));

        List<String> list2 = GenericFun.mapValueToList(null);
        assertTrue(list2 != null);
        assertThat(list2.size(), equalTo(0));

        List<String> list3 = GenericFun.mapValueToList(new HashMap<>());
        assertTrue(list3 != null);
        assertThat(list3.size(), equalTo(0));
    }

}
