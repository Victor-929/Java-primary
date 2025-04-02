package com.itheima.demo7list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        //目标：掌握list系列集合独有的功能
        List<String> names = new ArrayList<>();//一行经典代码

        //添加数据
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);

        //给第三个位置插入一个数据，赵敏
        names.add(2,"赵敏");
        System.out.println(names);

        //删除李四
        System.out.println(names.remove(1));//根据索引删除，返回删除数据
        System.out.println(names);

        //把王五修改成金毛
        System.out.println(names.set(2, "金毛"));//根据索引修改，返回修改前的数据
        System.out.println(names);

        //获取张三
        System.out.println(names.get(0));

        System.out.println("=========四种遍历演示==========");

        //1、for循环
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        //2、增强for循环
        for (String name : names) {
            System.out.println(name);
        }

        //3、迭代器
        java.util.Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //4、lambda表达式
        names.forEach(name -> System.out.println(name));

    }
}
