package com.example.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author: QUAN
 * @date: Created in 2019/11/13 15:46
 * @description: 字符集乱码测试
 * @modified By:
 */
public class CodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "%E6%88%91%E4%BB%AC";
        System.out.println(str);
        String str1 = new String(str.getBytes("ISO-8859-1"), "utf-8");
        System.out.println(str1);
        String str2 = new String(str.getBytes("gb2312"), "utf-8");
        System.out.println(str2);
        String str3 = new String(str.getBytes("gbk"), "UTF-8");
        System.out.println(str3);
        String str4 = new String(str.getBytes("utf-8"), "utf-8");
        System.out.println(str4);
        /**
         * 上边的方法返回：%E6%88%91%E4%BB%AC
         * 下边的方法返回：我们
         */
        String str5 = URLDecoder.decode(str, "utf-8");
        System.out.println(str5);


    }
}
