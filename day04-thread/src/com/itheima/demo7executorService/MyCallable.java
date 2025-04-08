package com.itheima.demo7executorService;

import java.util.concurrent.Callable;

//1、定义一个实现类，实现Callable接口
public class MyCallable implements Callable<String> {
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
        return Thread.currentThread().getName() + "线程返回值计算1-" + n + "的结果为：" + sum;
    }
}
