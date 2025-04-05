package com.itheima.bufferWrite;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TimerTest3 {
    private static final String SRC_FILE = "E:\\MyDailyWork\\aaa\\零经费 自拍《三体2：黑暗森林》（自制动画）第05集.mp4";
    private static final String DST_FILE = "E:\\MyDailyWork\\bbb\\";
    public static void main(String[] args) {
        //目标：缓冲流，低级流的性能分析
        //使用低级的字节流按照一个一个字节的形式复制文件：非常慢，简直让人无法忍受，直接淘汰，禁止使用！！
//        copyFile1();

        //使用低级的字节流按照字节数组的形式复制文件：比低级流快，还可以接受
        copyFile2();

        //使用高级的缓冲字节流按照一个一个字节的形式复制文件：虽然是高级管道，但一个一个字节的复制还是太慢了，直接淘汰
//        copyFile3();

        //使用高级的缓冲字节流按照字节数组的形式复制文件：非常快！推荐使用！
        copyFile4();
    }
    //使用低级的缓冲字节流按照一个一个字节的形式复制文件
    public static void copyFile1(){
        //拿系统当前时间
        long start = System.currentTimeMillis();//此刻时间时间毫秒值：从1970-1-1 00:00:00到当前时间的毫秒值
        try (
                FileInputStream fis = new FileInputStream(SRC_FILE);
                FileOutputStream fos = new FileOutputStream(DST_FILE + "1、零经费 自拍《三体2：黑暗森林》（自制动画）第05集.mp4");
                ){
            int b;
            while((b = fis.read()) != -1){
                fos.write(b);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();//此刻时间时间毫秒值：从1970-1-1 00:00:00到当前时间的毫秒值 1s=1000ms
        System.out.println("使用低级的缓冲字节流按照一个一个字节的形式复制文件花费的时间：" + (end - start)/1000 + "s");
    }

    //使用低级的字节流按照字节数组的形式复制文件
    public static void copyFile2(){
        //拿系统当前时间
        long start = System.currentTimeMillis();//此刻时间时间毫秒值：从1970-1-1 00:00:00到当前时间的毫秒值
        try (
                FileInputStream fis = new FileInputStream(SRC_FILE);
                FileOutputStream fos = new FileOutputStream(DST_FILE + "2、零经费 自拍《三体2：黑暗森林》（自制动画）第05集.mp4");
        ){
            byte[] buffer = new byte[1024*8];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();//此刻时间时间毫秒值：从1970-1-1 00:00:00到当前时间的毫秒值 1s=1000ms
        System.out.println("使用低级的字节流按照字节数组的形式复制文件花费的时间：" + (end - start) / 1000 + "s");
    }

    //使用高级的缓冲流字节按照一个一个字节的形式复制文件
    public static void copyFile3(){
        //拿系统当前时间
        long start = System.currentTimeMillis();//此刻时间时间毫秒值：从1970-1-1 00:00:00到当前时间的毫秒值
        try (
                FileInputStream fis = new FileInputStream(SRC_FILE);
                FileOutputStream fos = new FileOutputStream(DST_FILE + "3、零经费 自拍《三体2：黑暗森林》（自制动画）第05集.mp4");
                //1、创建字节缓冲输入流与源文件接通
                BufferedInputStream bis = new BufferedInputStream(fis);
                //2、创建字节缓冲输出流与目标文件接通
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ){
            int b;
            while((b = bis.read()) != -1){
                bos.write(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用高级的缓冲流字节按照一个一个字节的形式复制文件花费的时间：" + (end - start)/1000 + "s");
    }

    //使用高级的缓冲字节流按照字节数组的形式复制文件
    public static void copyFile4(){
        //拿系统当前时间
        long start = System.currentTimeMillis();//此刻时间时间毫秒值：从1970-1-1 00:00:00到当前时间的毫秒值
        try (
                FileInputStream fis = new FileInputStream(SRC_FILE);
                FileOutputStream fos = new FileOutputStream(DST_FILE + "4、零经费 自拍《三体2：黑暗森林》（自制动画）第05集.mp4");
                //1、创建字节缓冲输入流与源文件接通
                BufferedInputStream bis = new BufferedInputStream(fis);
                //2、创建字节缓冲输出流与目标文件接通
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ){
            byte[] buffer = new byte[1024*8];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用高级的缓冲字节流按照字节数组的形式复制文件花费的时间：" + (end - start)/1000 + "s");
    }
}
