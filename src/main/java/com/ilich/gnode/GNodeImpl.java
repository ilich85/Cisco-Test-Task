package com.ilich.gnode;

import java.util.ArrayList;
import java.util.List;

public class GNodeImpl implements GNode {

    private String name;
    private List<GNode> children = new ArrayList<>();

    GNodeImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public GNode[] getChildren() {
        return children.toArray(new GNode[0]);
    }

    void add(GNode child) {
        this.setChildren(child);
    }

    private void setChildren(GNode children) {
        this.children.add(children);
    }

    @Override
    public String toString() {
        return name;
    }
}