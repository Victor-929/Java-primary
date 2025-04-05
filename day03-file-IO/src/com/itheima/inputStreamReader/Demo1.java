package com.itheima.inputStreamReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class Demo1 {
    public static void main(String[] args) {
        //目标：演示一个问题：不同编码读取乱码的问题
        //代码：UTF-8 文件：UTF-8 读取不乱码
        //代码：UTF-8 文件：GBK 读取乱码
        try (
                //1、创建一个字符输入流对象，指定读取数据的来源
                Reader fr = new FileReader("day03-file-IO\\src\\dlei09.txt");
                //2、把字符输入流对象包装成缓冲字符输入流对象，提高读取字符的效率
                BufferedReader br = new BufferedReader(fr);
        ){

            //定义一个字符串变量用于记住每次读取的一行内容
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
