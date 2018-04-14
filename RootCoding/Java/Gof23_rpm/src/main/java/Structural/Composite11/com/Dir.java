package Structural.Composite11.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/11/20.
 */
public class Dir implements IFile{
    private String name;
    List<IFile> children;

    public Dir(String name) {
        this.name = name;
        this.children = new ArrayList<IFile>();
    }

    public void display() {
        System.out.println("dir name:"+name);
    }

    public void add(IFile file) {
        children.add(file);
    }

    public void remove(IFile file) {
        children.remove(file);
    }

    public List<IFile> getChildren() {
        return children;
    }
}
