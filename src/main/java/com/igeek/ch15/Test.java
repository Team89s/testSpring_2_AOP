package com.igeek.ch15;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/2/25 15:10
 */
public class Test {

    public static void main(String[] args) {
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        //com.igeek.ch15.ArithmeticCalculatorImpl
        System.out.println(target.getClass().getName());

        ArithmeticCalculator proxy = new ArithmeticCalculatorLogImpl(target).getProxy();
        //com.sun.proxy.$Proxy0
        System.out.println(proxy.getClass().getName());

        int result1 = proxy.add(10, 20);
        System.out.println("result1 = "+result1);

        System.out.println("======================");

        int result2 = proxy.div(20, -10);
        System.out.println("result1 = "+result2);
    }

}
