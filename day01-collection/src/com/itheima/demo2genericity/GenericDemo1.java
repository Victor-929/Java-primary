package com.itheima.demo2genericity;

import java.util.ArrayList;

public class GenericDemo1 {
    public static void main(String[] args) {
        //目标：认识泛型，搞清楚使用泛型的好处
        ArrayList list = new ArrayList();
        list.add("java");
        list.add("php");
        list.add("c++");
        list.add(100);
        list.add(true);

        list.add(new Object());
        //获取数据
        for (int i = 0; i < list.size(); i++) {
            Object s = list.get(i);
            //把数据转型处理
            String s1 = (String) s;
            System.out.println(s1);
        }

    }


}
