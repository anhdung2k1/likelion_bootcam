package com.example.practice.service.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
/**
 * @author Anh Dung
 *
 */
@Configuration
@Aspect
public class DepartmentServiceAspect {
    private Logger logger = LoggerFactory.getLogger(EmployeeServiceAspect.class);

    @Before("execution(* com.example.practice.controller.*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Before called Department Controller" + joinPoint.toString());
    }
    @After("execution(* com.example.practice.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("After called Department Controller" + joinPoint.toString());
    }
}
