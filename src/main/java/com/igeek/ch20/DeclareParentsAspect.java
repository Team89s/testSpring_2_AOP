package com.igeek.ch20;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Description 引入通知
 * @Author chenmin
 * @Date 2021/3/1 10:16
 *
 * 引入通知
 * 在不改变计算器实现类的源代码的基础上，就给他增加上求最大值和最小值的方法
 */
@Component
@Aspect
public class DeclareParentsAspect {
    //允许对象动态地实现接口, 就像对象已经在运行时扩展了实现类一样

    //注解类型的 value 属性表示哪些类是当前引入通知的目标 , AspectJ 类型的表达式
    //defaultImpl 属性中指定这个接口使用的实现类
    @DeclareParents(value="* *.ArithmeticCalculator*",defaultImpl =MaxImpl.class )
    private IMax max;
    @DeclareParents(value="* *.ArithmeticCalculator*",defaultImpl =MinImpl.class )
    private IMin min;

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_ch16_annotation.xml");
        IMax max = (IMax)ac.getBean("c");
        System.out.println("max = "+max.max(10,20));

        IMin min = (IMin)ac.getBean("c");
        System.out.println("min = "+min.min(10,20));
    }
}
