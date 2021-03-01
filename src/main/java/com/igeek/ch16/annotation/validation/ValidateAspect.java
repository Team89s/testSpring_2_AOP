package com.igeek.ch16.annotation.validation;

/**
 * AOP特点：
 * 1.面向切面编程
 * 2.原理就是动态代理模式
 * 3.对源代码不进行任何更改的情况下，添加切面，来进行增强模块功能
 * 4.最经典的用法：Spring的事务处理
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 校验切面
 * 1.主要目的：校验参数是否为正数
 * 2.抽取出来的横切关注点 - 校验参数是否为正数
 *
 * 成为切面必备元素：
 * 1.加入到IOC容器中  @Component
 * 2.声明为切面  @Aspect
 */
@Component
@Aspect
@Order(1)
public class ValidateAspect {

    /**
     * 环绕通知  @Around
     *
     * 切入点："execution()"
     *
     * 连接点：ProceedingJoinPoint pjp 获取需要增强的方法的信息，并且可以决定何时何地执行方法
     */
    //@Around("execution(* com.igeek.ch16.annotation.ArithmeticCalculatorImpl.*(..))")
    @Around(value = "com.igeek.ch16.annotation.LogAspect.p()")
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
