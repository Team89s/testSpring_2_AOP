package com.igeek.ch20;

import org.springframework.stereotype.Component;

@Component(value = "c")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    @Override
    public int add(int a, int b) {
        int c = a + b;
        System.out.println("add");
        return c;
    }

    @Override
    public int sub(int a, int b) {
        int c = a - b;
        System.out.println("sub");
        return c;
    }

    @Override
    public int mul(int a, int b) {
        int c = a * b;
        System.out.println("mul");
        return c;
    }

    @Override
    public int div(int a, int b) {
        int c = a / b;
        System.out.println("div");
        return c;
    }
}
