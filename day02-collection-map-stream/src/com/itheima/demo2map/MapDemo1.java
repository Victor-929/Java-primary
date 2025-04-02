package com.itheima.demo2map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {
        //目标：认识Map集合的体系特点
        //1、创建Map集合
        //HasHMap特点：无序，不重复，无索引，键值对都可以null，值不做要求（可以重复）
        //LinkedHashMap特点：有序，不重复，无索引，键值对都可以null，值不做要求（可以重复）
        //TreeMap特点：按照键可排序，不重复，无索引


//        Map<String,String> map = new HashMap<>();//一行经典代码
        Map<String,String> map = new LinkedHashMap<>();
        map.put("嫦娥","20");
        map.put("女儿国王","31");
        map.put("嫦娥","22");
        map.put("孙悟空","18");
        map.put("铁扇公主","28");
        map.put("玉面公主","20");
        map.put("null","null");
        System.out.println(map);//{嫦娥=22, 孙悟空=18, 铁扇公主=28, 女儿国王=31, 玉面公主=20}
    }
}
