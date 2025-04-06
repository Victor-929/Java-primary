package com.itheima.demo1create;

public class ThreadDemo2 {
    public static void main(String[] args) {
        // 目标：掌握多线程的创建方式二：实现Runnable接口
        // 创建一个线程任务对象代表一个线程任务
        Runnable mr = new MyRunnable();
        // 创建一个线程类对象，调用start方法开启线程
        Thread t = new Thread(mr); // 指定线程名称
//        Thread t = new Thread(mr,"1号"); // 指定线程名称
        t.start(); // 启动线程

        System.out.println("------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + Thread.currentThread().getName()+"-->"+i);
        }
    }


}
// 定义一个线程任务类实现Runnable接口
class MyRunnable implements Runnable {
    // 重写run方法，定义线程任务
    @Override
    public void run() {
        // 线程任务代码
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
