package com.itheima.damo1hashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
    public static void main(String[] args) {
        //目标：认识set家族集合的特点
        //1、创建一个Set集合，
        //Set<String> set = new HashSet<>();//一行经典代码，HashSet特点：无序，不重复，无索引
        Set<String> set = new LinkedHashSet<>();//LinkedHashSet特点：有序，不重复，无索引
        set.add("java");
        set.add("java");
        set.add("c");
        set.add("c");
        set.add("鸿蒙");
        set.add("鸿蒙");
        set.add("大数据");
        set.add("人工智能");
        System.out.println(set);

        //2、创建一个TreeSet集合：排序（默认一定要大小升序），不重复，无索引
        Set<Double> set1 = new TreeSet<>();
        set1.add(99.0);
        set1.add(88.0);
        set1.add(3.14);
        set1.add(99.0);
        set1.add(66.0);
        System.out.println(set1);

        System.out.println("------------------");


        String s1 = "abd";
        String s2 = "acd";

        System.out.println(s1.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s2.hashCode());
    }
}
