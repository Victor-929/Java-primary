package com.itheima.damo1hashset;

import java.util.HashSet;
import java.util.Set;

public class SetDemo2 {
    public static void main(String[] args) {
        //目标：掌握HashSet集合去重操作
        Student s1 = new Student("小明", 18, "北京", "123456");
        Student s2 = new Student("小红", 19, "上海", "987654");
        Student s3 = new Student("小明", 18, "北京", "123456");
        Student s4 = new Student("小红", 19, "上海", "987654");

        Set<Student> set = new HashSet<>();//不重复的！
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        System.out.println(set);


    }
}
