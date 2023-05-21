package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

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
    void isDirectory() {
        assert(!y.isDirectory());
    }

    @Test
    void getTarget() {
        assertSame(src1, y.getTarget());
    }

    static List<String> getLinkInStringList(Link f) {
        return List.of(f.getName(), (f.getParent() != null) ? f.getParent().getName() : null, Integer.toString(f.getSize()), Integer.toString(f.getCreationTime().getYear()));
    }

    @Test
    void testLinktoStringList()
    {
        assertIterableEquals(
                List.of("y", "prjRoot", "0", "2023"),
                getLinkInStringList(y)
        );
    }
}