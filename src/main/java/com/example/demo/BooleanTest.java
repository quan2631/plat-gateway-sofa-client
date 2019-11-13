package com.example.demo;

/**
 * @author: QUAN
 * @date: Created in 2019/11/13 14:30
 * @description:
 * @modified By:
 */
public class BooleanTest {

    public static void main(String[] args) {
        String a = "false";
        System.out.println(Boolean.parseBoolean(a)); // false

        boolean needSecret = Boolean.parseBoolean("true"); // true
        System.out.println(needSecret);

        System.out.println("--------------------------");

        String a1 = "false";
        System.out.println(Boolean.getBoolean(a1)); // false

        boolean needSecret1 = Boolean.getBoolean("true"); // false
        System.out.println(needSecret1);
    }
}
