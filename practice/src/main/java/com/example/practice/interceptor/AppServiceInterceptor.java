package com.example.practice.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author Anh Dung
 *
 */
@Component
public class AppServiceInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(AppServiceInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        logger.info("Pre Handle method is Calling");
        long startTime = new Date().getTime();
        request.setAttribute("startTime", startTime);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        long timePrev = (long) request.getAttribute("startTime");
        long currTime = new Date().getTime();
        logger.info("Execution: " + (currTime - timePrev) + "ms" );
        logger.info("Post Handle method is Calling");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception{
        logger.info("Request and Response is completed");
    }
}
