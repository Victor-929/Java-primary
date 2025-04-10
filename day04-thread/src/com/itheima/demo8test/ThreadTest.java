package com.itheima.demo8test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTest {
    public static void main(String[] args) {
        //目标：完成多线程的综合小案例
        //红包雨游戏，某企业有100名员工，员工的工号依次是1，2，3，4...到100
        //现在公司举办了年会活动，活动中有一个红包雨环节，要求共计发出200个红包雨，
        //分析：100个员工就是100个线程，来抢200个红包。
        List<Integer> redPacket = getRedPacket();
        //2、定义线程类，创建100个线程，每个线程负责从红包集合中随机获取一个红包，
        for (int i = 1; i <= 100; i++) {
            new PeopleGetRedpacket(redPacket,"人"+i).start();
        }
    }
    //准备这200个随机红包返回，放到List集合中返回
    public static List<Integer> getRedPacket(){
        //1.创建一个List集合，用来存储红包，其中小红包在[1 - 30]元之间，总占比为80%，大红包在[31 - 100]元之间，总占比为20%
        Random r = new Random();
        List<Integer> readPacket = new ArrayList<>();
        //2.创建一个随机数对象
        for (int i = 1; i <= 160; i++) {
            readPacket.add(r.nextInt(30) + 1);
        }
        for (int i = 1; i <= 40; i++) {
            readPacket.add(r.nextInt(70) + 31);
        }
        return readPacket;
    }


}
