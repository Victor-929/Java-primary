package com.itheima.demo4proxy;

public class Test {
    public static void main(String[] args) {
        //目标：创建代理对象
        //1、准备一个明星对象，设计明星类
        Start start = new Start("章若楠");
        //2、为章若楠创建一个专属于她的代理对象
        StartService proxy = ProxyUtil.createProxy(start);
        proxy.sing("《红昭愿》");
        System.out.println(proxy.dance());
    }
}