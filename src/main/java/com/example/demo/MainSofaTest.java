package com.example.demo;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.wish.techmidplat.gateway.inter.ISofa;

/**
 * @author: QUAN
 * @date: Created in 2019/10/15 15:27
 * @description: 网关程序，提供sofa服务。此处，编写客户端进行调用。
 * @modified By:
 */
public class MainSofaTest {
    public static void main(String[] args) {
        /**
         * 1、生成代理类
         */
        ConsumerConfig<ISofa> consumerConfig = new ConsumerConfig<ISofa>()
                .setInterfaceId(ISofa.class.getName()) // 指定接口
                .setProtocol("bolt") // 指定协议
                .setDirectUrl("bolt://127.0.0.1:12300"); // 指定直连地址
        ISofa gatewaySofaService = consumerConfig.refer();
        /**
         * 3、发起主调用并打印
         */
        Object o = gatewaySofaService.action("1","2","3");
        System.out.println(o); // you input cityCode is 1
    }
}

