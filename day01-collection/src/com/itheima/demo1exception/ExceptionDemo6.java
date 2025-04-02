package com.itheima.demo1exception;

import java.util.Scanner;

public class ExceptionDemo6 {
    public static void main(String[] args) {
        //目标：掌握异常的处理方式2：捕获异常对象，尝试重新修复
        //接收用户的一个定价
        System.out.println("====程序开始===");
        double price  = 0;
        while (true) {
            try {
                price = userInputPrice();
                break;
            } catch (Exception e) {
                System.out.println("您输入的价格有误，请重新输入！");
            }
            System.out.println("您输入的价格是：" + price);

        }
        System.out.println("====程序结束===");
    }

    public static double userInputPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个价格：");
        double price = sc.nextDouble();
        return price;

    }
}
