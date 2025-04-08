package com.itheima.demo7executorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo1 {
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
        Runnable target = new MyRunnable();
        pool.execute(target);//提交第一个任务，创建线程，自动启动线程处理任务
        pool.execute(target);//提交第二个任务
        pool.execute(target);//提交第三个任务
        pool.execute(target);//复用线程
        pool.execute(target);//复用线程
        pool.execute(target);//复用线程
        pool.execute(target);//临时核心线程的时机
        pool.execute(target);//临时核心线程的时机
        pool.execute(target);//到了任务拒绝的策略了，抛出异常！

        //3、关闭线程池对象：一般不关闭线程池
//        pool.shutdown();//等所有任务执行完毕后再关闭线程池
//        pool.shutdownNow();//立即关闭线程池，不管是否执行完毕
    }
}
