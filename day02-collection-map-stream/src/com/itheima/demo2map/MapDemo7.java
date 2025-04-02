package com.itheima.demo2map;

import com.itheima.damo1hashset.Teacher;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo7 {
    public static void main(String[] args) {
        //目标：TreeMap集合（原理和用法与TreeSet一样）
        Map<Teacher, String> map = new TreeMap<>(((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary())));//按照键顺序排序
        map.put(new Teacher("老陈", 30, 6232.4),"4627");
        map.put(new Teacher("小dlei", 35, 3999.5),"4227");
        map.put(new Teacher("小马哥", 28, 999.5),"4617");
        map.put(new Teacher("老王", 28, 9999.5),"4237");
        System.out.println(map);

    }
}
