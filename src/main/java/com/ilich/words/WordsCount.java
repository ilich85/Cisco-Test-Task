package com.ilich.words;

import java.util.HashMap;
import java.util.Map;

class WordsCount {

    static int wordCount(String path, String word) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : Init.initArray(path)) {
            if (!w.equals("")) {
                map.merge(w, 1, (a, b) -> a + b);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " = " + entry.getValue());
            System.out.println();
        }
        return map.get(word);
    }
}