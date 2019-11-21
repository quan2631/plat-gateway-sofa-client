package com.example.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: QUAN
 * @date: Created in 2019/11/21 14:18
 * @description: 如果从浏览器调用，jar 包抛出异常后可能有中文。会乱码，不方便查看。因此增加返回时字符集的设置。
 * @modified By:
 */
@Component
public class AExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        httpServletResponse.setCharacterEncoding("utf-8");
        return null;
    }
}
