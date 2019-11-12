package com.example.demo;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

/**
 * @author: QUAN
 * @date: Created in 2019/11/11 17:26
 * @description: String 数组 直接toString 则会打印地址。
 * @modified By:
 */
public class StrArrToStringTest {
    public static void main(String[] args) {
        String[] ids = new String[2];
        ids[0] = "group1/M00/05/DC/rB0MN13JJXiAa0-VAAAABbIS0lY595.txt";
        ids[1] = "group1/M00/05/DC/rB0MN13JJXiAZq1cAAAABmo1faA047.txt";
        /**
         * [Ljava.lang.String;@ae45eb6
         */
        System.out.println(ids.toString());
          /**
         * [group1/M00/05/DC/rB0MN13JJXiAa0-VAAAABbIS0lY595.txt, group1/M00/05/DC/rB0MN13JJXiAZq1cAAAABmo1faA047.txt]
         */
        System.out.println(Arrays.toString(ids));
        /**
         * group1/M00/05/DC/rB0MN13JJXiAa0-VAAAABbIS0lY595.txt,group1/M00/05/DC/rB0MN13JJXiAZq1cAAAABmo1faA047.txt
         */
        System.out.println(StringUtils.join(ids, ","));
    }
}
