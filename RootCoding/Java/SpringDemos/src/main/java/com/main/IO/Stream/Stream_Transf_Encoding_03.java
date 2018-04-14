package com.main.IO.Stream;

import java.io.*;

public class Stream_Transf_Encoding_03 {
    public static void main(String[] args) {

        System.out.println("平台默认编码:" + System.getProperty("file.encoding"));
        try {
            testEncoding();
            testConvertStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 编码  字符char -->> 字节byte
     * 解码  字节byte -->> 字符char
     */
    public static void testEncoding() {

        System.out.println("平台默认编码:" + System.getProperty("file.encoding"));  //todo
        String str = "中国人";    //平台默认的GBK
        //编码  char -->byte
        byte[] data = str.getBytes();
        //解码  byte -->char
        try {
            System.out.println(new String(data, "GBK"));      //中国人
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            //编码  todo
            data = str.getBytes("UTF-8");
            //解码  todo
            System.out.println(new String(data, "UTF-8"));   //中国人
        } catch (Exception e) {

        }
    }

    /**
     * 转换流:用于解决乱码
     * //todo 转换流 FileReader   FileWriter  InputStreamReader  InputStreamWriter ，输入输出时指定字符集
     * 1、输入流 InputStreamReader   解码
     * 2、输出流OutputStreamWriter  编码
     */
    public static void testConvertStream() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(   //用转换流处理输入流
                        new FileInputStream(new File("C:\\Users\\asus\\git\\springBean\\src\\main\\java\\com\\main\\IO\\Stream\\Stream_Encoding_003.java")), "UTF-8")  //由于此java文件默认GBK
        );
        String str = null;
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(new File("F:/1.java")), "UTF-8")   //写入编码指定为UTF-8
        );
        while (null != (str = br.readLine())) {
            System.out.println(str);         //打印本程序的代码
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
    }


}
