package com.itheima.demo6_lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String cardId;//卡号
    private double money;//余额

    private final Lock lk = new ReentrantLock();//保护锁对象

    //小明和小红都到这里来了取钱

    public void drawMoney(double money) {
        //拿到当前是谁来取钱
        String name = Thread.currentThread().getName();
        lk.lock();//加锁
        //判断卡余额是否足够
        try {
            if (this.money >= money) {
                System.out.println(name + "取钱成功，取了" + money + "元");
                //更新余额
                this.money -= money;
                System.out.println(name + "取完后余额为" + this.money +"元" );
            } else {
                System.out.println(name + "取钱失败，余额不足");
            }
        } finally {
            lk.unlock();//解锁
        }
    }
}
