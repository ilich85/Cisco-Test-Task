package com.ilich.words;

import java.util.Map;

class WordsPrint {

    void print(final Map<String, Integer> map) {
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " = " + m.getValue());
        }
    }
}