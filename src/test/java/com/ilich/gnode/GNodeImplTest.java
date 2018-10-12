package com.ilich.gnode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GNodeImplTest {
    private GNode aNode;
    private GNode bNode;
    private GNode cNode;


    @Before
    public void setUp() throws Exception {
        aNode = new GNodeImpl("A");
        bNode = new GNodeImpl("B");
        cNode = new GNodeImpl("C");
        GNode dNode = new GNodeImpl("D");
        GNode eNode = new GNodeImpl("E");
        GNode fNode = new GNodeImpl("F");
        GNode gNode = new GNodeImpl("G");
        GNode hNode = new GNodeImpl("H");
        GNode iNode = new GNodeImpl("I");
        aNode.addChild(bNode);
        aNode.addChild(cNode);
        aNode.addChild(dNode);
        bNode.addChild(eNode);
        bNode.addChild(fNode);
        cNode.addChild(gNode);
        cNode.addChild(hNode);
        cNode.addChild(iNode);
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
    public void addChild() {
        aNode.addChild(new GNodeImpl("NEW"));
        assertEquals(4, aNode.getChildren().length);
    }

    @Test
    public void walkGraph() {
        assertEquals(3, bNode.walkGraph(bNode).size());

    }

    @Test
    public void paths() {
        assertEquals(3,cNode.paths(cNode).size());
    }
}