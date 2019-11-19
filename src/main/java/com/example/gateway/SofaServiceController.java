package com.example.gateway;

import com.wish.techmidplat.gateway.inter.ISofa;
import com.wish.techmidplat.gateway.sdk.utils.SofaUtil;
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

    ISofa gatewaySofaService = SofaUtil.getGatewaySofaService("127.0.0.1:12300");

    @RequestMapping("/action")
    private  String action(){
        Object o = gatewaySofaService.action("1","2","3");
        System.out.println(o); // you input cityCode is 1
        return  o.toString();
    }

    @RequestMapping("/action1")
    private  String action1(){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("1", "111");
        Object o = gatewaySofaService.action1("1","2",paramsMap);
        System.out.println(o); // {1=111, key=this is you input map.}
        return  o.toString();
    }
}
