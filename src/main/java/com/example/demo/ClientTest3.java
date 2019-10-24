package com.example.demo;

import com.wish.techmidplat.gateway.sdk.model.SDKKey;
import com.wish.techmidplat.gateway.sdk.model.SDKParams;
import com.wish.techmidplat.gateway.sdk.utils.HttpClientUtil;

/**
 * @author: QUAN
 * @date: Created in 2019/10/22 14:12
 * @description: sdk客户端使用，测试用例方法
 * @modified By:
 */
public class ClientTest3 {
    public static void main(String[] args) {

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


        SDKParams params = new SDKParams();
        params.setProId("0");
        params.setCityCode("04320");
        params.setChannelCode("07");
        params.setBody(body);
        params.setParams("gateway,04320,07,B70001,arrange,newBusiness,1233333");


        SDKKey key = new SDKKey();
        key.setSecretKey("abcdedfg12345678");
        key.setHexString(false);
        key.setIv("UISwD9fW6cFh9SNS");
        key.setPrik("ce/2iZsuhncEfhZNp0N1aNBOvATN7DEWGNhNBYsGq3A=");
        key.setUserId("ALICE123@YAHOO.COM");

        HttpClientUtil util = HttpClientUtil.getInstance();
        try {
            Object ret = util.post("http://127.0.0.1:8000/sdk/rest/action",params,key);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
