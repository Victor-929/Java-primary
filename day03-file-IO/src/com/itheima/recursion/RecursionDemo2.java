package com.itheima.recursion;

public class RecursionDemo2 {
    public static void main(String[] args) {
        //目标：计算n的阶乘
        System.out.println(f(5));
        System.out.println(f1(5));
    }
    public static int f(int n) {
        if(n == 1){
            return 1;
        }
        return n * f(n - 1);
    }

    public static int f1(int n){
        if(n == 1){
            return 1;
        }
        return n + f1(n - 1);
    }
}
