package com.itheima.demo1create;

public class ThreadDemo1 {
    public static void main(String[] args) {
        //目标：认识多线程，掌握创建线程的方式一：继承Thread类
        //4、创建一个线程类对象，调用start方法开启线程
        Thread mt = new MyThread();
        //5、调用start方法开启线程
        mt.start();//启动线程，让线程调用run方法
        System.out.println("------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + Thread.currentThread().getName()+"-->"+i);
        }
    }

}
//1、定义一个子类继承Thread类，成为一个线程类
class MyThread extends Thread{
    //2、重写run方法，编写线程执行的代码
    @Override
    public void run() {
        //3、在run方法中编写线程执行的代码
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程：" + Thread.currentThread().getName()+"-->"+i);
        }
    }
}
