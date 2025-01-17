package edu.umb.cs680.hw14.fs.sortingpolicies;

import edu.umb.cs680.hw14.fs.FSElement;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getName().compareTo(o1.getName());
    }

}
