package com.itheima.demo6_lock;

public class DrawThread extends Thread{
    private Account acc;//记住线程要处理的账户对象

    public DrawThread(String name, Account acc) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        //取钱
        acc.drawMoney(100000);
    }
}
