package com.example.demo;

import com.wish.techmidplat.gateway.sdk.model.SDKKey;
import com.wish.techmidplat.gateway.sdk.utils.HttpClientUtil;

import java.io.File;
import java.util.*;

/**
 * @author: QUAN
 * @date: Created in 2019/11/6 11:48
 * @description: 文件上传测试类
 * @modified By:
 */
public class FileUploadTest {
    public static void main(String[] args) {

        String reqUrl ="http://172.29.12.55:8000/plat-filestore/fileupload";
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("businessSeq", "123");
        List< File > files = new ArrayList<>();
        File file = new File("D:\\testFile\\a.txt");
        files.add(file);
        File file2 = new File("D:\\testFile\\b.txt");
        files.add(file2);

        SDKKey key = new SDKKey();
        key.setSecretKey("abcdedfg12345678");
        key.setHexString(false);
        key.setIv("UISwD9fW6cFh9SNS");
        key.setPrik("ce/2iZsuhncEfhZNp0N1aNBOvATN7DEWGNhNBYsGq3A=");
        key.setUserId("ALICE123@YAHOO.COM");
        key.setNeedSecret(true); // 设置是否加密

        HttpClientUtil util = HttpClientUtil.getInstance();
        try {

            Object ret = util.upload(reqUrl,paramsMap,files,key);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
