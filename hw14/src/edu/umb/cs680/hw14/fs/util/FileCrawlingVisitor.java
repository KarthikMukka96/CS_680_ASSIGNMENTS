package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.FSVisitor;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

import java.util.LinkedList;

public class FileCrawlingVisitor  implements FSVisitor {

    public LinkedList<File> allFiles = new LinkedList<>();
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
        this.allFiles.add(file);
    }
}
