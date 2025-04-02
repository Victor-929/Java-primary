package com.itheima.demo1exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        //目标：搞清楚异常的作用
        System.out.println("====程序开始===");
        try {
            System.out.println(getResult(10, 0));
            System.out.println("底层方法执行成功了~~");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("底层方法执行失败了~~");
        }
        System.out.println("=====程序结束===");
    }

    //需求：求两个数的结果，并返回这个结果
    public static int getResult(int a, int b) throws Exception {
        int result = 0;
        try {
            result = a / b;
        } catch (Exception e) {
            System.out.println("出现异常了");
            throw new Exception("除数不能为0，您的参数有问题");
        }
        return result;
    }
}
