package com.igeek.ch21.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/3/1 11:24
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_ch21_xml.xml");

        ArithmeticCalculator c = ac.getBean("c", ArithmeticCalculator.class);
        //com.sun.proxy.$Proxy3
        System.out.println(c.getClass().getName());

        int result1 = c.add(10, 20);
        System.out.println("result1 = "+result1);

        int result2 = c.div(10, 0);
        System.out.println("result2 = "+result2);
    }

}
