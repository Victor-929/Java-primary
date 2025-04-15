package com.itheima.demo2reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        //目标：反射的基本作用
        //1、类的全部成分的获取
        //2、可以破坏封装性
        //3、可以绕过范型的约束
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("赵敏");
        list.add("周芷若");
        list.add("东方不败");
//        list.add(9.9);
//        list.add(true);
        Class c1 = list.getClass();
        // 获取ArrayList的add方法
        Method add = c1.getDeclaredMethod("add", Object.class);
        //触发 list集合对象的add方法
        add.invoke(list, 9.9);//翻墙
        add.invoke(list, true);

        System.out.println(list);
    }


}
