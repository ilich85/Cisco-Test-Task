package com.ilich.gnode;

class GNodeAddChild {

    void add(GNodeImpl parent, GNode child) {
        parent.setChildren(child);
    }
}