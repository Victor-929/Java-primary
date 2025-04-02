package com.itheima.demo2map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {
        //目标：掌握Map的常用方法
        Map<String,Integer> map = new HashMap<>();//一行经典代码
        map.put("嫦娥",20);
        map.put("女儿国王",31);
        map.put("嫦娥", 22);
        map.put("孙悟空",18);
        map.put("铁扇公主",28);
        map.put("玉面公主",20);
        map.put("null",null);
        System.out.println(map);

        //写代码演示常用方法
        System.out.println(map.get("嫦娥"));
        System.out.println(map.get("嫦娥2"));//根据键返回值 null

        System.out.println(map.containsKey("嫦娥"));//判断键是否存在 true
        System.out.println(map.containsKey("嫦娥2"));//判断键是否存在 false

        System.out.println(map.containsValue("20"));//判断值是否存在 true
        System.out.println(map.containsValue("20.0"));//判断值是否存在 false

        System.out.println(map.size());//获取键值对个数

        System.out.println(map.isEmpty());//判断是否为空

        System.out.println(map.remove("嫦娥"));//删除键值对，返回被删除的键值对
        System.out.println( map);

        //获取所有的键放到一个Set集合返回给我们
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }

        //获取所有的值放到一个Collection集合返回给我们
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        map.clear();//清空map
        System.out.println(map);




    }
}
