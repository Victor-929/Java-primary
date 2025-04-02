package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class CollectionTraversalDemo5 {
    public static void main(String[] args) {
        //目标：掌握Collection的遍历方式三：lambda
        Collection<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("赵敏");
        names.add("周芷若");
        names.add("小昭");

//        names.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

//        names.forEach(s-> System.out.println(s));

        names.forEach(System.out::println);


    }
}
