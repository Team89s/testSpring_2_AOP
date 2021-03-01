package com.igeek.ch21.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//日志切面
public class LogAspect {

    public void beforeAdvice(JoinPoint jp){
        //获得方法名称
        String methodName = jp.getSignature().getName();
        //获得参数列表
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("the method "+methodName+" begin with "+args);
    }

    public void afterAdvice(JoinPoint jp){
        System.out.println("the method "+jp.getSignature().getName() +" end ");
    }

    public void afterReturningAdvice(JoinPoint jp , Object result){
        System.out.println("the method "+jp.getSignature().getName()+" end with "+result);
    }

    public void afterThrowingAdvice(JoinPoint jp , Exception ex){
        System.out.println("the method "+jp.getSignature().getName()+" 发生异常 "+ex.getMessage());
    }
}
