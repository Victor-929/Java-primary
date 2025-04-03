package com.itheima.bufferWrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BufferWriteDemo2 {
    public static void main(String[] args) {
        //目标：完成出师表的案例。
        //1、创建一个缓冲输入流对象和文件链接
        try (
                BufferedReader br = new BufferedReader(new FileReader("day03-file-IO\\src\\csb.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("day03-file-IO\\src\\csb2.txt"));

        ) {
            //2、提前准备一个List集合存储每段内容
            List<String> data = new ArrayList<>();
            String line = null;
            while ((line = br.readLine()) != null){
                data.add(line);
            }
            //4、给集合中的每段内容，按照首字符排序
            Collections.sort(data);
            System.out.println(data);
            //5、遍历集合，输出到控制台
            for (String s : data) {
                bw.write(s);
                bw.newLine();//换行
            }

            System.out.println("over");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
