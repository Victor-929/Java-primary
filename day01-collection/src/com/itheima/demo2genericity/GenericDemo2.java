package com.itheima.demo2genericity;

public class GenericDemo2 {
    public static void main(String[] args) {
        //目标：学会自定义泛型类
        //需求：请您模拟ArrayList集合自定义一个集合MyArrayList
        MyArrayList<String> list = new MyArrayList<>();//JDK7开始支持后面的类型可以不写
        list.add("hello");
        list.add("world");
//        list.add(555);//报错
        list.add("java");
        list.add("c++");

        System.out.println(list.remove("java"));
        System.out.println(list);

    }
}
