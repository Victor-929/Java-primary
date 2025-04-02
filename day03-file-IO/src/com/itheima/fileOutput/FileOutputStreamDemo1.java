package com.itheima.fileOutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //目标：学会使用文件字节输出流
        //1、创建文件字节输出流管道与目标文件接通
        OutputStream os = new FileOutputStream("day03-file-IO\\src\\dlei04.txt");

        //2、写入数据
        os.write(97);//写入一个字节数据
        os.write('b');//写入一个字符数据
//        os.write('许');//写入一个字符数据 会乱码
        os.write("\r\n".getBytes());//换行
        //3、写一个字节数组出去
        //byte[] buffer = {97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122};
        byte[] bytes = "我爱你中国".getBytes();
        os.write(bytes);

        //4、写一个字节数组的一部分出去
        os.write(bytes,0,3);
    }

}
