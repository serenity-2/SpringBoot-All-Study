package com.jzjr.aopproxyoperation.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //增强方法
                        System.out.println("i'm agent, i want do nothing now,terribled!");
                        //目标对象的方法
                        Object result = method.invoke(object, args);
                        return result;
                    }
                }
        );
    }
}

