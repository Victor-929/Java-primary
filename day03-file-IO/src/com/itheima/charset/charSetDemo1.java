package com.itheima.charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class charSetDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //目标：写程序实现字符编码和解码
        //1、编码
        String name = "我爱你中国abc666";

//        byte[] bytes = name.getBytes();//平台UTF-8编码的
        byte[] bytes = name.getBytes("GBK");//指定GBK进行编码
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));


        //2、解码
//        String name2 = new String(bytes);//平台UTF-8解码的
        String name2 = new String(bytes,"GBK");
        System.out.println(name2);
    }
}
