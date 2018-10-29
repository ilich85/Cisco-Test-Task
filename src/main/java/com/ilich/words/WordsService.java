package com.ilich.words;

import java.util.Map;

public class WordsService {

    public void service(String fileName) {
        Map<String, Integer> map = new WordsCount().count(new Init().wordsList(fileName));
        new WordsPrint().print(map);
    }
}