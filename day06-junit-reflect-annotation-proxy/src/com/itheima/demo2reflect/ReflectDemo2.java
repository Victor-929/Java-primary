package com.itheima.demo2reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    @Test
    public void getClassInfo() {
        //目标：获取类信息
        //1、反射第一步：获取Class对象，代表拿到类
        Class c1 = Student.class;
        System.out.println(c1.getName());//类名的全类名 com.itheima.demo2reflect.Student
        System.out.println(c1.getSimpleName());//类名 Student
    }
    //2、获取类的构造器对象并对其进行操作
    @Test
    public  void getConstructorInfo() throws Exception {
        //目标：获取类的构造器对象并对其进行操作
        //1、反射第一步：获取Class对象，代表拿到类
        Class c1 = Dog.class;
        //2、获取类的构造器对象
        Constructor[] cons = c1.getDeclaredConstructors();
        for (Constructor con : cons) {
            System.out.println(con.getName() + "(" + con.getParameterCount() + ")");
        }

        //3、获取单个构造器
        Constructor con = c1.getDeclaredConstructor();//获取无参构造器
        System.out.println(con.getName() + "("+ con.getParameterCount() + ")");

        Constructor con2 = c1.getDeclaredConstructor(String.class, int.class);//获取有参构造器
        System.out.println(con2.getName() + "("+ con2.getParameterCount() + ")");

        //4、获取构造器的作用依然是创建对象
        //暴力反射：暴力反射，可以访问私有构造器、属性和方法，但是不建议使用
        con.setAccessible(true);//绕过访问权限控制，直接反射
        Dog dog1 = (Dog) con.newInstance();
        System.out.println(dog1);

        Dog d2 = (Dog) con2.newInstance("旺财", 3);
        System.out.println(d2);


    }

    //3、获取类的成员变量对象并对其进行操作
    @Test
    public void getFieldInfo() throws Exception {
        //目标：获取类的成员变量对象并对其进行操作
        //1、反射第一步：获取Class对象，代表拿到类
        Class c1 = Dog.class;
        //2、获取成员变量对象
        Field[] files = c1.getDeclaredFields();
        for (Field file : files) {
            System.out.println(file.getName() + ":" + file.getType().getName());
        }
        //3、获取单个成员变量对象
        Field file = c1.getDeclaredField("hobby");
        System.out.println(file.getName() + ":" + file.getType().getName());
        Field file2 = c1.getDeclaredField("age");
        System.out.println(file2.getName() + ":" + file2.getType().getName());

        //4、获取成员变量的目的依然是取值和赋值
        Dog dog1 = new Dog("旺财", 3);
        file.setAccessible(true);//绕过访问权限控制，直接反射
        file.set(dog1, "吃骨头");//设置属性值
        System.out.println(dog1);

        String hobby = (String) file.get(dog1);//d.getHobby()
        System.out.println(hobby);
    }

    //4、获取类的成员方法对象并对其进行操作
    @Test
    public void getMethodInfo() throws Exception {
        //目标：获取类的成员方法对象并对其进行操作
        //1、反射第一步：获取Class对象，代表拿到类
        Class c1 = Dog.class;
        //2、获取成员方法对象
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "(" + method.getParameterCount() + ")");
        }
        //3、获取单个成员方法对象
        Method m1 = c1.getDeclaredMethod("eat");//获取无参eat方法
        Method m2 = c1.getDeclaredMethod("eat", String.class);//获取有参eat方法
        System.out.println(m1.getName() + "(" + m1.getParameterCount() + ")");
        System.out.println(m2.getName() + "(" + m2.getParameterCount() + ")");

        //4、获取成员方法的作用依然是调用方法
        Dog dog1 = new Dog("旺财", 3);
        m1.setAccessible(true);//绕过访问权限控制，直接反射
        Object ret = m1.invoke(dog1);//d.eat()
        System.out.println(ret);

        Object ret2 =m2.invoke(dog1, "牛肉");//唤醒对象dog2的eat带String参数的方法执行，相当于d.eat("牛肉")
        System.out.println(ret2);
    }
}
