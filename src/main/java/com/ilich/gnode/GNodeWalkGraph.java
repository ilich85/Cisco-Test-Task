package com.ilich.gnode;

class GNodeWalkGraph {

    void printNodes(GNode node) {
        GNodeProcess paths = new GNodeProcess();
        System.out.println(paths.paths(node));
    }
}