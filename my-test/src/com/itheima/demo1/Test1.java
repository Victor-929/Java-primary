package com.itheima.demo1;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {
        //1、随机6个不重复红球号码 1-35，1个篮球 1-15，升序输出，篮球放最后
        Set<Integer> red = new TreeSet<>();
        while (red.size() < 6) {
            int num = (int) (Math.random() * 35 + 1);
            red.add(num);
        }
        System.out.println("用户的红球号码：" + red);
        int blue = (int) (Math.random() * 15 + 1);//篮球号码
        System.out.println("用户的篮球号码：" + blue);

        //2、定义一个集合存储用户选择的号码，再判断中了几个红球，中了几个篮球号码
        Set<Integer> luckRed = new TreeSet<>();
        Collections.addAll(luckRed,10,12,30,16,7,17);
        int luckBlue = 12;

        //3、判断用户中了几个红球
        int redCount = 0;
        for (Integer r : red) {
            if (luckRed.contains(r)) {
                redCount++;
            }
        }
        System.out.println("用户中了" + redCount + "个红球");
        System.out.println("用户中了" + (luckBlue == blue ? "一个篮球" : "0个篮球"));

    }

}
