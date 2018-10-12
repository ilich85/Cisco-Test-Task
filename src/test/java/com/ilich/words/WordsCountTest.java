package com.ilich.words;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordsCountTest {

    @Test
    public void wordCount() {
        assertEquals(88, WordsCount.wordCount("text.txt", "the"));
    }
}