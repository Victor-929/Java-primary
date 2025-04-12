package com.itheima.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientChatFrame extends JFrame{
    public JTextArea smsContent = new JTextArea(23,50);
    private JTextArea smsSend = new JTextArea(4,40);
    public JList<String> onlineUser = new JList<>();
    public JButton sendBn = new JButton("发送");

    public ClientChatFrame(){
        initView();
        this.setVisible(true);
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
        onlineUser.setFont(font);
        onlineUser.setFixedCellWidth(120);
        onlineUser.setVisibleRowCount(13);

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
        JScrollPane userListScrollPane = new JScrollPane(onlineUser);
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
}
