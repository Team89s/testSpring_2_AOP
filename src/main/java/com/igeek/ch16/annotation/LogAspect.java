package com.igeek.ch16.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * LogAspect  日志切面
 * 1.切面：抽取横切关注点，本质Java类
 * 2.@Component  将当前日志切面，加入到容器中管理
 * 3.@Aspect 声明当前类为切面
 * 4.@Order(2)  决定切面执行的顺序，其中值越小越先执行
 */
@Component
@Aspect
@Order(2)
public class LogAspect {

    /**
     * 重用切点表达式
     * 声明公共的独立的切入点
     * @Pointcut("execution()")
     *
     * 通知中引入切入点时，
     * 1.若是同包且在同类中，可以直接写方法名()
     * 2.若是同包但不在同类中，可以使用类名.方法名()
     * 3.若不是同包也不在同类中，可以使用包名.类名.方法名名()
     * 4.注意当前公共切入点的访问权限修饰符
     */
    @Pointcut("execution(* ArithmeticCalculatorImpl.*(..))")
    public void p(){
        //空方法体
    }

    /**
     * 前置通知  @Before
     * 1.本质上，通知就是方法（模块）
     * 2.JoinPoint 连接点，直接作为方法的参数入参，涵盖了方法的信息
     * 3.切点表达式   @Before("execution(* ArithmeticCalculatorImpl.*(..))")
     * 第一个*：代表任意返回值
     * 第二个*：代表匹配此类下任意方法
     * ..：代表匹配任意参数
     * 若切面和目标类在同一包下，可以省略包名
     */
    //@Before("execution(int com.igeek.ch16.annotation.ArithmeticCalculatorImpl.*(int,int))")
    //@Before("execution(* ArithmeticCalculator.*(..))")
    @Before(value = "p()")
    public void beforeAdvice(JoinPoint jp){
        //获得方法名称
        String methodName = jp.getSignature().getName();
        //获得参数列表
        List<Object> args = Arrays.asList(jp.getArgs());
        System.out.println("the method "+methodName+" begin with "+args);
    }

    //后置通知  @After
    //@After("execution(* ArithmeticCalculator.*(..))")
    @After(value = "p()")
    public void afterAdvice(JoinPoint jp){
        System.out.println("the method "+jp.getSignature().getName() +" end ");
    }

    /**
     * 返回通知  @AfterReturning
     * 1.程序正确执行，确保一定会获取到结果
     * 2.@AfterReturning注解中，returning的属性对应的值必须与方法入参的形参名称一致，才可以收到方法执行的结果
     */
    //@AfterReturning(value = "execution(* ArithmeticCalculator.*(..))"  , returning = "result")
    @AfterReturning(value = "p()"  , returning = "result")
    public void afterReturningAdvice(JoinPoint jp , Object result){
        System.out.println("the method "+jp.getSignature().getName()+" end with "+result);
    }

    /**
     * 异常通知  @AfterThrowing
     * 1.当程序出现异常时，异常通知会执行
     * 2.@AfterThrowing注解中，throwing的属性对应的值必须与方法异常入参的形参名称一致，才可以接收到异常信息
     */
    //@AfterThrowing(value = "execution(* ArithmeticCalculator.*(..))"  , throwing = "ex")
    @AfterThrowing(value = "p()" , throwing = "ex")
    public void afterThrowingAdvice(JoinPoint jp , Exception ex){
        System.out.println("the method "+jp.getSignature().getName()+" 发生异常 "+ex.getMessage());
    }

    /**
     * 环绕通知
     */
    /*@Around("execution(* ArithmeticCalculator.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        String methodName = pjp.getSignature().getName();
        Object result = null;
        //前置通知
        System.out.println("@Around the method "+methodName+" begin with "+Arrays.asList(pjp.getArgs()));
        try {
            //执行目标方法
            result = pjp.proceed();

            //返回通知
            System.out.println("@Around the method "+methodName+" end with "+result);
        } catch (Throwable throwable) {
            System.out.println("@Around the method "+methodName+" 发生异常 "+throwable.getMessage());
        }
        //后置通知
        System.out.println("@Around the method "+methodName +" end ");
        return result;
    }*/

}
