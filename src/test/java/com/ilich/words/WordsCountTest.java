package com.ilich.words;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordsCountTest {
    private WordsCount wordsCount;
    private Init init;

    @Before
    public void setUp() {
        wordsCount = new WordsCount();
        init = new Init();
    }

    @Test
    public void wordCount() {
        assertEquals(5, wordsCount.count(init.wordsList("./src/main/resources/words.txt")).size());
    }

    @Test
    public void emptyFile() {
        assertEquals(0, wordsCount.count(init.wordsList("./src/main/resources/empty.txt")).size());
    }

    @Test(expected = NullPointerException.class)
    public void noSuchFile() {
        wordsCount.count(init.wordsList(".src/main/imagine/path.txt"));
    }
}