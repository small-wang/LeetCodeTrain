package com.ww.photoClassify;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @since 2022/7/10 21:51
 */
public class Main {

    private static String input = null;

    public static void main(String[] args) {
        if (null == args || args.length != 1) {
            System.out.println("请输入照片/目录地址");
            return;
        }

        input = args[0];
        File photo = new File(input);
        if (photo.exists()) {
            if (photo.isDirectory()) {
                // 输入的是照片目录
                System.out.println("输入的照片目录地址为：" + input);
                classifyDirectory(photo);
            } else if (photo.isFile()) {
                // 输入的是照片
                System.out.println("输入的照片地址为：" + input);
                return;
            } else {
                // 非法的输入
                System.out.println("输入的照片目录地址不正确：" + input);
                return;
            }
        } else {
            // 输入的照片/目录地址不存在
            System.out.println("输入的照片目录地址不存在：" + input);
            return;
        }
    }

    // 文件夹里的文件分类
    private static void classifyDirectory(File photo) {
        if (photo.exists()) {
            if (photo.isDirectory()) {
                File[] files = photo.listFiles();
                for(int i = 0; i < files.length; i++) {
                    classifyDirectory(files[i]);
                }
            } else if (photo.isFile()) {
                classifyFile(photo);
            } else {
                // 非法的输入
                System.out.println("输入的照片目录地址不正确：" + input);
                return;
            }
        }
    }

    // 单个文件分类
    private static void classifyFile(File photo) {
        String fileUpdateAt = getUpdateDate(photo);
        String filePath = genPath(fileUpdateAt);
        String fileName = genFileName(photo.getName(), filePath);
        boolean success = photo.renameTo(new File(fileName));
        if (!success) {
            try {
                System.out.println("文件移动失败：" + photo.getCanonicalPath() + ", 至：" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 生成文件名：新的文件存储路径 + 原文件名
    private static String genFileName(String fileName, String filePath) {
        StringBuffer stringBuffer = new StringBuffer(filePath);
        stringBuffer.append(File.separator).append(fileName);
        return stringBuffer.toString();
    }

    // 生成文件存储路径：input + 文件更新日期
    private static String genPath(String fileUpdateAt) {
        StringBuffer stringBuffer = new StringBuffer(input);
        stringBuffer.append(File.separator).append(fileUpdateAt);
        File file = new File(stringBuffer.toString());
        if (!file.exists()) {
            file.mkdir();
        }
        return stringBuffer.toString();
    }

    // 获取文件更新日期
    private static String getUpdateDate(File file) {
        Instant time = Instant.ofEpochMilli(file.lastModified());
        ZonedDateTime zonedDateTime = time.atZone(ZoneId.of("Asia/Shanghai"));
        return String.valueOf(zonedDateTime.toLocalDate().getYear());
    }
}
