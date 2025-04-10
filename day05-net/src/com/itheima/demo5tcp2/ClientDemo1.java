package com.itheima.demo5tcp2;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标：完成TCP通信多发多收，客户端开发
        System.out.println("客户端启动...");
        //1、创建Scoket管道对象，请求与服务端的Socket链接。可靠链接
        Socket socket = new Socket("127.0.0.1", 9999);

        //2、从Socket管道中得到一个字节输出流对象
        OutputStream os = socket.getOutputStream();

        //3、特殊数据流。
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的内容：");
            String msg = sc.nextLine();
            if("exit".equals(msg)){
                System.out.println("===客户端退出===");
                dos.close();//关闭输出流
                socket.close();//关闭socket
                break;
            }
            dos.writeUTF(msg);//发送数据
            dos.flush();
        }
    }
}
