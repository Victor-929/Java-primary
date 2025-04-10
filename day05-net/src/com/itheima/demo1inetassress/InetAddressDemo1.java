package com.itheima.demo1inetassress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo1 {
    public static void main(String[] args) {
        //目标：认识InetAddress类获取本机IP对象和对方IP对象
            try {
                //1.获取本机IP对象
                InetAddress localHost = InetAddress.getLocalHost();
                System.out.println(localHost);
                System.out.println(localHost.getHostAddress());
                System.out.println(localHost.getHostName());
            //2.获取对方IP对象
                InetAddress byName = InetAddress.getByName("www.baidu.com");
                System.out.println(byName);
                System.out.println(byName.getHostAddress());
                System.out.println(byName.getHostName());
            //3、判断本机和对方主机是否互通
                System.out.println(byName.isReachable(50000));
            } catch (Exception e) {
                e.printStackTrace();
            }



    }
}
