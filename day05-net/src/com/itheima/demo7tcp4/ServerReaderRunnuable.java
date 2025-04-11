package com.itheima.demo7tcp4;

import java.io.*;
import java.net.Socket;

public class ServerReaderRunnuable implements Runnable {
    private Socket socket;
    public ServerReaderRunnuable(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //给当前对应的浏览器管道响应一个网页数据回去。
            OutputStream os = socket.getOutputStream();
            //通过字节输出流包装写出去数据给浏览器
            //把字节输出流包装成打印流
            PrintStream ps = new PrintStream(os);
            //写网页数据出去
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println();//必须换行
            ps.println("<html>");
            ps.println("<head>");
            ps.println("<meta charset='UTF-8'>");
            ps.println("<title>");
            ps.println("黑马Java磊哥视频");
            //响应一个图片
            ps.println("<img src='https://www.itheima.com/images/logo.png'>");//https://www.itheima.com/images/logo.png
            ps.println("</title>");
            ps.println("</head>");
            ps.println("<body>");
            ps.println("<h1 style='color:red;font-size=20px'>黑马Java磊哥视频</h1>");
            ps.println("</body>");
            ps.println("</html>");
            ps.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("一个客户端下线了:"+ socket.getInetAddress().getHostAddress() );
        }
    }

}
