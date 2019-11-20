package com.example.gateway;

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

    @RequestMapping("/action")
    private  String actionStr(){
        return  gatewaySofaApi.actionStr("2","3");
    }

    @RequestMapping("/action1")
    private  String actionMap(){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("1", "111");
        return  gatewaySofaApi.actionMap("2",paramsMap).toString();
    }
}
