package com.example.demo;

import com.alipay.sofa.rpc.api.GenericService;
import com.alipay.sofa.rpc.config.ConsumerConfig;
/**
 * @author: QUAN
 * @date: Created in 2019/10/15 15:27
 * @description: 其他一个简单接口的泛化调用
 * @modified By:
 */
public class ClientTest2 {
    public static void main(String[] args) {
        ConsumerConfig consumerConfig = new ConsumerConfig<>()
                .setInterfaceId("com.wish.plat.base.service.HelloService") // 指定接口
                .setProtocol("bolt") // 指定协议
                .setGeneric(true)
                .setDirectUrl("bolt://127.0.0.1:12300"); // 指定直连地址
        GenericService genericService = (GenericService)consumerConfig.refer();
        String ret =  genericService.$genericInvoke("sayHelloStr", new String[] {"java.lang.String","java.lang.String","java.lang.String"}, new Object[]{"1","2","3"}, String.class);
        System.out.println(ret);
    }
}

