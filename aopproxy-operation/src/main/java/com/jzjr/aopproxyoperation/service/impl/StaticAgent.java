package com.jzjr.aopproxyoperation.service.impl;


import com.jzjr.aopproxyoperation.service.Figure;

/**
 * 静态代理代理对象
 */
public class StaticAgent implements Figure {
    private Figure figure;

    public StaticAgent(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void skill() {
        System.out.println("i am a agent,i can manager star's extra thing");
        figure.skill();
    }

    @Override
    public void life() {
        System.out.println("life is working... noo");
    }
}
