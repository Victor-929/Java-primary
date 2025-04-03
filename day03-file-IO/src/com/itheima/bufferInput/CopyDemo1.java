package com.itheima.bufferInput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyDemo1 {

    // 缓冲区大小（可以根据实际需求调整）
    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) {
        // 示例路径，建议通过参数化或配置文件动态传入
        String srcPath = "F:\\resource\\aaa\\640.jfif";
        String destPath = "F:\\resource\\kkk\\640.jfif";

        try {
            // 验证源文件是否存在
            if (!Files.exists(Paths.get(srcPath))) {
                throw new IllegalArgumentException("源文件不存在: " + srcPath);
            }

            // 验证目标路径是否可写
            if (!Files.isWritable(Paths.get(destPath).getParent())) {
                throw new IllegalArgumentException("目标路径不可写: " + destPath);
            }

            copyFile(srcPath, destPath);
        } catch (Exception e) {
            // 更友好的异常处理
            System.err.println("文件复制失败: " + e.getMessage());
            e.printStackTrace(); // 保留堆栈信息以便调试
        }
    }

    public static void copyFile(String srcPath, String destPath) throws Exception {
        try (
                InputStream fis = new FileInputStream(srcPath);
                //把低级的流升级为高级的缓冲流
                InputStream bis = new BufferedInputStream(fis);
                OutputStream fos = new FileOutputStream(destPath);
                // 把低级的流升级为高级的缓冲流
                OutputStream bos = new BufferedOutputStream(fos)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            System.out.println("文件复制成功: " + destPath);
        }
    }
}

