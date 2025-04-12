package com.itheima;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    //定义一个集合容器存储所有登陆进来的管道，以便将来群发消息给他们。
    //定义一个map集合，键是存储客户端的管道，值是这个管道的用户名称
    public static final Map<Socket,String> onLineSockets = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("服务器启动...");
        try {
            //1、注册端口
            ServerSocket serverSocket = new ServerSocket(Constant.PORT);
            //2、主线程负责接受客户端的连接请求
            while (true) {
                //3、调用accept方法，阻塞等待客户端连接，一旦有客户端连接，accept方法会返回一个Socket对象
                System.out.println("等待客户端连接...");

                Socket socket = serverSocket.accept();
                //把这管道交给独立的线程处理：以便支持很多客户端可以同时进来通信。
                new ServerReader(socket).start();

                System.out.println("一个客户端连接了：" + socket.getInetAddress().getHostAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
