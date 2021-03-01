package com.igeek.ch21.xml.declare;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/3/1 11:31
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_ch21_xml.xml");

        IMax c1 = (IMax)ac.getBean("c");
        System.out.println("max = "+c1.max(10,20));

        IMin c2 = (IMin)ac.getBean("c");
        System.out.println("min = "+c2.min(10,20));
    }

}
