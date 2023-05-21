package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.FileSystem;
import edu.umb.cs680.hw12.fs.Link;

public class TestFixtureInitializer {

    private static FileSystem fs;

    public static void createFS() {
        fs = FileSystem.getFileSystem();
        Directory root = new Directory(null, "prjRoot");
        Directory src = new Directory(root, "src");
        Directory lib = new Directory(root, "lib");
        Directory test = new Directory(root, "test");
        File x = new File(root, "x", 30);
        File a = new File(src, "a", 10);
        File b = new File(src, "b", 20);
        File c = new File(lib, "c", 10);
        Directory src1 = new Directory(test, "src");
        File d = new File(src1, "d", 30);
        Link y = new Link(root, "y", src1);

        fs.appendRoot(root);
    }

    public static FileSystem getFS() {
        if (fs == null) {
            createFS();
        }
        return fs;
    }
}
