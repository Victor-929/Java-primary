package com.itheima.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverselDemo4 {
    public static void main(String[] args) {
        //目标：掌握Map集合的遍历方式二：键值对
        Map<String,Integer> map = new HashMap<>();//一行经典代码
        map.put("嫦娥",20);
        map.put("女儿国王",31);
        map.put("嫦娥", 22);
        map.put("孙悟空",18);
        map.put("铁扇公主",28);
        map.put("玉面公主",20);
        System.out.println(map);

        /**1、把Map集合转换为Set集合，里面的元素类型都是键值对类型（Map.Entry<String,Integer>)
         *
         * map = {嫦娥=22, 孙悟空=18, 铁扇公主=28, 女儿国王=31, 玉面公主=20}
         *  ↓
         * map.entrySet()
         *  ↓
         *  Set<Map.Entry<String, Integer>> entries = [(嫦娥=22), (孙悟空=18, 铁扇公主=28, 女儿国王=31, 玉面公主=20];
         */

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);//打印键值对
            System.out.println(entry.getKey());//打印键
            System.out.println(entry.getValue());//打印值
        }
    }
}
