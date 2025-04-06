package com.itheima.demo1create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        //目标：掌握多线程的创建方式三：实现Callable接口，方式三优势：可以获取线程的返回值
        //3、创建一个Callable接口的实现类对象
        Callable<String> mc = new MyCallable(100);
        //4、把Callable对象封装成一个真正的线程任务对象FutureTask对象
        /***
         * 未来任务对象的作用？
         *  a、本质就是一个Runnable线程任务对象，可以交给Trader对象执行
         *  b、可以获取线程的返回值
         */
        FutureTask<String> ft = new FutureTask<String>(mc);
        //5、创建一个线程类对象，调用start方法开启线程
        Thread t = new Thread(ft);
        //6、启动线程
        t.start();


        //3、创建一个Callable接口的实现类对象
        Callable<String> mc2 = new MyCallable(50);
        //4、把Callable对象封装成一个真正的线程任务对象FutureTask对象
        FutureTask<String> ft2 = new FutureTask<String>(mc2);
        //5、创建一个线程类对象，调用start方法开启线程
        Thread t2 = new Thread(ft2);
        //6、启动线程
        t2.start();

        //获取线程的返回值
        try {
            //get方法会阻塞当前线程，直到线程任务执行完毕，才会返回线程的返回值
            //如果主线程发现第一个线程还没有执行完毕，会让出CPU，等第一个线程执行完毕，再继续执行下面的代码
            String s = ft.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String s2 = ft2.get();
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//1、定义一个实现类，实现Callable接口
class MyCallable implements java.util.concurrent.Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }
    //2、重写call方法，定义线程任务
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "线程返回值计算1-：" + n + "的结果为：" + sum;
    }
}
