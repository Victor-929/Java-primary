package com.itheima.demo2threadapi;

public class ThreadApiDemo2 {
    public static void main(String[] args) {
        //目标：搞清楚Thread类的sleep方法（线程休眠）
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + Thread.currentThread().getName()+"-->"+i);
            try {
                //当前执行的线程进入休眠状态，直到时间到了，才会继续执行
                //
                Thread.sleep(1000);//休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
