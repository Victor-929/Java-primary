package com.itheima.demo4test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionDemo2 {
    public static void main(String[] args) {
        //目标：Collections工具类
        List<String> list = new ArrayList<>();
//        list.add("林青霞");
//        list.add("张曼玉");
//        list.add("王祖蓝");
//        list.add("柳岩");
//        list.add("张无忌");
//        list.add("张三丰");
//        list.add("赵敏");

        //1、Collections的方法批量加
        Collections.addAll(list,"周星驰","吴孟达","黄晓明","谢霆锋");
        System.out.println(list);

        //2、打乱顺序
        Collections.shuffle(list);
        System.out.println(list);
    }
}
