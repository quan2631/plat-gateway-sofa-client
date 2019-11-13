package com.example.util;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: QUAN
 * @date: Created in 2019/11/13 17:07
 * @description:
 * @modified By:
 */
public class MapUtil {
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }
}

// 比较器类
class MapKeyComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}
