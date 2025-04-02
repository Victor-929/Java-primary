package com.itheima.demo2map;

import java.util.*;

public class MapTest6 {
    public static void main(String[] args) {
        //目标：完成Map集合相关的案例，投票票统计程序
        cale();
    }

    public static void cale(){
        //1、把80个学生选择的景点数据拿到程序中来，才可以统计
        List<String> locations = new ArrayList<>();
        String[] names = {"玉龙雪山","长城","少林寺","丽江"};
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(names.length);//0 1 2 3
            locations.add(names[index]);
        }
        System.out.println(locations);
        //[少林寺, 玉龙雪山, 长城, 长城, 丽江, 玉龙雪山, 丽江, 长城, 玉龙雪山...]
        //2、统计每个景点的投票数
        //最终统计的结果是一个键值对的形式，所以可以考虑定义一个Map集合来存储
        Map<String,Integer> map = new HashMap<>();

        //3、遍历80个学生选择的景点，来统计选择的次数
        for (String location : locations) {
//            //判断这个景点有没有统计过
//            if(map.containsKey(location)){
//                //如果已经有了，就取出来，然后加1
//                Integer count = map.get(location);
//                count++;
//                map.put(location,count);
//            }else{
//                //如果没有，就直接添加
//                map.put(location,1);
//            }
            map.put(location,map.getOrDefault(location,0)+1);
//            map.put(location,map.containsKey(location) ? map.get(location)+1:1);
        }
        //4、打印投票结果
        map.forEach((k,v)->{
            System.out.println(k+"-->"+v);
        });
    }
}
