package com.example.gateway;

import com.wish.techmidplat.gateway.sdk.model.SDKKey;
import com.wish.techmidplat.gateway.sdk.utils.HttpClientUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: QUAN
 * @date: Created in 2019/11/6 11:48
 * @description: 文件上传测试类（走网关）
 * @modified By:
 */
public class GatewayFileUpload {
    public static void main(String[] args) {

        String reqUrl ="http://127.0.0.1:8000/gateway/04320/07/A00002/plat-filestore/fileupload";
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("businessSeq", "111");
        List< File > files = new ArrayList<>();
        File file = new File("D:\\testFile\\a.txt");
        files.add(file);
        File file2 = new File("D:\\testFile\\b.txt");
        files.add(file2);

        SDKKey key = new SDKKey();
        key.setPrik("ce/2iZsuhncEfhZNp0N1aNBOvATN7DEWGNhNBYsGq3A=");
        key.setUserId("ALICE123@YAHOO.COM");
        key.setAppId("app_id_sign");

        HttpClientUtil util = HttpClientUtil.getInstance();
        try {

            Object ret = util.upload(reqUrl,paramsMap,files,key);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
