package Structural.Composite11.com;

import java.util.List;

/**
 * Created by asus on 2017/11/20.
 */
public class File implements IFile{
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("file name:"+name);
    }

    public void add(IFile file) {

    }

    public void remove(IFile file) {

    }

    public List<IFile> getChildren() {
        return null;
    }


}
