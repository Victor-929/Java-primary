
package com.itheima.fileInput;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        //目标：掌握文件字节输入流读取文件中的字节数组到内存中来
        //1、创建文件字节输入流管道用于文件接通
//        InputStream is  = new FileInputStream(new File("day03-file-IO\\src\\dlei02.txt"));
        InputStream is  = new FileInputStream("day03-file-IO\\src\\dlei03.txt");//简化写法

        //2、读取文件中的字节并输出：每次读取多个代码
        //定义一个字节数组用于每次读取字节
//        byte[] buffer = new byte[1024];//1024个字节，1KB
        byte[] buffer = new byte[3];
        //定义一个变量记住每次读取了多少个字节
        int len;
        while((len = is.read(buffer)) != -1){
            //3、把读取的字节数组转换成字符串输出,读取多少倒出多少

            System.out.print(new String(buffer,0,len));
        }
        //扩展：每次读取多少个字节，性能得到提升，因为每次读取多少个字节，可以减少硬盘和内存的交流次数，从而提升性能
        //依然无法避免读取汉字输出乱码的问题：存在截断汉字字节的可能性！
    }
}
