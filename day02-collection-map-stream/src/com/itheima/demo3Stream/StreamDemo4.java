package com.itheima.demo3Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        //目标：掌握Stream流的统计，收集操作（终结方法）
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("林青霞", 30, 9999.9));
        teachers.add(new Teacher("张曼玉", 35, 7777.7));
        teachers.add(new Teacher("王祖蓝", 33, 5555.5));
        teachers.add(new Teacher("柳岩", 32, 2222.2));
        teachers.add(new Teacher("赵丽颖", 31, 5555.5));

        teachers.stream().filter(t -> t.getSalary() > 5000).forEach(System.out::println);

        System.out.println("-------------------------------------------------");
        long count = teachers.stream().filter(t -> t.getSalary() > 5000).count();
        System.out.println(count);

        System.out.println("-------------------------------------------------");
        //获取最高工资
        Optional<Teacher> max = teachers.stream().max((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        //获取最低工资
        Optional<Teacher> min = teachers.stream().min((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
        if (min.isPresent()) {
            System.out.println(min.get());
        }

        System.out.println("-------------------------------------------------");
        List<String> list = new ArrayList<>();
        list.add("林青霞,30,9999.9");
        list.add("张曼玉,35,7777.7");
        list.add("王祖蓝,33,5555.5");
        list.add("柳岩,32,2222.2");
        list.add("赵丽颖,31,5555.5");

        //流只能收集一次

        //收集到List集合
        Stream<String> s1 = list.stream().filter(s -> s.startsWith("张"));

        List<String> list1 = s1.collect(Collectors.toList());
        System.out.println(list1);

        //收集到Set集合
        Stream<String> s2 = list.stream().filter(s -> s.startsWith("张"));
        Set<String> set = s2.collect(Collectors.toSet());
        System.out.println(set);

        //收集到数组
        Stream<String> s3 = list.stream().filter(s -> s.startsWith("张"));
        Object[] arr = s3.toArray();
        System.out.println(Arrays.toString(arr));

        System.out.println("----------------------收集到Map集合---------------------------");
        //1、收集到Map集合，要求key是老师姓名，value是老师薪水
//        Map<String, Double> map = teachers.stream().collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));
        Map<String, Double> map = teachers.stream().collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));
        System.out.println(map);
    }
}
