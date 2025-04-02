package com.itheima.file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        //目标：创建File创建对象代表文件（文件/目录），搞清楚其提供的对文件进行操作的方法
        //1、创建File对象，去获取某个文件的信息
//        File f1 = new File("F:\\resource\\640.jfif");
        File f1 = new File("F:/resource/640.jfif");

        System.out.println(f1.length());
        System.out.println(f1.getName());
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());

        //2、可以使用相对路径定位文件目录
        //只要带盘符的都称为绝对路径F:/resource/640.jfif
        //相对路径：不带盘符，默认是到你工程下直接寻找文件的，一般用来找工程下项目文件的

        File f2 = new File("day03-file-IO\\src\\dile.txt");
        System.out.println(f2.length());

        //3、创建对象代表不存在的文件路径
        File f3 = new File("F:/resource/dile.txt");
        System.out.println(f3.exists());//判断是否存在
        System.out.println(f3.createNewFile());//把这个文件创建出来

        //4、创建对象代表不存在的文件夹路径
        File f4 = new File("F:/resource/dile");
        System.out.println(f4.mkdir());//mkdir只能创建一级文件夹

        File f5 = new File("F:/resource/kkk/jjj/mmm");
        System.out.println(f5.mkdirs());//mkdirs可以创建多级文件夹，很重要！

        //5、创建file对象代表存在的文件，然后删除它
        File f6 = new File("F:/resource/dile.txt");
        System.out.println(f6.delete());//删除文件

        //6、创建file对象代表存在的文件夹，然后删除它
        File f7 = new File("F:/resource/aaa");
        System.out.println(f7.delete());//只能删除空文件夹，不能删除非空文件夹

        //7、可以获取某个目录下的全部一级文件名称
        File f8 = new File("F:/resource/aaa");
        String[] names = f8.list();
        for (String name : names) {
            System.out.println(name);
        }

        File[] files = f8.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsoluteFile());//获取绝对路径
        }
    }
}
