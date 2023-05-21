package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {
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
    void testOnRoot() {
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);
        assertEquals(5, visitor.getDirNum() );
        assertEquals(5, visitor.getFileNum() );
        assertEquals(1, visitor.getLinkNum() );
    }

    @Test
    void testOnLib() {
        CountingVisitor visitor = new CountingVisitor();
        lib.accept(visitor);
        assertEquals(1, visitor.getDirNum() );
        assertEquals(1, visitor.getFileNum() );
        assertEquals(0, visitor.getLinkNum() );
    }


}