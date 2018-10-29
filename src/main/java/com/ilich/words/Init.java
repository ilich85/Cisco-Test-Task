package com.ilich.words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Init {

    List<String> wordsList(String filename) {
        List<String> words = new ArrayList<>();
        try {
            Files.lines(Paths.get(filename)).forEach(
                    s -> words.addAll(Arrays.asList(s.split("[-,.!?();:'\" ]"))));
        } catch (IOException e) {
            return null;
        }
        return words;
    }
}