package Structural.Composite11;

import Structural.Composite11.com.Dir;
import Structural.Composite11.com.File;
import Structural.Composite11.com.IFile;

import java.util.List;

/**
 * Created by asus on 2017/11/20.
 */
public class MainClass {

    public static void main(String[] args) {
        IFile rootDir = new Dir("root");

        IFile subDir = new Dir("www");;

        IFile file = new File("wu.txt");

        IFile file1 = new File("wxx.txt");

        subDir.add(file1);
        rootDir.add(subDir);
        rootDir.add(file);

        displayDir(rootDir);

    }

    public static void displayDir(IFile dir){
        dir.display();
        List<IFile> children = dir.getChildren();
        for(IFile file:children){
           if(file instanceof File){
               file.display();
           }else{
               displayDir(file);
           }
       }
    }

}
