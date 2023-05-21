package edu.umb.cs680.hw07;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FileTest {

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

    static List<String> getFileInStringList(File f) {
        return List.of(f.getName(), (f.getParent() != null) ? f.getParent().getName() : null, Integer.toString(f.getSize()), Integer.toString(f.getCreationTime().getYear()));
    }

    @Test
    void isDirectory() {
        assert (!x.isDirectory());
        assert (!a.isDirectory());
        assert (!b.isDirectory());
        assert (!c.isDirectory());
        assert (!d.isDirectory());
    }

    @Test
    void testOnA() {
        assertIterableEquals(
                List.of("a", "src", "10", "2023"),
                getFileInStringList(a)
        );
    }

    @Test
    void testOnX() {
        assertIterableEquals(
                List.of("x", "prjRoot", "30", "2023"),
                getFileInStringList(x)
        );
    }

    @Test
    void testOnB() {
        assertIterableEquals(
                List.of("b", "src", "20", "2023"),
                getFileInStringList(b)
        );
    }

    @Test
    void testOnC() {
        assertIterableEquals(
                List.of("c", "lib", "10", "2023"),
                getFileInStringList(c)
        );
    }

    @Test
    void testOnD() {
        assertIterableEquals(
                List.of("d", "src", "30", "2023"),
                getFileInStringList(d)
        );
    }
}
