package com.itheima.ui;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientReaderThread extends Thread {
    private Socket socket;
    private DataInputStream dis;
    private ClientChatFrame win;
    public ClientReaderThread(Socket socket,ClientChatFrame win){
        this.win = win;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
         //接受的消息可能有很多种类型：1、在线人数更新数据 2、群聊消息

            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                int type = dis.readInt();
                switch (type){
                    case 1:
                        //服务端发来的在线人数更新消息
                        updateClientOnLineUserList();
                        break;
                    case 2:
                        //服务端发送来的群聊消息
                        getMsgToWin();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getMsgToWin() throws Exception {
        //获取群聊消息
        String msg = dis.readUTF();
        win.setMsgToWin(msg);
    }

    //更新客户端的在线人数列表
    private void updateClientOnLineUserList() throws Exception {
        //1、先读取有多少个在线用户
        int count = dis.readInt();
        String[] names = new String[count];
        //2、循环控制读取多少个用户信息
        for (int i = 0; i < count; i++) {
            //3、读取用户信息
            String onLineUser = dis.readUTF();
            //4、将用户信息添加到数组中
            names[i] = onLineUser;
        }

        //5、将集合数据展示到窗口上
        win.updateOnlineUsers(names);
    }


}
