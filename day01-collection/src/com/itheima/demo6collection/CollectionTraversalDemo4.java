package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalDemo4 {
    public static void main(String[] args) {
        //目标：掌握Collection的遍历方式二：增强for
        Collection<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("赵敏");
        names.add("周芷若");
        names.add("小昭");

        for (String name : names) {
            System.out.println(name);
        }

    }
}
