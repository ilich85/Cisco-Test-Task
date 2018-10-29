package com.ilich.gnode;

class GNodePaths {

    void printPaths(GNode node) {
        GNodeProcess process = new GNodeProcess();
        System.out.println(process.paths(node));
    }
}
