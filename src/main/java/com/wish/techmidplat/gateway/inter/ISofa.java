package com.wish.techmidplat.gateway.inter;

import java.util.Map;

/**
 * @author: QUAN
 * @date: Created in 2019/10/17 13:33
 * @description:
 * @modified By:
 */
public interface ISofa {
    /**
     * sofa 服务总接口
     * @param cityCode 城市码
     * @param eventCode 事件码
     * @param body 入参
     * @return
     */
    String actionStr(String cityCode, String eventCode, String body);

    /**
     * sofa 服务总接口1
     * @param cityCode 城市码
     * @param eventCode 事件码
     * @param paramsMap 入参
     * @return
     */
    Map<String, Object> actionMap(String cityCode, String eventCode, Map<String, Object> paramsMap);
}
