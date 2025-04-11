package com.itheima.demo8api;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //目标：掌握Java提供的获取时间的方案
        //JDK 8之前的方案：Date 老项目还有
        Date d = new Date();//获取当前时间
        System.out.println(d);

        //格式化：SimpleDateFormat 简单日期格式化，格式化日期对象成为我们喜欢的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EE a");
        String str = sdf.format(d);
        System.out.println(str);
        System.out.println(d.getYear()+1900);//已经淘汰
        System.out.println(d.getTime());//1744378109420

        System.out.println("------------------");

        //JDK 8 之后的方案：LocalDate LocalTime LocalDateTime 获取当前日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfYear());
        //获取星期
        System.out.println(now.getDayOfWeek().getValue());

        System.out.println("------------------");
        //格式化 DateTimeFormatter
        //1、创建一个格式化对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EE a");
        //2、格式化now对象时间
        String str2 = dtf.format(now);
        System.out.println(str2);

    }

}
