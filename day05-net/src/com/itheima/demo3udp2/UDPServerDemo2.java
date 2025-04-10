package com.itheima.demo3udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("====服务端启动了====");
        //目标：完成UDP通信多发多收，服务端开发
        //1、创建一个接收端对象，注册端口
        DatagramSocket socket = new DatagramSocket(8080);
        //2、创建一个数据包对象负责接受数据。（韭菜盘子）
        byte[] buf = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        while (true) {
            //3、接受数据，将数据封装到数据包对象的字节数组中去
            socket.receive(packet);//阻塞式方法，如果没有数据，就一直阻塞
            //4、看看数据是否收到了
            //获取当前收到的数据长度
            int length = packet.getLength();
            String str = new String(buf, 0, length);
            System.out.println(str);

            //获取对方ip对象和程序端口
            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            System.out.println("ip:" + ip + " port:" + port);

            System.out.println("-------------------");
        }
    }
}
