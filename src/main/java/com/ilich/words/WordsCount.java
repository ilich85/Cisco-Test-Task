package com.ilich.words;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Objects.requireNonNull;

class WordsCount {

    Map<String, Integer> count(String path) {
        Map<String, Integer> map = new TreeMap<>();
        for (String w : requireNonNull(new Init().init(path))) {
            if (!w.equals("")) {
                map.merge(w, 1, (a, b) -> a + b);
            }
        }
        return map;
    }
}