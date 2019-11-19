package com.example.gateway;

import com.wish.techmidplat.gateway.inter.ISofa;
import com.wish.techmidplat.gateway.sdk.utils.SofaUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
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

    @Value("${com.with.gateway.server}")
    private  String server;

    @Value("${com.with.gateway.cityId}")
    private  String cityId;

    @RequestMapping("/action")
    private  String action(){
        ISofa gatewaySofaService = SofaUtil.getGatewaySofaService(server);
        Object o = gatewaySofaService.actionStr(cityId,"2","3");
        System.out.println(o); // you input cityCode is 1
        return  o.toString();
    }

    @RequestMapping("/action1")
    private  String action1(){
        ISofa gatewaySofaService = SofaUtil.getGatewaySofaService(server);
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("1", "111");
        Object o = gatewaySofaService.actionMap(cityId,"2",paramsMap);
        System.out.println(o); // {1=111, key=this is you input map.}
        return  o.toString();
    }
}
