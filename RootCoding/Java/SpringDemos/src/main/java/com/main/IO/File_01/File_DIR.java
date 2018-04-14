package com.main.IO.File_01;

import java.io.*;

/**
 * Created by asus on 2016/12/27.
 */
public class File_DIR {
    public static void main(String[] args) {

    }

    public static void testFile() throws IOException, InterruptedException {
        //与目录和文件建立联系
        File file = new File("1.txt");   // E:\worspace8\JavaSe\1.txt
        file = new File("E:" + File.separator + "1.txt");   //separator 跨平台分隔符  todo
        file = new File("E:", "1.txt");
        file = new File(new File("E:"), "1.txt");

        //获取文件名和路径
        file.getName();   //返回文件名
        file.getPath();   //如果是相对路径返回相对路径，如果是绝对路径返回绝对路径
        file.getAbsolutePath();   //返回绝对路径
        file.getParent();         //返回上级目录,如果是相对路径,返回null      TODO

        //判断信息
        file.exists();
        file.canRead();
        file.canWrite();
        file.canExecute();
        file.isFile();
        file.isDirectory();  //没有真实存在的默认为文件夹
        file.isHidden();
        file.isAbsolute();   //判断是否是相对路径
        file.length();       //文件的字节数,文件夹为0
        file.lastModified(); //最后修改时间

        //创建文件和删除文件
        file.createNewFile();
        file.delete();

        //创建和删除临时文件     :前缀和后缀可以自己加,父目录默认为系统临时文件目录
        File temp = File.createTempFile("test", ".tep", new File("F:/test"));
        temp = File.createTempFile("test", ".temp");
        System.out.println(temp.getAbsolutePath());
        Thread.sleep(10000);
        temp.deleteOnExit();    //退出就删除

        //操作目录
        file.mkdir();      //必须确保父目录存在
        file.mkdirs();     //父目录不存在一同创建
        file.list();       //子文件和子目录的名称  以字符串数组的形式返回
        file.listFiles();  //子文件盒子目录  以File数组的形式返回
        file.renameTo(new File("d:\\dir\\2.txt"));   //用于移动文件

        //TODO 重写accept方法，对传入的File对象进行判断，返回true的对象加入list
        File[] list = file.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {  //dir相当与file路径
                return new File(dir, name).isFile() && name.endsWith(".java");
            }
        });
    }

    //TODO
    public static void readWrite(String src, String dist) throws Exception {
        FileInputStream in = new FileInputStream(src);
        File file = new File(dist);
        if (!file.exists())
            file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        int c;
        byte buffer[] = new byte[1024];
        //*********Read to buffer return num to C*********
        while ((c = in.read(buffer)) != -1) {
            for (int i = 0; i < c; i++)
                out.write(buffer[i]);
        }
        in.close();
        out.close();
    }

    //递归显示Dir
    public static void showDir(File dir) {
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                showDir(file);
            else
                System.out.println(file);
        }
    }

    //递归打印所以子文件和子目录  file.listFiles()
    public static void testPrintFile(File path) {
        testPrintFile(path, 0);
    }

    public static void testPrintFile(File path, int i) {
        if (path == null || !path.exists()) {
            return;
        }
        for (int j = 0; j <= i; j++) {
            System.out.print("--");
        }
        System.out.println((i == 0 ? path.getAbsolutePath() : path.getName()));
        if (path.isDirectory()) {
            i++;
            for (File temp : path.listFiles()) {
                testPrintFile(temp, i);
            }
        }
    }

}
