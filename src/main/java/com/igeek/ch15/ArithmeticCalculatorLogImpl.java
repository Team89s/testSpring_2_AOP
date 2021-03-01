package com.igeek.ch15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description  动态代理设计模式
 * 增加需求：
 * 需求1-日志：在程序执行期间追踪正在发生的活动
 * @Author chenmin
 * @Date 2021/2/25 15:13
 */
public class ArithmeticCalculatorLogImpl {

    //目标对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLogImpl(ArithmeticCalculator target){
        this.target = target;
    }

    //返回代理对象
    public ArithmeticCalculator getProxy(){
        ArithmeticCalculator proxy = null;

        //获得类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();

        //获得类类型数组
        Class[] clazzs = new Class[]{ArithmeticCalculator.class};

        //处理器
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy  代理对象
             * @param method 目标对象的方法对象
             * @param args   目标对象的方法中的形参
             * @return  目标对象方法执行的结果
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //前置通知
                System.out.println("the method "+methodName+" begin with "+ Arrays.asList(args));

                Object result = null;
                try {
                    for (Object arg : args) {
                        int a = (int)arg;
                        if(a<=0){
                            System.out.println("the method "+methodName+" 参数为非正数....");
                            return null;
                        }
                    }

                    //执行目标方法
                    result = method.invoke(target, args);

                    //返回通知
                    System.out.println("the method "+methodName+" end with "+ result);
                }catch (Exception e){
                    //异常通知
                    System.out.println("the method "+methodName+" 发生异常 "+ e.getMessage());
                }
                //后置通知
                System.out.println("the method "+methodName+" end");
                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(classLoader,clazzs,handler);
        return proxy;
    }
}
