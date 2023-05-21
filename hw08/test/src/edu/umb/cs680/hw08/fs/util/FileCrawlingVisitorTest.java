package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.FileSystem;
import edu.umb.cs680.hw08.fs.Link;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {

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

    private static Link y;


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
        y = (Link) root.getChildren().get(4);
    }

    @Test
    void testOnROOTForFiles() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);
        ArrayList<File> found = new ArrayList<>(List.of(a, b, c ,d, x));
        assertIterableEquals(found, visitor.allFiles);
    }

    @Test
    void testOnXForFiles() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        x.accept(visitor);
        ArrayList<File> found = new ArrayList<>(List.of(x));
        assertIterableEquals(found, visitor.allFiles);
    }

    @Test
    void testOnYForFiles() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        y.accept(visitor);
        ArrayList<File> found = new ArrayList<>(List.of());
        assertIterableEquals(found, visitor.allFiles);
    }

}