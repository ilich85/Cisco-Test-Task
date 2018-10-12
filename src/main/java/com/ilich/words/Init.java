package com.ilich.words;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Init {

    static List<String> initArray(String filename) {
        URL url = ClassLoader.getSystemResource(filename);
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(url.getFile())), Charset.forName("UTF-8")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace(",", " ")
                        .replace(".", " ")
                        .replace("!", " ")
                        .replace("?", " ")
                        .replace(";", " ")
                        .replace(":", " ")
                        .replace("-", " ");
                wordsList.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsList;
    }
}