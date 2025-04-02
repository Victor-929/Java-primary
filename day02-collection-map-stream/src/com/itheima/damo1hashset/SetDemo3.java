package com.itheima.damo1hashset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo3 {
    public static void main(String[] args) {
        //目标：搞清楚TreeSet集合对于自定义对象的排序
        Set<Teacher> teachers = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
//                return o1.getAge() - o2.getAge();//升序
//                return o2.getSalary() - o1.getSalary();//报错
//                if(o1.getSalary() > o2.getSalary())
//                {
//                    return 1;
//                }else if(o1.getSalary() < o2.getSalary()){
//                    return -1;
//                }
//                return 0;
                return Double.compare(o1.getSalary(), o2.getSalary());//薪水升序

            }
        });//排序，不重复，无索引

            //简化
//        Set<Teacher> teachers = new TreeSet<>(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())));


        teachers.add(new Teacher("老陈", 30, 6232.4));
        teachers.add(new Teacher("小dlei", 35, 3999.5));
        teachers.add(new Teacher("小马哥", 28, 999.5));
        teachers.add(new Teacher("老王", 28, 9999.5));
        System.out.println(teachers);

        //结论：TreeSet集合默认不能给自定义对象排序，因为不知道大小规则
        //一定要解决怎么办？两种方案
        //1、对象类实现一个Comparable比较接口，重写compareTo方法，指定大小比较规则
        //2、public TreeSet(Cmparator c)集合自带比较器Comparator对象，指定比较规则


    }
}
