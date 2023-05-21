package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSVisitor;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;

public class CountingVisitor implements FSVisitor {

    private int dirNum;
    private int linkNum;
    private int fileNum;

    @Override
    public void visit(Link link) {
        this.linkNum++;
    }

    @Override
    public void visit(Directory dir) {
        this.dirNum++;
    }

    @Override
    public void visit(File file) {
        this.fileNum++;
    }

    public int getLinkNum() {
        return linkNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getDirNum() {
        return dirNum;
    }
}
