package com.itheima.demo3annotatior;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo3 {
    //目标：解析注解
   @Test
    public void parseClass() throws Exception{
       //1、获取类对象
       Class c1 = Demo.class;
       //2、判断这个类上是否陈列了注解MyTest2
       if(c1.isAnnotationPresent(MyTest2.class)){
           //3、获取注解对象
           MyTest2 annotation = (MyTest2) c1.getDeclaredAnnotation(MyTest2.class);
           //4、获取注解的属性值
           String value = annotation.value();
           double hight = annotation.hight();
           String[] address = annotation.address();
           //5、打印注解的属性值
           System.out.println(value);
           System.out.println(hight);
           System.out.println(Arrays.toString(address));
       }
   }
    @Test
    public void parseMethod() throws Exception{
        //1、获取类对象
        Class c1 = Demo.class;
        //2、获取方法对象
        Method method = c1.getMethod("go");
        //3、判断这个方法是否有注解MyTest2
        if(method.isAnnotationPresent(MyTest2.class)){
            //4、获取注解对象
            MyTest2 annotation = method.getDeclaredAnnotation(MyTest2.class);
            //5、获取注解的属性值
            String value = annotation.value();
            double hight = annotation.hight();
            String[] address = annotation.address();
            //6、打印注解的属性值
            System.out.println(value);
            System.out.println(hight);
            System.out.println(Arrays.toString(address));
        }

    }
}
