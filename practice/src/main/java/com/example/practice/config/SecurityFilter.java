package com.example.practice.config;

import com.example.practice.constant.SITE;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;

import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author Anh Dung
 *
 */
@Component
@Order(1)
public class SecurityFilter implements Filter {
    public static SITE site;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String agent = request.getHeader("User-Agent");
        if(agent != null && agent.contains(site.POSTMAN)){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.addHeader("name","Tran Anh Dung");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write(site.ERROR);
        }
        else filterChain.doFilter(servletRequest,servletResponse);
    }
}
