package com.example.demo;

import com.example.util.MapUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: QUAN
 * @date: Created in 2019/11/13 17:01
 * @description:
 * @modified By:
 */
public class MapOrderTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("c", "c");
        map.put("a", "a");
        map.put("2", "2");
        map.put("1", "1");
        /**
         * {a=a, 1=1, 2=2, c=c}
         */
        System.out.println(map);

        /**
         * {1=1, 2=2, a=a, c=c}
         */
        System.out.println(MapUtil.sortMapByKey(map));
    }
}
