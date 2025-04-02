package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //目标：搞清楚collection集合的整体特点
        //1、List家族的集合：存储的元素是有序的，可以重复的，可以有索引。
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("java");
        list.add("c");
        list.add("c++");
        System.out.println(list);
        String rs = list.get(0);
        System.out.println(rs);


        //2、Set家族的集合：存储的元素是无序的，不可以重复的，没有索引。
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("java");
        set.add("鸿蒙");
        set.add("c");
        set.add("c++");
        System.out.println(set);


    }
}
