package com.dett.dettmvvm.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Describe
 *
 * @author wangjian
 * Created on 2020/10/17 14:49
 */
public class Utils {

    /**
     * 保存流到文件中
     *
     * @param inputStream 输入流
     * @param path 文件地址
     * @return 是否保存成功
     */
    public static boolean writeInputStream2File(InputStream inputStream, String path) {
        boolean result = true;
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            fileOutputStream = new FileOutputStream(new File(path));
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[4096 * 2];
            int bytesRead = 0;
            while ((bytesRead = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }
            bufferedOutputStream.flush();
        } catch (Exception e) {
            result = false;
        } finally {
            closeIO(bufferedInputStream, inputStream, fileOutputStream, bufferedOutputStream);
        }
        return result;
    }

    /**
     * 关闭IO, 先打开的先关闭，后打开的后关闭
     * 另一种情况：看依赖关系，如果流a依赖流b，应该先关闭流a，再关闭流b
     * https://blog.csdn.net/shijinupc/article/details/7191655
     *
     * @param closeables closeable
     */
    public static void closeIO(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
