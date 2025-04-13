package com.itheima.ui;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

public class ChatEntryFrame extends JFrame { // 修改: 继承JFrame类
    private JTextField nicknameField;
    private JButton enterButton;
    private JButton cancelButton;
    
    public ChatEntryFrame() {
        setTitle("局域网聊天室");
        // 设置窗口属性
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);// 设置窗口大小不可变

        //设置背景颜色
        getContentPane().setBackground(Color.decode("#f0f0f0"));

        //创建主面板并设置布局
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#f0f0f0"));
        add(mainPanel);

        //创建顶部面板
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setBackground(Color.decode("#f0f0f0"));

        //标签和文本框
        JLabel nicknameLabel = new JLabel("昵称：");
        nicknameLabel.setFont(new Font("楷体", Font.BOLD, 16));
        nicknameField = new JTextField(10);
        nicknameField.setFont(new Font("楷体", Font.PLAIN, 16));
        nicknameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));

        topPanel.add(nicknameLabel);
        topPanel.add(nicknameField);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        //按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.decode("#f0f0f0"));

        enterButton = new JButton("登录");
        enterButton.setFont(new Font("楷体", Font.BOLD, 16));
        enterButton.setBackground(Color.decode("#007BFF"));
        enterButton.setForeground(Color.WHITE);
        enterButton.setBorderPainted(false);
        enterButton.setFocusPainted(false);

        cancelButton = new JButton("取消");
        cancelButton.setFont(new Font("楷体", Font.BOLD, 16));
        cancelButton.setBackground(Color.decode("#DC3545"));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);

        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        //添加监视器
        enterButton.addActionListener(e -> {
            String nickname = nicknameField.getText();// 获取输入的昵称
            nicknameField.setText("");// 清空输入框
            if (!nickname.isEmpty()) {
                //进入聊天室逻辑
                //立即发送登录消息给服务端程序
                //1、请求一个登录socket管道，建立与服务端的链接
                Socket socket = new Socket("127.0.0.1", Constant.PORT);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "请输入昵称！");
            }
        });

        cancelButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new ChatEntryFrame();
    }
}