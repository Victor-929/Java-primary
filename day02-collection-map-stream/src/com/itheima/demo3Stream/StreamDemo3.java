package com.itheima.demo3Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        //目标：掌握Stream流提供的常用中间方法，对流上的数据进行处理（返回新流，支持链式编程）
        List<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖蓝");
        list.add("柳岩");
        list.add("张无忌");
        list.add("张三丰");
        list.add("赵敏");
        list.add("周星驰");

        //1、过滤方法
        list.stream().filter(name -> name.startsWith("张") && name.length() == 3).forEach(System.out::println);

        //2、排序方法
        List<Double> scores = new ArrayList<>();
        scores.add(99.9);
        scores.add(77.7);
        scores.add(88.8);
        scores.add(88.8);
        scores.add(55.5);
        scores.add(55.5);
        scores.add(66.6);
        scores.stream().sorted().forEach(System.out::println);//默认升序
        System.out.println("----------------------");
        scores.stream().sorted((s1,s2)-> Double.compare(s2,s1)).forEach(System.out::println);//降序
        System.out.println("----------------------");
        scores.stream().sorted((s1,s2)-> Double.compare(s2,s1)).limit(2).forEach(System.out::println);//降序，只要前两名
        System.out.println("----------------------");
        scores.stream().sorted((s1,s2)-> Double.compare(s2,s1)).skip(2).forEach(System.out::println);//降序，不要前两名
        System.out.println("----------------------");
        //如果希望自定义对象能够去重，重写对象的hashCode和equals方法,才可以去重复
        scores.stream().sorted((s1,s2)-> Double.compare(s2,s1)).distinct().forEach(System.out::println);//降序，去重

        System.out.println("----------------------");
        //加工/映射方法：把流上原来的数据拿出来变成新数据又放到流上去
        scores.stream().map(s -> "加10分后：" +(s + 10)).forEach(System.out::println);

        //合并流
        Stream<String> stream1 = Stream.of("张无忌", "赵敏", "周芷若");
        Stream<Integer> stream2 = Stream.of(111,22,33,44);
        Stream<Object> stream3 = Stream.concat(stream1, stream2);
        System.out.println(stream3.count());

    }
}
