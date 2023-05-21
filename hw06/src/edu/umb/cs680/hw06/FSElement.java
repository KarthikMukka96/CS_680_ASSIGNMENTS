package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class FSElement {
    protected String name;
    protected int size = 0;

    protected Directory parent;
    protected LocalDateTime creationTime;

    public FSElement(Directory parent, String name, int size) {
        if (parent != null) {
            parent.addChild(this);
        }
        this.name = name;
        this.size = size;
        this.creationTime = LocalDateTime.now();
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isDirectory();

}