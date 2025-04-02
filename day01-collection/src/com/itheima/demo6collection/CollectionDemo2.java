package com.itheima.demo6collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        //目标：搞清楚Collection提供的通用集合功能
        Collection<String> list = new ArrayList<>();

        //添加元素
        list.add("张三");
        list.add("李四");
        list.add("王五");
        System.out.println(list);

        //获取集合元素的个数
        int size = list.size();

        //删除集合元素
        list.remove("张三");

        //判断集合是否为空
        boolean empty = list.isEmpty();

        //清空集合
//        list.clear();

        //判断集合是否包含某个元素
        boolean b = list.contains("张三");

        //集合转换成数组
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
        String[] strings = list.toArray(new String[0]);


    }
}
