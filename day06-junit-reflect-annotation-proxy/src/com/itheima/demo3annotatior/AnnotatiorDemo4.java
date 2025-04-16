package com.itheima.demo3annotatior;

import java.lang.reflect.Method;

public class AnnotatiorDemo4 {
    public static void main(String[] args) throws Exception{
        //目标：搞清楚注解的应用场景：模拟junit框架，有MyTest注解的方法就执行，没有就不执行
        AnnotatiorDemo4 ad = new AnnotatiorDemo4();
        //1、获取类对象
        Class c1 = AnnotatiorDemo4.class;
        //2、获取类中所有的方法对象
        Method[] methods = c1.getDeclaredMethods();
        //3、遍历方法对象，判断是否有MyTest注解，有就执行，没有就不执行
        for (Method method : methods) {
            //3.1、判断方法上是否有MyTest注解
            if(method.isAnnotationPresent(MyTest.class)){
                //先获取到这个方法的注解
                MyTest myTest = method.getAnnotation(MyTest.class);
                int count = myTest.count();
                //3.2、有就执行
                for (int i = 0; i < count; i++) {
                    method.invoke(ad);
                }
            }
        }

    }
    //测试方法： public 无参 无返回值
    @MyTest
    public void test1(){
        System.out.println("test1方法执行了...");
    }
    public void test2(){
        System.out.println("test2方法执行了...");
    }
    @MyTest(count = 2)
    public void test3(){
        System.out.println("test3方法执行了...");
    }
    @MyTest
    public void test4(){
        System.out.println("test4方法执行了...");
    }
}
