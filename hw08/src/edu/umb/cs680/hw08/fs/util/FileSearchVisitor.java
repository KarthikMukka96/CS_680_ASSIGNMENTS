package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSVisitor;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {

    private String fileName;
    private LinkedList<File> foundFiles = new LinkedList<>();

    public FileSearchVisitor(String targetFileToFind) {
        this.fileName = targetFileToFind;
    }
    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        if (this.fileName.equals(file.getName())) {
            this.foundFiles.add(file);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }
}
