package edu.umb.cs680.hw07;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FSElement {

    private List<FSElement> children = new ArrayList<>();

    public Directory(Directory parent, String name) {
        super(parent, name, 0);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public List<FSElement> getChildren() {
        return children;
    }

    public void addChild(FSElement child) {
        children.add(child);
    }

    public int getNumberOfChildren() {
        return children.size();
    }

    public List<Directory> getSubDirectories() {
        List<Directory> subDirectories = new ArrayList<>();
        for (FSElement element : children) {
            if (element instanceof Directory) {
                subDirectories.add((Directory) element);
            }
        }
        return subDirectories;
    }

    public String getParentName() {
        return (parent != null) ? parent.getName() : "null";
    }

    public List<String> getDirInStringList() {
        return List.of(name, getParentName(), Long.toString(size), Integer.toString(creationTime.getYear()));
    }

    public List<File> getSubFiles() {
        List<File> subDirectories = new ArrayList<>();
        for (FSElement element : children) {
            if (element instanceof File) {
                subDirectories.add((File) element);
            }
        }
        return subDirectories;
    }




    public long getTotalSize() {
        long totalSize = this.getSize();
        for (FSElement element : children) {
            if (element instanceof Directory) {
                totalSize += ((Directory) element).getTotalSize();
            } else {
                totalSize += element.getSize();
            }
        }
        return totalSize;
    }
}
