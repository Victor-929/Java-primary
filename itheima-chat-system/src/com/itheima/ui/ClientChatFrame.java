package com.itheima.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.List;

public class ClientChatFrame extends JFrame{
    public JTextArea smsContent = new JTextArea(23,50);
    private JTextArea smsSend = new JTextArea(4,40);
    public JList<String> onlineUsers = new JList<>();
    public JButton sendBn = new JButton("发送");
    private Socket socket;

    public ClientChatFrame(){
        initView();
        this.setVisible(true);
    }
    public ClientChatFrame(String nickname, Socket socket){
        this();//先调用上面的无参构造器，初始化界面信息
        //初始化昵称到窗口
        this.setTitle(nickname + "的聊天窗口");
        this.socket = socket;

        //立即把客户端的socket管道交给一个独立的线程专门负责读取客户端socket从服务端收到的在线人数更新数据或者群聊数据。
        new ClientReaderThread(socket, this).start();

    }

    private void initView(){
        this.setSize(700,600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭时退出程序
        this.setLocationRelativeTo(null);//设置窗口居中，并显示

        //设置窗口背景色
        this.getContentPane().setBackground(new Color(0xf0, 0xf0, 0xf0));

        //设置字体
        Font font = new Font("楷体", Font.PLAIN, 14);

        //消息内容框
        smsContent.setFont(font);
        smsContent.setBackground(new Color(0xdd, 0xdd, 0xdd));
        smsContent.setEditable(false);

        //发送消息框
        smsSend.setFont(font);
        smsContent.setWrapStyleWord(true);
        smsSend.setLineWrap(true);

        //在线用户列表
        onlineUsers.setFont(font);
        onlineUsers.setFixedCellWidth(120);
        onlineUsers.setVisibleRowCount(13);

        //创建底部面板
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(0xf0, 0xf0, 0xf0));

        //消息输入框
        JScrollPane smsSendScrollPane = new JScrollPane(smsSend);
        smsSendScrollPane.setBorder(BorderFactory.createEmptyBorder());
        smsSendScrollPane.setPreferredSize(new Dimension(500, 50));

        //发送按钮
        sendBn.setFont(font);
        sendBn.setBackground(Color.decode("#009688"));
        sendBn.setForeground(Color.white);

        //按钮面板
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        btns.setBackground(new Color(0xf0, 0xf0, 0xf0));
        btns.add(sendBn);

        //添加组件
        bottomPanel.add(smsSendScrollPane,BorderLayout.CENTER);
        bottomPanel.add(btns,BorderLayout.EAST);

        //用户列表面板
        JScrollPane userListScrollPane = new JScrollPane(onlineUsers);
        userListScrollPane.setBorder(BorderFactory.createEmptyBorder());
        userListScrollPane.setPreferredSize(new Dimension(120, 500));

        //中心消息面板
        JScrollPane smsContentScrollPane = new JScrollPane(smsContent);
        smsContentScrollPane.setBorder(BorderFactory.createEmptyBorder());

        //添加所有组件
        this.add(smsContentScrollPane,BorderLayout.CENTER);
        this.add(bottomPanel,BorderLayout.SOUTH);
        this.add(userListScrollPane,BorderLayout.EAST);

    }

    public static void main(String[] args) {
        new ClientChatFrame();
    }

    public void updateOnlineUsers(String[] onLineNames) {
        //把线程读取到的在线用户昵称展示到界面上
        onlineUsers.setListData(onLineNames);
    }
}
