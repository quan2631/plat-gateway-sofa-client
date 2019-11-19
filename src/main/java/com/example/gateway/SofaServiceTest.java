package com.example.gateway;

import com.wish.techmidplat.gateway.inter.ISofa;
import com.wish.techmidplat.gateway.sdk.utils.SofaUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: QUAN
 * @date: Created in 2019/11/19 11:12
 * @description:
 * @modified By:
 */
public class SofaServiceTest {
    public static void main(String[] args) {
        ISofa gatewaySofaService = SofaUtil.getGatewaySofaService("127.0.0.1:12300");
        Object o = gatewaySofaService.action("1","2","3");
        System.out.println(o); // you input cityCode is 1

        Map<String, Object>  paramsMap = new HashMap<>();
        paramsMap.put("1", "111");
        Object o1 = gatewaySofaService.action1("1","2",paramsMap);
        System.out.println(o1); // {1=111, key=this is you input map.}
    }
}
