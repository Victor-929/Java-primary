package com.itheima.demo1exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo {
    //目标：认识异常的体系，搞清楚异常的基本作用
    public static void main(String[] args) {
//            method();
        try {
            //监视代码，出现异常会被catch拦截这个异常
            method1();
        } catch (Exception e) {
            //打印这个异常
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
    //定义一个方法认识编译时异常
    public static void method1() throws Exception {
        System.out.println("====程序开始===");
        //编译时异常：编译时才会出现的异常，继承自Exception
        String str = "2024-07-09 11:12:13";
        //把字符串时间解析成Java中的一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = sdf.parse(str);//编译时异常，提醒程序员这里的程序很容易出错，请您注意！
        System.out.println(date);

        InputStream is = new FileInputStream("d:\\aaa.png");

        System.out.println("====程序结束===");
    }

    //定义一个方法认识运行时异常
    public static void method(){
        System.out.println("====程序开始===");
        //运行时异常：编译不报错，运行时才会出现的异常，继承自RuntimeException
        int[] arr = new int[3];
//        System.out.println(arr[3]);
//        System.out.println(10/0);

        //空指针异常
        String str = null;
        System.out.println(str);
        System.out.println(str.length());


        System.out.println("====程序结束===");
    }

}
