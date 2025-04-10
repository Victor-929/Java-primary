package com.itheima.demo4tcp1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) throws Exception {
        //目标：完成TCP通信一发一收，服务端开发
        System.out.println("服务端启动了...");
        //1、创建服务端ServerSocket对象，绑定端口号，监听客户端连接
        ServerSocket ss = new ServerSocket(9999);
        //2、调用accept方法，阻塞等待客户端连接，一旦有客户端连接，accept方法会返回一个Socket对象
        Socket socket = ss.accept();
        //3、获取输入流，读取客户端发送的数据
        InputStream is = socket.getInputStream();
        //4、把字节输入流包装成特殊数据输入流
        DataInputStream dis = new DataInputStream(is);
        //5、读取数据
        int len = dis.readInt();
        String msg = dis.readUTF();
        System.out.println("id:" + len + ",msg:" + msg);
        //6、客户端的ip和端口
        System.out.println("客户端的IP地址：" + socket.getInetAddress().getHostAddress());
        System.out.println("客户端的端口号：" + socket.getPort());

    }
}
