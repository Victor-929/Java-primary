package com.itheima.bufferReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferReadDemo1 {
    public static void main(String[] args) {
        //目标：搞清楚缓冲字符输入流读取字符内容：性能提升了，多了按照行读取文本的能力
        try (
                //1、创建一个字符输入流对象，指定读取数据的来源
                Reader fr = new FileReader("day03-file-IO\\src\\dlei08.txt");
                //2、把字符输入流对象包装成缓冲字符输入流对象，提高读取字符的效率
                BufferedReader br = new BufferedReader(fr);
        ){
            //3、定义一个字符数组，每次读取多个数组
//            char[] buffer = new char[1024];
//            int len = 0;//用于记录每次读取了多少个字符
//            while((len = br.read()) != -1){
//                System.out.print(new String(buffer,0,len));
//            }

            //使用循环改进，来按照行读数据
            //定义一个字符串变量用于记住每次读取的一行内容
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            //目前读取文本最优雅的方案，性能好，不乱码，可以按照行读取
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
