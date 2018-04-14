package com.main.IO.Stream;

import java.io.*;

public class Read_Write_01 {

    public static void main(String[] args) {
/*		try {
            testRead(new File("F:/1.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        testCopyFile();

    }

    //写一个拷贝整个文件夹的方法
    public static void testCopyDirs() {
        //TODO   写一个拷贝整个文件夹的方法
    }

    public static void testCopyFile() {
        File src = new File("F:/1.txt");
        File dest = new File("F:/2.txt");
        if (!dest.exists()) {
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream ins = null;
        OutputStream os = null;
        try {
            ins = new FileInputStream(src);
            os = new FileOutputStream(dest, true);
            byte[] buf = new byte[8];
            int len = 0;
            while (-1 != (len = ins.read(buf))) {   //注意要写出while
                os.write(buf, 0, len);
                os.flush();              //注意要flush
            }
        } catch (Exception e) {
            System.out.println("出错");
        } finally {
            try {
                os.close();   //先关输出流
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testRead(File src) throws Exception {
        if (!src.exists()) {
            System.out.println("文件不存在");
        }
        InputStream is = new FileInputStream(src);

        byte[] buf = new byte[5];
        int len = 0;
        //循环读取
        while (-1 != (len = is.read(buf))) {   //语法 :is.read(buf)的返回值赋给len之后判断len是否为-1,
            String str = new String(buf, 0, len);
            System.out.print(str);
        }

        if (null != is) {
            is.close();
        }
    }

    public static void testWrite(File dest) throws Exception {
        if (!dest.exists()) {
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建失败");
            }
        }
        OutputStream os = new FileOutputStream(dest, true);  //true表示以追加的形式写入 todo
        String str = "sssssssssssss\n";
        byte[] buf = str.getBytes();

        os.write(buf);
        os.flush();      //强制刷新

        if (null != os) {
            os.close();
        }
    }
}
