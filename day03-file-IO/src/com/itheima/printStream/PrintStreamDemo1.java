package com.itheima.printStream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo1 {
    public static void main(String[] args) {
        // 目标：打印流的使用
        try (
                //PrintStream ps = new PrintStream("day03-file-IO\\src\\ps.txt");
                //PrintWriter ps = new PrintWriter("day03-file-IO\\src\\ps.txt");
                // 启用追加模式 (append = true)
                PrintStream ps = new PrintStream(new FileOutputStream("day03-file-IO\\src\\ps.txt", true));
        ) {
            ps.println(97);
            ps.println('a');
            ps.println("hello");
            ps.println(true);
            ps.println(3.14);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
