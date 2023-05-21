package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    private static FileSystem filesystem;
    private static Directory root;

    private static Directory src;

    private static Directory lib;

    private static Directory test;

    private static Directory src1;

    private static File x;
    private static File a;
    private static File b;
    private static File c;
    private static File d;


    @BeforeAll
    static void initialize() {
        filesystem = TestFixtureInitializer.getFS();
        root = filesystem.getRootDirs().get(0);
        src = (Directory) root.getChildren().get(0);
        lib = (Directory) root.getChildren().get(1);
        test = (Directory) root.getChildren().get(2);
        src1 = (Directory) test.getChildren().get(0);
        x = (File) root.getChildren().get(3);
        a = (File) src.getChildren().get(0);
        b = (File) src.getChildren().get(1);
        c = (File) lib.getChildren().get(0);
        d = (File) src1.getChildren().get(0);
    }

    @Test
    void getFileSystem() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    void getRootDirs() {
        assertSame(root, filesystem.getRootDirs().get(0));
    }
}