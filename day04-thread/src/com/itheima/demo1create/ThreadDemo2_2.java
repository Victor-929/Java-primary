package com.itheima.demo1create;

public class ThreadDemo2_2 {
    public static void main(String[] args) {
        // 目标：掌握多线程的创建方式二：使用Runnable匿名内部类来创建
//        Runnable mr = new Runnable() {
//            @Override
//            public void run() {
//                // 线程任务代码
//                for (int i = 0; i < 5; i++) {
//                    System.out.println(Thread.currentThread().getName() + "-->" + i);
//                }
//            }
//        };
//        Thread t = new Thread(mr); // 指定线程名称
//        t.start(); // 启动线程


        // 创建一个线程类对象，调用start方法开启线程
        new Thread(() -> {
                // 线程任务代码
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
        }).start(); // 启动线程


        System.out.println("------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + Thread.currentThread().getName()+"-->"+i);
        }
    }
}
