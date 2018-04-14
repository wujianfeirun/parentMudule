package Structural.Composite11.com;

import java.util.List;

/**
 * Created by asus on 2017/11/20.
 */
public interface IFile {
    public void display();

    public void add(IFile file);

    public void remove(IFile file);

    public List<IFile> getChildren();


}
