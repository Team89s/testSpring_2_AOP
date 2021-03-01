package com.igeek.ch21.xml.declare;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/3/1 10:13
 */
public class MinImpl implements IMin {
    @Override
    public int min(int a, int b) {
        return Math.min(a,b);
    }
}
