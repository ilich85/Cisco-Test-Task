package com.ilich.gnode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

class GNodeProcess {

    private GNode prevNode;
    private List<GNode> path = new ArrayList<>();
    private List<ArrayList> paths = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    Map<String, Integer> walkGraph(GNode node) {
        process(node);
        return map;
    }

    List<ArrayList> paths(GNode node) {
        process(node);
        return paths;
    }

    private void process(GNode node) {
        int prevChild;
        if (map.get(node.getName()) == null) {
            prevChild = 0;
        } else {
            prevChild = map.get(node.getName());
        }
        map.put(node.getName(), prevChild);
        GNode[] childs = node.getChildren();

        if (childs.length == 0) {
            paths.add(new ArrayList(path));
            path.remove(path.size() - 1);
            map.put(prevNode.getName(), map.get(prevNode.getName()) + 1);
            paths(prevNode);
            return;
        }
        if (map.get(node.getName()) < childs.length) {
            if (path.size() == 0) {
                path.add(node);
            }
            path.add(childs[map.get(node.getName())]);
            prevNode = node;
            paths(childs[map.get(node.getName())]);
        } else if (path.size() > 1) {
            prevNode = path.get(path.size() - 2);
            path.remove(path.size() - 1);
            map.merge(valueOf(prevNode), 1, (a, b) -> a + b);
            paths(prevNode);
        }
    }
}