package com.jzjr.aopproxyoperation.service.impl;

import com.jzjr.aopproxyoperation.service.Figure;

/**
 * 静态代理目标对象
 */
public class Sunli implements Figure {
    @Override
    public void skill() {
        System.out.println("I'm sunli, i can acting");
    }

    @Override
    public void life() {
        System.out.println("life is enjoy everytime! yes");
    }
}
