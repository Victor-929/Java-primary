package com.itheima.printStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataStreamDemo2 {
    public static void main(String[] args) {
        //目标：特殊数据流的使用
        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("day03-file-IO\\src\\dlei10.txt"));
                ){
                dos.writeByte(97);
                dos.writeChar('a');
                dos.writeBoolean(true);
                dos.writeDouble(3.14);
                dos.writeUTF("你好");
                dos.writeInt(100);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
