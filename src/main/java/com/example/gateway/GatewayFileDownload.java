package com.example.gateway;

import com.wish.techmidplat.gateway.sdk.model.SDKFileResponse;
import com.wish.techmidplat.gateway.sdk.model.SDKKey;
import com.wish.techmidplat.gateway.sdk.utils.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author: QUAN
 * @date: Created in 2019/11/6 14:10
 * @description: 文件下载 （走网关）
 * @modified By:
 */
public class GatewayFileDownload {

    public static final int byteArrCache = 10 * 1024;

    public static void main(String[] args) {

        String reqUrl ="http://127.0.0.1:8000/gateway/04320/07/A00002/plat-filestore/download";

        String[] ids = new String[2];
        ids[0] = "group1/M00/05/14/rB0MN13ObqeAbVd0AAAABbIS0lY428.txt";
        ids[1] = "group1/M00/05/14/rB0MN13ObqeARM8oAAAABmo1faA800.txt";
        // ids[2] = "group1/M00/05/DD/rB0MN13LsneAcr6wAATe_vZioto512.pdf"; // 中文测试


        SDKKey key = new SDKKey();
        key.setPrik("ce/2iZsuhncEfhZNp0N1aNBOvATN7DEWGNhNBYsGq3A=");
        key.setUserId("ALICE123@YAHOO.COM");
        key.setAppId("app_id_sign");

        HttpClientUtil util = HttpClientUtil.getInstance();
        try {
            SDKFileResponse response = util.download(reqUrl,ids,key);
            // 文件名
            String fileName = response.getFileName();
            System.out.println("fileName is : " + fileName);
            String filepath = "D:\\testFile\\download\\" + fileName;
            // 文件内容
            InputStream is = response.getInputStream();
            // 本地测试生成文件
            createFile(filepath, is);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static void createFile(String filepath, InputStream is) throws Exception {
        File file = new File(filepath);
        file.getParentFile().mkdirs();
        FileOutputStream fileout = new FileOutputStream(file);
        /**
         * 根据实际运行效果 设置缓冲区大小
         */
        byte[] buffer = new byte[byteArrCache];
        int ch = 0;
        while ((ch = is.read(buffer)) != -1) {
            fileout.write(buffer, 0, ch);
        }
        is.close();
        fileout.flush();
        fileout.close();
    }
}
