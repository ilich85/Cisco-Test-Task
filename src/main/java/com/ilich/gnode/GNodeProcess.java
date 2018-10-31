package com.ilich.gnode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

class GNodeProcess {

    private GNode prevNode;
    private GNodePrinter printer = new GNodePrinter();
    private List<GNode> path = new ArrayList<>();
    private List<ArrayList> paths = new ArrayList<>();
    private Map<String, Integer> nodes = new HashMap<>();

    int printNodes(GNode node) {
        process(node);
        printer.printMap(nodes);
        return nodes.size();
    }

    int printPaths(GNode node) {
        process(node);
        printer.printList(paths);
        return paths.size();
    }


    private void paths(GNode node) {
        process(node);

    }

    private void process(GNode node) {
        int prevChild;
        if (nodes.get(node.getName()) == null) {
            prevChild = 0;
        } else {
            prevChild = nodes.get(node.getName());
        }
        nodes.put(node.getName(), prevChild);
        GNode[] childs = node.getChildren();

        if (childs.length == 0) {
            paths.add(new ArrayList(path));
            path.remove(path.size() - 1);
            nodes.put(prevNode.getName(), nodes.get(prevNode.getName()) + 1);
            paths(prevNode);
            return;
        }
        if (nodes.get(node.getName()) < childs.length) {
            if (path.size() == 0) {
                path.add(node);
            }
            path.add(childs[nodes.get(node.getName())]);
            prevNode = node;
            paths(childs[nodes.get(node.getName())]);
        } else if (path.size() > 1) {
            prevNode = path.get(path.size() - 2);
            path.remove(path.size() - 1);
            nodes.merge(valueOf(prevNode), 1, (a, b) -> a + b);
            paths(prevNode);
        }
    }
}