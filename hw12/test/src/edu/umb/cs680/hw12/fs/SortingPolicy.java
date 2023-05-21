package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.fs.sortingpolicies.AlphabeticalComparator;
import edu.umb.cs680.hw12.fs.sortingpolicies.ReverseAlphabeticalComparator;
import edu.umb.cs680.hw12.fs.sortingpolicies.SizeComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortingPolicy {

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
        src = (Directory) root.getChildren().get(1);
        lib = (Directory) root.getChildren().get(0);
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
    public void testIfChildrenOfRootDirectoryAreSortedDefaultly() {

        List<FSElement> expectation = new ArrayList<>(List.of(lib, src,test ,x,y));
        assertIterableEquals(expectation, root.getChildren());
    }

    @Test
    public void testAlphabeticalComparatorOnRootDirectoryChildren() {
        List<FSElement> expectation = new ArrayList<>(List.of(lib, src,test ,x,y));
        assertIterableEquals(expectation, root.getChildren(new AlphabeticalComparator()));
    }

    @Test
    public void testReverseAlphabeticalComparatorOnRootDirectoryChildren() {
        List<FSElement> expectation = new ArrayList<>(List.of(y, x, test, src, lib));
        assertIterableEquals(expectation, root.getChildren(new ReverseAlphabeticalComparator()));
    }

    @Test
    public void testSizeComparatorOnRootDirectoryChildren() {
        List<FSElement> expectation = new ArrayList<>(List.of(lib, src,test ,y,x));
        assertIterableEquals(expectation, root.getChildren(new SizeComparator()));
    }

    @Test
    public void testSizeComparatorOnTestDirectoryChildren() {
        List<FSElement> expectation = new ArrayList<>(List.of(src1));
        assertIterableEquals(expectation, test.getChildren(new SizeComparator()));
    }


}
