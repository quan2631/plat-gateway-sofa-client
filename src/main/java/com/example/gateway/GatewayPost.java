package com.example.gateway;

import com.wish.techmidplat.gateway.sdk.model.SDKKey;
import com.wish.techmidplat.gateway.sdk.utils.HttpClientUtil;

/**
 * @author: QUAN
 * @date: Created in 2019/10/22 14:12
 * @description: SDK 加解密 Post 调用测试
 * @modified By:
 */
public class GatewayPost {
    public static void main(String[] args) {

        String body = "{\n" +
                "\"data\":{\n" +
                " \"common\": {\n" +
                "  \"retimestamp\": 1567593358964,\n" +
                "  \"channelseq\": \"\",\n" +
                "  \"eventCode\": \"B70009\",\n" +
                "  \"businessCode\": \"B70009\"\n" +
                " },\n" +
                " \"plat\": {\n" +
                "  \"login\": {\n" +
                "   \"loginId\": \"001\",\n" +
                "   \"password\": \"123\",\n" +
                "   \"loginType\": 0\n" +
                "  }\n" +
                " }\n" +
                " }\n" +
                "}"; //表单体

        SDKKey key = new SDKKey();
        key.setSecretKey("abcdedfg12345678");
        key.setHexString(false);
        key.setIv("UISwD9fW6cFh9SNS");
        key.setPrik("ce/2iZsuhncEfhZNp0N1aNBOvATN7DEWGNhNBYsGq3A=");
        key.setUserId("ALICE123@YAHOO.COM");
        key.setNeedSecret(true); // 设置是否加密
        key.setAppId("app_id_test");

        HttpClientUtil util = HttpClientUtil.getInstance();
        try {
            Object ret = util.post("http://127.0.0.1:8000/gateway/04320/07/B70009/arrange/newBusiness/1233333",body,key);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
