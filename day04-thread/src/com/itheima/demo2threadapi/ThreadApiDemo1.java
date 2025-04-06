package com.itheima.demo2threadapi;

public class ThreadApiDemo1 {
    public static void main(String[] args) {
        //目标：搞清楚线程的常用方法
        Thread t1 = new MyThread("1号");
        //t1.setName("1号");
        t1.start();
        System.out.println(t1.getName());//线程的名字: Thread-索引

        Thread t2 = new MyThread("2号");
       // t2.setName("2号");
        t2.start();
        System.out.println(t2.getName());//线程的名字: Thread-索引

        Thread m = Thread.currentThread();
        m.setName("主线程");
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + Thread.currentThread().getName()+"-->"+i);
        }
    }
}
//1、定义一个子类继承Thread类，成为一个线程类
class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }
    //2、重写run方法，编写线程执行的代码
    @Override
    public void run() {
        //3、在run方法中编写线程执行的代码
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程：" + Thread.currentThread().getName()+"-->"+i);
        }
    }
}
