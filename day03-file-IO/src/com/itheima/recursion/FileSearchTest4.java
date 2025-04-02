package com.itheima.recursion;

import java.io.File;
import java.io.IOException;

public class FileSearchTest4 {
    public static void main(String[] args) {
        //目标：完成文件搜索，找出D:盘下的QQ.exe文件的位置
        try {
            System.out.println("开始搜索");
            File dir = new File("C:/");
            searchFile(dir,"msedge.exe");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param dir 搜索的目录
     * @param fileName 搜索的文件名称
     */
    public static void searchFile(File dir, String fileName) throws IOException {
        System.out.println("搜索目录："+dir.getAbsolutePath());
        //1、判断极端情况
        if(dir == null || !dir.exists() || !dir.isFile()){
            System.out.println("搜索失败，目录不存在");
            return;//不搜索
        }
        //2、获取目录下的一级文件或文件对象
        File[] files = dir.listFiles();
        //3、判断当前目录下是否存在一级文件对象，存在才可以遍历
        if(files != null && files.length > 0){
            //4、遍历一级文件对象，判断是文件还是文件夹
            for (File file : files) {
                if(file.isFile()){
                    //5、判断文件名称是否匹配
                    if(file.getName().contains(fileName)){
                        System.out.println("找到了文件："+file.getAbsolutePath());
                        Runtime r = Runtime.getRuntime();
                        r.exec(file.getAbsolutePath());
                    }
                }else{
                    //6、判断是文件夹，继续递归
                    searchFile(file,fileName);
                    System.out.println("继续递归："+file.getAbsolutePath());
                }
            }
        }
    }
}
