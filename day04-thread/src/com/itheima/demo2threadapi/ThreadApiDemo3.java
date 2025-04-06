package com.itheima.demo2threadapi;

public class ThreadApiDemo3 {
    public static void main(String[] args) {
        //目标：搞清楚Thread类的join方法，线程插队：让调用这个方法的线程先执行完毕
        MyThread2 t1 = new MyThread2("线程A");
        t1.start();

        for (int i = 1; i < 5; i++) {
            System.out.println("主线程：" + Thread.currentThread().getName()+"-->"+i);
            if(i==1){
                try {
                    t1.join();//插队 让线程A先执行完毕，然后再执行主线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyThread2 extends Thread{
    public MyThread2(String name) {
        super(name);
    }
    //2、重写run方法，编写线程执行的代码
    @Override
    public void run() {
        //3、在run方法中编写线程执行的代码
        for (int i = 1; i < 5; i++) {
            System.out.println("子线程：" + Thread.currentThread().getName()+"-->"+i);
        }
    }
}