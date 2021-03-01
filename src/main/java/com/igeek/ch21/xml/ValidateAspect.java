package com.igeek.ch21.xml;

/**
 * AOP特点：
 * 1.面向切面编程
 * 2.原理就是动态代理模式
 * 3.对源代码不进行任何更改的情况下，添加切面，来进行增强模块功能
 * 4.最经典的用法：Spring的事务处理
 */
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//校验切面
public class ValidateAspect {

    public Object validate(ProceedingJoinPoint pjp){
        String methodName = pjp.getSignature().getName();
        for (Object args : pjp.getArgs()) {
            int arg = (int)args;
            if(arg<=0){
                System.out.println("the method "+methodName+" 参数出现非正数");
                return 0;
            }
        }
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
