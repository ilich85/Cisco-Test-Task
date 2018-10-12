package com.ilich.gnode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GNodeImpl implements GNode {

    private String name;
    private GNode prevNode;
    private GNode[] children;
    private List<GNode> list = new ArrayList<>();
    private List<GNode> path = new ArrayList<>();
    private ArrayList<List> paths = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();


    GNodeImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public GNode[] getChildren() {
        return children;
    }

    @Override
    public void addChild(GNode child) {
        list.add(child);
        children = new GNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            children[i] = list.get(i);
        }
    }

    @Override
    public ArrayList paths(GNode node) {
        int prevChild;
        if (map.get(node.getName()) == null) {
            prevChild = 0;
        } else {
            prevChild = map.get(node.getName());
        }
        map.put(node.getName(), prevChild);
        GNode[] childs = node.getChildren();

        if (childs == null) {
            paths.add(new ArrayList(path));
            path.remove(path.size() - 1);
            map.put(prevNode.getName(), map.get(prevNode.getName()) + 1);
            return paths(prevNode);
        }
        if (map.get(node.getName()) < childs.length) {
            if (path.size() == 0) {
                path.add(node);
            }
            path.add(childs[map.get(node.getName())]);
            prevNode = node;
            return paths(childs[map.get(node.getName())]);
        } else if (path.size() > 1) {
            prevNode = path.get(path.size() - 2);
            path.remove(path.size() - 1);
            map.put(prevNode.getName(), map.get(prevNode.getName()+1));
            return paths(prevNode);
        }
        return paths;
    }

    @Override
    public ArrayList walkGraph(GNode gNode) {
        paths(gNode);
        return new ArrayList(map.keySet());
    }

    @Override
    public String toString() {
        return name;
    }
}