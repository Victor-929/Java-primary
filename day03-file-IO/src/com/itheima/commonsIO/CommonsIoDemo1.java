package com.itheima.commonsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommonsIoDemo1 {
    public static void main(String[] args) throws Exception {
        //目标：IO框架
        FileUtils.copyFile(new File("day03-file-IO\\src\\ps.txt"), new File("day03-file-IO\\src\\ps2.txt"));

        //Files.copy(Path.of("day03-file-IO\\src\\ps.txt"), Path.get("day03-file-IO\\src\\ps3.txt"));

        FileUtils.deleteDirectory(new File("E:\\MyDailyWork\\bbb - 副本"));
    }
}
