package com.itheima.printStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamDemo3 {
    public static void main(String[] args) {
        //目标：特殊数据流的使用
        try(
                DataInputStream dos = new DataInputStream(new FileInputStream("day03-file-IO\\src\\dlei10.txt"));
                ){
            System.out.println(dos.readByte());
            System.out.println(dos.readChar());
            System.out.println(dos.readBoolean());
            System.out.println(dos.readDouble());;
            System.out.println(dos.readUTF());
            System.out.println(dos.readInt());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
