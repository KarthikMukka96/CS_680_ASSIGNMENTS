package edu.umb.cs680.hw07;

public class Link extends FSElement{

    private FSElement target;

    public Link(Directory parent, String name, FSElement target) {
        super(parent, name, 0);
        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public FSElement getTarget() {
        return target;
    }
}

