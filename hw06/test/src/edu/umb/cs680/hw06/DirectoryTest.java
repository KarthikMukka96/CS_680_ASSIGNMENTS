package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

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
    void getDirInStringListOnRoot() {
        assertIterableEquals(
                List.of("prjRoot", "null", "0", "2023")
                ,root.getDirInStringList()
        );
    }

    @Test
    void getDirInStringListOnLib() {
        assertIterableEquals(
                List.of("lib","prjRoot", "0", "2023")
                ,lib.getDirInStringList()
        );
    }

    @Test
    void getDirInStringListOnTest() {
        assertIterableEquals(
                List.of("test","prjRoot", "0", "2023")
                ,test.getDirInStringList()
        );
    }

    @Test
    void getDirInStringListOnSRC() {
        assertIterableEquals(
                List.of("src","prjRoot", "0", "2023")
                ,src.getDirInStringList()
        );
    }

    @org.junit.jupiter.api.Test
    void isDirectory() {
        assert(root.isDirectory());
        assert(src.isDirectory());
        assert(src1.isDirectory());
        assert(lib.isDirectory());
        assert(test.isDirectory());
    }

    @org.junit.jupiter.api.Test
    void getChildrenOnRoot() {
        ArrayList<FSElement> children = new ArrayList<>(List.of(src, lib, test, x));
        assertIterableEquals(children, root.getChildren());
    }

    @org.junit.jupiter.api.Test
    void getChildrenOnSRC() {
        ArrayList<FSElement> children = new ArrayList<>(List.of(a, b));
        assertIterableEquals(children, src.getChildren());
    }

    @org.junit.jupiter.api.Test
    void getChildrenOnTest() {
        ArrayList<FSElement> children = new ArrayList<>(List.of(src1));
        assertIterableEquals(children, test.getChildren());
    }

    @org.junit.jupiter.api.Test
    void getChildrenOnLib() {
        ArrayList<FSElement> children = new ArrayList<>(List.of(c));
        assertIterableEquals(children, lib.getChildren());
    }

    @org.junit.jupiter.api.Test
    void getNumberOfChildren() {
        assertEquals(4, root.getNumberOfChildren());
        assertEquals(2, src.getNumberOfChildren());
        assertEquals(1, test.getNumberOfChildren());
        assertEquals(1, lib.getNumberOfChildren());
    }

    @org.junit.jupiter.api.Test
    void getSubDirectoriesOnTest() {
        ArrayList<FSElement> children = new ArrayList<>(List.of(src1));
        assertIterableEquals(children, test.getSubDirectories());
    }

    @org.junit.jupiter.api.Test
    void getSubDirectoriesOnLib() {
        ArrayList<FSElement> children = new ArrayList<>();
        assertIterableEquals(children, lib.getSubDirectories());
    }

    @org.junit.jupiter.api.Test
    void getSubFilesOnLib() {
        ArrayList<FSElement> children = new ArrayList<>(List.of(c));
        assertIterableEquals(children, lib.getSubFiles());
    }


    @org.junit.jupiter.api.Test
    void getTotalSize() {
        assertEquals(100, root.getTotalSize());
    }
}