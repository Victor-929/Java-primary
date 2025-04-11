package com.itheima.demo8api;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test3 {
    public static void main(String[] args) {
        //目标：掌握BigDecimal解决小数运算结果失真问题
        double a = 0.1;
        double b = 0.2;
        System.out.println(a+b);//0.30000000000000004

        //如何解决呢？BigDecimal
        //1.创建BigDecimal对象，把小数包装成BigDecimal对象来运算才可以。
        //必须使用Public BigDecimal(String val)字符串构造器才能解决失真问题
//        BigDecimal bd1 = new BigDecimal("0.1");
//        BigDecimal bd2 = new BigDecimal("0.2");
//        BigDecimal bd1 = new BigDecimal(Double.toString(a));
//        BigDecimal bd2 = new BigDecimal(Double.toString(b));

        //优化方案，可以调用valueOf方法把double包装成BigDecimal对象
        BigDecimal bd1 = BigDecimal.valueOf(a);
        BigDecimal bd2 = BigDecimal.valueOf(b);
        System.out.println(bd1.add(bd2));//0.3

        BigDecimal rs = bd1.add(bd2);//解决精度问题的手段
        Double d = rs.doubleValue();//目的：把BigDecimal对象转换成double类型
        System.out.println(d);

        System.out.println("----------------------");
        BigDecimal i = BigDecimal.valueOf(0.1);
        BigDecimal j = BigDecimal.valueOf(0.3);
        //除法
//        BigDecimal rs2 = i.divide(j);//抛异常
        BigDecimal rs2 = i.divide(j,2, RoundingMode.HALF_UP);//2位小数，四舍五入
        System.out.println(rs2);
    }
}
