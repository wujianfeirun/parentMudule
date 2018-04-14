package com.main.IO.Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by asus on 2016/12/29.
 */
public class Stream_Buffer_02 {

    public static void main(String[] args) throws Exception {
        BufferedWriterTest();
    }

    public static void BufferedWriterTest() throws Exception {
        FileWriter fr = new FileWriter("D:\\test.txt");
        BufferedWriter bf = new BufferedWriter(fr);
        //这里进行读取
        String b = "sssssssssssssssss\n";
        bf.newLine();
        bf.write(b);
        bf.newLine();
        bf.append(b);
        bf.newLine();
        bf.close();
    }

    public void BufferedReaderTest() throws Exception {
        FileReader fr = new FileReader("C:\\Users\\asus\\git\\springBean\\src\\main\\java\\com\\main\\IO\\Stream\\Stream_Buffer_02.java");
        BufferedReader bf = new BufferedReader(fr);
        //这里进行读取
        String b;
        while ((b = bf.readLine()) != null) {
            System.out.println(b);
        }
        bf.close();
        fr.close();
    }

}
