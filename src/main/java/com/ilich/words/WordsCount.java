package com.ilich.words;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class WordsCount {

    Map<String, Integer> count(List<String>words) {
        Map<String, Integer> map = new TreeMap<>();
        for (String w : words) {
            if (!w.equals("")) {
                map.merge(w, 1, (a, b) -> a + b);
            }
        }
        return map;
    }
}