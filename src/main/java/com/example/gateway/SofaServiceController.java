package com.example.gateway;

import com.alibaba.fastjson.JSONObject;
import com.wish.techmidplat.gateway.api.GatewaySofaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: QUAN
 * @date: Created in 2019/11/19 13:39
 * @description:
 * @modified By:
 */
@RestController
public class SofaServiceController {

    @Autowired
    private GatewaySofaApi gatewaySofaApi;

    private static  String logonBody = "{\n" +
            "  \"data\": {\n" +
            "    \"common\": {\n" +
            "      \"retimestamp\": 1567593358964,\n" +
            "      \"channelseq\": \"\",\n" +
            "      \"eventCode\": \"B70009\",\n" +
            "      \"businessCode\": \"B70009\"\n" +
            "    },\n" +
            "    \"plat\": {\n" +
            "      \"login\": {\n" +
            "        \"loginId\": \"001\",\n" +
            "        \"password\": \"123\",\n" +
            "        \"loginType\": \"11\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";

    @RequestMapping("/action")
    private  String actionStr(){
        return gatewaySofaApi.actionStr("B70009",logonBody);
    }

    @RequestMapping("/action1")
    private  String actionMap(){
        Map<String, Object> paramsMap = JSONObject.parseObject(logonBody,Map.class);
        return  gatewaySofaApi.actionMap("B70001",paramsMap).toString();
    }
}
