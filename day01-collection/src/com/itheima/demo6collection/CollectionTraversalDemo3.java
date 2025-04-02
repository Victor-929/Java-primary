package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalDemo3 {
    public static void main(String[] args) {
        //目标：掌握Collection的遍历方式一：迭代器遍历
        Collection<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("赵敏");
        names.add("周芷若");
        names.add("小昭");
        System.out.println(names);//[张无忌, 赵敏, 周芷若, 小昭]
        //                            it

        //1.得到这个集合的迭代器对象
        Iterator<String> it = names.iterator();
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());//超出范围报错

        //2、使用一个while循环来遍历
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
