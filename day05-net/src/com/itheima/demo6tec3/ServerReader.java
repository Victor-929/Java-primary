package com.itheima.demo6tec3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread {
    private Socket socket;
    public ServerReader(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //读取管道消息
            //3、获取输入流，读取客户端发送的数据
            InputStream is = socket.getInputStream();
            //4、把字节输入流包装成特殊数据输入流
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                //5、读取数据
                String msg = dis.readUTF();//等待读取客户端发送的数据
                System.out.println("msg:" + msg);
                //6、客户端的ip和端口
                System.out.println("客户端的IP地址：" + socket.getInetAddress().getHostAddress());
                System.out.println("客户端的端口号：" + socket.getPort());
                System.out.println("---------------");
            }

        } catch (Exception e) {
            System.out.println("一个客户端下线了:"+ socket.getInetAddress().getHostAddress() );
        }
    }

}
