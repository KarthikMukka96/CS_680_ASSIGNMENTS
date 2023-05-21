package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem singleInstance;
    private LinkedList<Directory> root = new LinkedList<>();

    private FileSystem() {

    }

    public static FileSystem getFileSystem() {
        if(singleInstance == null) {
            singleInstance = new FileSystem();
        }
        return singleInstance;
    }

    public void appendRoot(Directory dir) {
        this.root.add(dir);
    }

    public LinkedList<Directory> getRootDirs() {
        return this.root;
    }


}