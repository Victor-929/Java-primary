package com.itheima.fileWriter;

import java.io.FileWriter;
import java.io.Writer;

public class FileWriterDemo1 {
    public static void main(String[] args) {
        //目标：搞清楚文件字符输出流的使用，写字符出去的流
        try(
                //1、创建一个字符输出流对象，指定写出的目的地
//                Writer fw = new FileWriter("day03-file-IO\\src\\dlei07.txt");//覆盖管道
                Writer fw = new FileWriter("day03-file-IO\\src\\dlei07.txt",true);//追加管道
        ){
            //2、写一个字符
            fw.write('a');
            fw.write(98);
            fw.write('嘞');
            fw.write("\r\n");

            //3、写一个字符串出去：
            fw.write("许嵩");
            fw.write("我爱赵敏，虽然小昭也很可爱！");
            fw.write("\r\n");

            //4、写一个字符串的一部分出去：
            fw.write("java",1,2);
            fw.write("\r\n");

            //5、写一个字符数组出去：
            fw.write("许嵩".toCharArray());
            fw.write("\r\n");

            //6、写一个字符数组的一部分出去：
            fw.write("乾坤大挪移".toCharArray(),0,2);
            fw.write("\r\n");

            //fw.flush();//刷新缓冲区，将数据刷到目的地中
            //刷新后，流可以继续使用
            //fw.close();//关闭资源，关闭包含了刷新！关闭后流不能继续使用！

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
