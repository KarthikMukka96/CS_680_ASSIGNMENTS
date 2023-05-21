package edu.umb.cs680.hw06;

public class File extends FSElement{

    public File (Directory parent, String name, int size) {
        super(parent, name, size);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

}