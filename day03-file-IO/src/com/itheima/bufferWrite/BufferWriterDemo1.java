package com.itheima.bufferWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class BufferWriterDemo1 {
    public static void main(String[] args) {
        //目标：搞清楚缓冲字符输出流的使用：提升了字符输出流的性能，多了换行功能
        try(
                //1、创建一个字符输出流对象，指定写出的目的地
//                Writer fw = new FileWriter("day03-file-IO\\src\\dlei07.txt");//覆盖管道
                Writer fw = new FileWriter("day03-file-IO\\src\\dlei07.txt",true);//追加管道
                //2、创建一个缓冲字符输出流对象，把字符输出流对象作为构造参数传递给缓冲字符输出流对象
                BufferedWriter bw = new BufferedWriter(fw);
        ){
            //2、写一个字符
            bw.write('a');
            bw.write(98);
            bw.write('嘞');
            bw.newLine();//换行

            //3、写一个字符串出去：
            bw.write("许嵩");
            bw.write("我爱赵敏，虽然小昭也很可爱！");
            bw.newLine();//换行

            //4、写一个字符串的一部分出去：
            bw.write("java",1,2);
            bw.newLine();//换行

            //5、写一个字符数组出去：
            bw.write("许嵩".toCharArray());
            bw.newLine();//换行

            //6、写一个字符数组的一部分出去：
            bw.write("乾坤大挪移".toCharArray(),0,2);
            bw.newLine();//换行

            //fw.flush();//刷新缓冲区，将数据刷到目的地中
            //刷新后，流可以继续使用
            //fw.close();//关闭资源，关闭包含了刷新！关闭后流不能继续使用！

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
