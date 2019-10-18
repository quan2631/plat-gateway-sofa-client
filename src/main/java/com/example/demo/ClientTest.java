package com.example.demo;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.wish.techmidplat.gateway.inter.ISofa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: QUAN
 * @date: Created in 2019/10/15 15:27
 * @description: 网关程序，提供sofa服务。此处，编写客户端进行调用。
 * @modified By:
 */
public class ClientTest {
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
         * 2、构造登录需要的参数
         */
        String cityCode = "04320"; //城市码
        String chnnelCode = "07"; //渠道码
        String tranCode = "B70001"; // 交易码/事件码，对应为登录的事件码
        String body = "{\n" +
                "\"data\":{\n" +
                " \"common\": {\n" +
                "  \"retimestamp\": 1567593358964,\n" +
                "  \"channelseq\": \"\",\n" +
                "  \"eventCode\": \"B70001\",\n" +
                "  \"businessCode\": \"B70001\"\n" +
                " },\n" +
                " \"plat\": {\n" +
                "  \"login\": {\n" +
                "   \"loginId\": \"001\",\n" +
                "   \"password\": \"HX01123\",\n" +
                "   \"loginType\": 0\n" +
                "  }\n" +
                " }\n" +
                " }\n" +
                "}"; //表单体
        String[] params = new String[]{"gateway","04320","07","B70001",
                "arrange", "newBusiness", "1233333"};
        /**
         * 3、发起主调用并打印
         */
        Object o = gatewaySofaService.action(cityCode,chnnelCode,tranCode,body,params);
        String ret = new String((byte[]) o);
        System.out.println(ret);
    }
}

