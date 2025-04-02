package com.itheima.demo6collection;

import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalTest6 {
    public static void main(String[] args) {
        //目标：认识并发修改异常问题，搞清楚每种遍历的区别
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        list.add("西洋参");
        System.out.println(list);

        //需求：删除全部的枸杞相关的商品
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains("枸杞")) {
                list.remove(s);
            }
        }
        System.out.println(list);//出现并发修改异常问题
//[Java入门, 宁夏枸杞, 黑枸杞, 人字拖, 特级枸杞, 枸杞子, 西洋参]
//[Java入门, 黑枸杞, 人字拖, 枸杞子, 西洋参]

        System.out.println("=====================");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Java入门");
        list1.add("宁夏枸杞");
        list1.add("黑枸杞");
        list1.add("人字拖");
        list1.add("特级枸杞");
        list1.add("枸杞子");
        list1.add("西洋参");
        System.out.println(list1);
        for (int i = 0; i < list1.size(); i++) {
            String s = list1.get(i);
            if (s.contains("枸杞")) {
                list1.remove(s);
                i--;//解决方案1：删除元素后，i--，让i重新指向当前元素
            }
        }
        System.out.println(list1);


        System.out.println("=====================");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Java入门");
        list2.add("宁夏枸杞");
        list2.add("黑枸杞");
        list2.add("人字拖");
        list2.add("特级枸杞");
        list2.add("枸杞子");
        list2.add("西洋参");
        System.out.println(list2);

        //解决方案二：倒着遍历并删除（前提是支持索引）
        for (int i = list2.size() - 1; i >= 0; i--) {
            String s = list2.get(i);
            if (s.contains("枸杞")) {
                list2.remove(s);
            }
        }
        System.out.println(list2);

        System.out.println("=====================");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("Java入门");
        list3.add("宁夏枸杞");
        list3.add("黑枸杞");
        list3.add("人字拖");
        list3.add("特级枸杞");
        list3.add("枸杞子");
        list3.add("西洋参");
        System.out.println(list3);

        //需求1：删除全部枸杞
        //方案一：迭代器遍历并删除,默认存在并发修改异常
        //可以解决3：使用迭代器自己的方法删除
        Iterator<String> it = list3.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.contains("枸杞")) {
//                list3.remove(s);
                it.remove();
            }
        }
        System.out.println(list3);


        System.out.println("=====================");

        ArrayList<String> list4 = new ArrayList<>();
        list4.add("Java入门");
        list4.add("宁夏枸杞");
        list4.add("黑枸杞");
        list4.add("人字拖");
        list4.add("特级枸杞");
        list4.add("枸杞子");
        list4.add("西洋参");
        System.out.println(list4);

        //需求1：删除全部枸杞
        //方案二和三：用增强for和lambda（都没有办法解决并发修改异常问题）
        //结论：增强for和lambda只适合做遍历，不适合做遍历并修改操作。
//        for (String s : list4) {
//            if (s.contains("枸杞")) {
//                list4.remove(s);
//            }
//        }

//        list4.forEach(s -> {
//            if (s.contains("枸杞")) {
//                list4.remove(s);
//            }
//        });
        System.out.println(list4);
    }

}
