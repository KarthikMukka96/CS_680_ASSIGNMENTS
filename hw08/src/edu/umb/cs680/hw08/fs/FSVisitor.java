package edu.umb.cs680.hw08.fs;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;

public interface FSVisitor {
    public abstract void visit(Link link);
    public abstract void visit(Directory dir);
    public abstract void visit(File file);
}
