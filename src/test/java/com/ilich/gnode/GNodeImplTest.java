package com.ilich.gnode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GNodeImplTest {

    private GNodeImpl aNode;
    private GNodeAddChild addChild;
    private GNodeProcess process;

    @Before
    public void setUp() {
        addChild = new GNodeAddChild();
        process = new GNodeProcess();
        aNode = new GNodeImpl("A");
        GNodeImpl bNode = new GNodeImpl("B");
        GNodeImpl cNode = new GNodeImpl("C");
        GNodeImpl dNode = new GNodeImpl("D");
        GNodeImpl eNode = new GNodeImpl("E");
        GNodeImpl fNode = new GNodeImpl("F");
        GNodeImpl gNode = new GNodeImpl("G");
        GNodeImpl hNode = new GNodeImpl("H");
        GNodeImpl iNode = new GNodeImpl("I");

        addChild.add(aNode, bNode);
        addChild.add(aNode, cNode);
        addChild.add(aNode, dNode);
        addChild.add(bNode, eNode);
        addChild.add(bNode, fNode);
        addChild.add(cNode, gNode);
        addChild.add(cNode, hNode);
        addChild.add(cNode, iNode);
    }

    @Test
    public void getName() {
        assertEquals("A", aNode.getName());
    }

    @Test
    public void getChildren() {
        assertEquals(3, aNode.getChildren().length);
    }

    @Test
    public void add() {
        addChild.add(aNode, new GNodeImpl("NEW"));
        assertEquals(4, aNode.getChildren().length);
    }

    @Test
    public void walkGraph() {
        assertEquals(9, process.walkGraph(aNode).size());
    }

    @Test
    public void paths() {
        assertEquals(6, process.paths(aNode).size());
    }
}