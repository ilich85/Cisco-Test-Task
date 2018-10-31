package com.ilich.gnode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class GNodePrinter {

    void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();
    }

    void printList(List<ArrayList> list) {
        for (ArrayList l : list) {
                System.out.print(l);
        }
        System.out.println();
    }
}