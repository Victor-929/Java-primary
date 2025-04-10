package com.itheima.demo4tcp1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标：完成TCP通信一发一收，客户端开发
        System.out.println("客户端启动...");
        //1、创建Scoket管道对象，请求与服务端的Socket链接。可靠链接
        Socket socket = new Socket("127.0.0.1", 9999);

        //2、从Socket管道中得到一个字节输出流对象
        OutputStream os = socket.getOutputStream();

        //3、特殊数据流。
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(200);
        dos.writeUTF("你好，我是客户端");
        //4、关闭流资源
        socket.close();
    }
}
