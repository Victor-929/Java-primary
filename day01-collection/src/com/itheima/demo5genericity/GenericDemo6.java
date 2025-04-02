package com.itheima.demo5genericity;

import java.util.ArrayList;

public class GenericDemo6 {
    public static void main(String[] args) {
        //目标：搞清楚泛型和集合不支持基本数据类型，只能支持对象类型（引用数据类型）
//        ArrayList<int> list = new ArrayList();
        //泛型擦除：泛型工作在编译阶段，泛型在运行期间会被擦除，所有类型会变成Object
//        list.add(100);//Object 0 = 12;

        //把基本数据类型变成包装对象
//        Integer i = new Integer(100);//
        Integer i1 = Integer.valueOf(100);
        Integer i2 = Integer.valueOf(100);
        System.out.println(i1 == i2);

        //自动装箱：基本数据类型的数据可以直接变成包装对象的数据，不需要额外做任何事情
        Integer i3 = 130;
        Integer i4 = 130;
        System.out.println(i3 == i4);

        //自动拆箱：包装对象可以直接变成基本数据类型的数据，不需要额外做任何事情
        int i5 = i3;
        System.out.println(i5);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);//自动装箱

        int rs = list.get(1);//自动拆箱

        System.out.println("----------------------");


        //包装类新增的功能
        //1、把基本类型的数据转换成字符串
        int j =23;
        String r = Integer.toString(j);//23
        System.out.println(r + 1);//231

        Integer i6 = j;
        String r2 = i6.toString();//23
        System.out.println(r2 + 1);//231

        String r3 = j + "";
        System.out.println(r3 + 1);//231
        System.out.println("----------------------");

        //2、把字符串转换成基本类型的数据
        String str = "123";
        int rs4 = Integer.parseInt(str);//123
        System.out.println(rs4 + 1);//124

        Integer i7 = Integer.valueOf(str);
        int rs3 = i7.intValue();//123
        System.out.println(rs3 + 1);//124

        String str2 = "123.45";
        double rs5 = Double.parseDouble(str2);
        System.out.println(rs5 + 1);

    }
}
