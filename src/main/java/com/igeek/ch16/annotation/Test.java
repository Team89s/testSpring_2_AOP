package com.igeek.ch16.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/2/25 16:27
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_ch16_annotation.xml");

        ArithmeticCalculator calculator = ac.getBean(ArithmeticCalculator.class);
        //com.sun.proxy.$Proxy11
        System.out.println(calculator.getClass().getName());

        int result1 = calculator.add(10, 20);
        System.out.println("result1 = "+result1);

        int result2 = calculator.div(40, 0);
        System.out.println("result2 = "+result2);
    }

}
