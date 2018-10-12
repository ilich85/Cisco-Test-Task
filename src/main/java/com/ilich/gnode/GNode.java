package com.ilich.gnode;

import java.util.ArrayList;

public interface GNode {

    String getName();

    GNode[] getChildren();

    void addChild(GNode child);

    ArrayList paths(GNode gNode);

    ArrayList walkGraph(GNode gNode);
}