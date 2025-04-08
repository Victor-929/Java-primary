package com.itheima.demo7executorService;

// 定义一个线程任务类实现Runnable接口
public class MyRunnable implements Runnable {
    // 重写run方法，定义线程任务
    @Override
    public void run() {
        // 线程任务代码
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
