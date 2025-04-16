package com.itheima.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //使用面向对象编程，创建对象代表一个一个的囚犯（第一次的位置和它的随机编号）
        //1、创建一个ArrayList集合，存储100个囚犯对象
        List<Prisoner> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            //生成随机编号
            int number = (int) (Math.random() * 200) + 1;
            //判断编号是否重复
            while (isRepeat(number, list)) {
                number = (int) (Math.random() * 200) + 1;
            }
            //创建囚犯对象
            Prisoner p = new Prisoner(number, i);
            //将囚犯对象添加到集合中
            list.add(p);
        }
        System.out.println(list);

        //2、干掉集合中奇数位置的囚犯，直到只剩一个囚犯
        while (list.size() > 1) {
            //定义一个新集合存储本轮干掉后剩下的囚犯
            List<Prisoner> newList = new ArrayList<>();
            for (int i = 1; i < list.size(); i+=2) {
                newList.add(list.get(i));
            }
            list = newList;//将上一轮剩下的囚犯，赋值给list，交给下一轮继续用
        }
        System.out.println("最后一个囚犯编号是：" + list.get(0).getNumber() + ",最开始位置是：" + list.get(0).getFirstPosition());
    }
    public static boolean isRepeat(int number,List<Prisoner> prisoners){
        for (Prisoner p : prisoners) {
            if (p.getNumber() == number) {
                return true;//存在重复
            }
        }
        return false;//不存在重复
    }
}
//定义一个囚犯类：封装随机编号，第一次位置
@Data
@NoArgsConstructor
@AllArgsConstructor
class Prisoner{
    private int number;//编号
    private int firstPosition;//第一次位置


}
