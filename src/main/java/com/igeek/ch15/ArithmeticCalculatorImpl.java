package com.igeek.ch15;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/2/25 15:09
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator{

    @Override
    public int add(int a, int b) {
        int c = a + b;
        return c;
    }

    @Override
    public int sub(int a, int b) {
        int c = a - b;
        return c;
    }

    @Override
    public int mul(int a, int b) {
        int c = a * b;
        return c;
    }

    @Override
    public int div(int a, int b) {
        int c = a / b;
        return c;
    }
}
