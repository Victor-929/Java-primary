package com.itheima.demo7executorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo2 {
    public static void main(String[] args) {
        //目标：创建线程池对象使用
        //1、使用线程池的实现类ThreadPoolExecutor创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        //2、使用线程池处理任务！看会不会复用线程池？
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
