package com.ilich.words;

import java.util.Map;

public class WordsService {

    public void service(String fileName) {
        Map<String, Integer> map = new WordsCount().count(fileName);
        new WordsPrint().print(map);
    }
}