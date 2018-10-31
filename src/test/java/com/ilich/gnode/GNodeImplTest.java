package com.ilich.gnode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GNodeImplTest {

    private GNodeImpl aNode;
    private GNodeProcess process;

    @Before
    public void setUp() {
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

        aNode.add(bNode);
        aNode.add(cNode);
        aNode.add(dNode);
        bNode.add(eNode);
        bNode.add(fNode);
        cNode.add(gNode);
        cNode.add(hNode);
        cNode.add(iNode);
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
        aNode.add(new GNodeImpl("NEW"));
        assertEquals(4, aNode.getChildren().length);
    }

    @Test
    public void walkGraph() {
        assertEquals(9, process.printNodes(aNode));
    }

    @Test
    public void paths() {
        assertEquals(6, process.printPaths(aNode));
    }
}