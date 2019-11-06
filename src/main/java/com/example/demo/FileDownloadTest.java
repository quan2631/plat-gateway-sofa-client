package com.example.demo;

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
 * @description: 文件下载 测试类
 * @modified By:
 */
public class FileDownloadTest {

    public static final int cache = 10 * 1024;

    public static void main(String[] args) {

        String reqUrl ="http://172.29.12.55:8000/plat-filestore/download";

        String[] ids = new String[2];
        ids[0] = "group1/M00/03/26/rB0MN13Cek6AXp-MAAAABbIS0lY884.txt";
        ids[1] = "group1/M00/03/26/rB0MN13Cek6AEK0fAAAABmo1faA053.txt";

        SDKKey key = new SDKKey();
        key.setSecretKey("abcdedfg12345678");
        key.setHexString(false);
        key.setIv("UISwD9fW6cFh9SNS");
        key.setPrik("ce/2iZsuhncEfhZNp0N1aNBOvATN7DEWGNhNBYsGq3A=");
        key.setUserId("ALICE123@YAHOO.COM");
        key.setNeedSecret(true); // 设置是否加密

        HttpClientUtil util = HttpClientUtil.getInstance();
        try {
            HttpResponse response = util.download(reqUrl,ids,key);
            // 文件名
            String fileName = response.getFirstHeader("Content-Disposition").getValue();
            // 调整文件名 ：attachment;filename=ac1d0c371573020672168437916348.zip
            fileName = fileName.substring(fileName.indexOf("=")+1, fileName.length());
            System.out.println("fileName is : " + fileName);
            String filepath = "D:\\testFile\\download\\" + fileName;
            // 文件内容
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
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
        byte[] buffer = new byte[cache];
        int ch = 0;
        while ((ch = is.read(buffer)) != -1) {
            fileout.write(buffer, 0, ch);
        }
        is.close();
        fileout.flush();
        fileout.close();
    }
}
