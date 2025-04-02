package com.itheima.demo3Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        //目标：认识Stream流，掌握其基本使用步骤，体会它的优势和特点
        List<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖蓝");
        list.add("柳岩");
        list.add("张无忌");
        list.add("张三丰");
        list.add("赵敏");
        list.add("周星驰");

        //1、先用传统方案：找出姓张的人，名字为3个字，存入到一个新集合
        List<String> newlist = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张") && name.length() == 3) {
                newlist.add(name);
            }
        }
        System.out.println(newlist);

        //2、使用stream流方案：找出姓张的人，名字为3个字，存入到一个新集合
//        list.stream()
//                .filter(name -> name.startsWith("张"))
//                .filter(name -> name.length() == 3)
//                .forEach(name -> System.out.println(name));
        List<String> newlist2 = list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .collect(Collectors.toList());
        System.out.println(newlist2);
    }
}
