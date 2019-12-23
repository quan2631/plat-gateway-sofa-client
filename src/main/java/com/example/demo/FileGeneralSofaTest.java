package com.example.demo;

import com.alipay.sofa.rpc.api.GenericService;
import com.alipay.sofa.rpc.config.ConsumerConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: QUAN
 * @date: Created in 2019/10/15 15:27
 * @description: 一个简单接口的泛化调用
 * @modified By:
 */
public class FileGeneralSofaTest {
    public static void main(String[] args) {
        ConsumerConfig consumerConfig = new ConsumerConfig<>()
                .setInterfaceId("com.wish.plat.base.service.HelloService") // 指定接口
                .setProtocol("bolt") // 指定协议
                .setGeneric(true)
                .setDirectUrl("bolt://127.0.0.1:12200"); // 指定直连地址
        GenericService genericService = (GenericService)consumerConfig.refer();

        List<File> files = new ArrayList<>();
        File file = new File("D:\\testFile\\a.txt");
        files.add(file);
        File file2 = new File("D:\\testFile\\b.txt");
        files.add(file2);

        String ret =  genericService.$genericInvoke("uploadFile", new String[] {"java.util.List"}, new Object[]{files}, String.class);
        System.out.println(ret);
    }
}

