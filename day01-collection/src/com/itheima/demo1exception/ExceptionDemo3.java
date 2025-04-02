package com.itheima.demo1exception;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        //认识自定义异常
        System.out.println("=====程序开始===");
        try {
            saveAge(300);
            System.out.println("底层方法执行成功了~~");
        } catch (itheimaAgeException e) {
            e.printStackTrace();
            System.out.println("底层方法执行失败了~~");
//            throw new RuntimeException(e);
        }
        System.out.println("=====程序结束===");
    }

    //需求：我们公司的系统只要收到了年龄小于1岁或者大于200岁的数据，就认为数据有误，需要抛出异常
    public static void saveAge(int age) throws itheimaAgeException {
        if (age < 1 || age > 200){
            //年龄非法：抛出去一个异常返回
            throw new itheimaAgeException("年龄有误，不能低于1岁或者大于200岁");
        }else{
            System.out.println("年龄合法");
            System.out.println("保存年龄：" + age);
        }
    }

}
