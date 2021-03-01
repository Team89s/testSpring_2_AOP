package com.igeek.ch20;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/3/1 10:13
 */
public class MaxImpl implements IMax {
    @Override
    public int max(int a, int b) {
        return Math.max(a,b);
    }
}
