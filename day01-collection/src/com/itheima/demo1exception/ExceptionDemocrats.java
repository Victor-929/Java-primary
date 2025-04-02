package com.itheima.demo1exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemocrats {
    public static void main(String[] args) {
        //目标：掌握异常的处理方法，底层异常都抛出去给最外层调用者，最外层捕获异常，记录异常，响应合适星系给用户观看。
        System.out.println("====程序开始===");
        try {
            method();
            System.out.println("操作成功……");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("操作失败……");
        }
        System.out.println("====程序结束===");
    }
    public static void method() throws Exception {

        //编译时异常：编译时才会出现的异常，继承自Exception
        String str = "2024-07-09 11:12:13";
        //把字符串时间解析成Java中的一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = sdf.parse(str);//编译时异常，提醒程序员这里的程序很容易出错，请您注意！
        System.out.println(date);

        InputStream is = new FileInputStream("d:\\aaa.png");


    }
}
