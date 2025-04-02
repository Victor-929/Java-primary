package com.itheima.demo3Stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        //目标：获取Stream流的方式
        //1、获取集合的Stream流，集合调用提供的Stream()方法
        Collection<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream();

        //2、Map集合，怎么拿Stream流
        Map<String,Integer> map = new HashMap<>();
        //获取键流
        Stream<String> s2 = map.keySet().stream();
        //获取值流
        Stream<Integer> s3 = map.values().stream();
        //获取键值对流
        Stream<Map.Entry<String, Integer>> s4 = map.entrySet().stream();

        //3、获取数组的流
        String[] arr = {"林青霞","张曼玉","王祖蓝","柳岩"};
        Stream<String> s5 = Arrays.stream(arr);
        System.out.println(s5.count());

        Stream<String> s6 = Stream.of(arr);
        Stream<String> s7 = Stream.of("林青霞","张曼玉","王祖蓝","柳岩");

    }
}
