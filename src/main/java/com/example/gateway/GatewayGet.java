package com.example.gateway;

import com.wish.techmidplat.gateway.sdk.model.SDKKey;
import com.wish.techmidplat.gateway.sdk.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: QUAN
 * @date: Created in 2019/11/5 9:40
 * @description: SDK 加解密 Get 调用测试
 * @modified By:
 */
public class GatewayGet {
    public static void main(String[] args) {

        Map<String, String> params = new HashMap<>();
        params.put("name", "zhangsan");
        params.put("code", "201801");

        SDKKey key = new SDKKey();
        key.setSecretKey("abcdedfg12345678");
        key.setHexString(false);
        key.setIv("UISwD9fW6cFh9SNS");
        key.setPrik("ce/2iZsuhncEfhZNp0N1aNBOvATN7DEWGNhNBYsGq3A=");
        key.setUserId("ALICE123@YAHOO.COM");
        key.setNeedSecret(true); // 设置是否加密

        HttpClientUtil util = HttpClientUtil.getInstance();
        try {
            Object ret = util.get("http://127.0.0.1:8000/sdk/rest/getTest", params, key);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
