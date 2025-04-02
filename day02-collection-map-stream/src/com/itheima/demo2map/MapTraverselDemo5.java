package com.itheima.demo2map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraverselDemo5 {
    public static void main(String[] args) {
        //目标：掌握Map集合的遍历方式三：Lambda
        Map<String,Integer> map = new HashMap<>();//一行经典代码
        map.put("嫦娥",20);
        map.put("女儿国王",31);
        map.put("嫦娥", 22);
        map.put("孙悟空",18);
        map.put("铁扇公主",28);
        map.put("玉面公主",20);
        System.out.println(map);

        //1、直接调用Map集合的forEach方法遍历
        map.forEach((k,v)->{
            System.out.println(k+"="+v);
        });
    }
}
