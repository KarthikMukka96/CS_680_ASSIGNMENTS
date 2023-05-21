package edu.umb.cs680.hw14.fs;

import edu.umb.cs680.hw14.fs.sortingpolicies.AlphabeticalComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(children, new AlphabeticalComparator());
        return children;
    }

    public List<FSElement> getChildren(Comparator<FSElement> comparator) {
        List<FSElement> children = getChildren();
        Collections.sort(children, comparator);
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

    public List<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        List<Directory> subDirectories = getSubDirectories();
        Collections.sort(subDirectories, comparator);
        return subDirectories;
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
        for (FSElement child: children) {
            child.accept(visitor);
        }
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

    public List<File> getSubFiles(Comparator<FSElement> comparator) {
        List<File> subFiles = getSubFiles();
        Collections.sort(subFiles, comparator);
        return subFiles;
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
