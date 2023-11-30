package com.solvd.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.HashSet;


import java.io.*;
import java.util.List;

public class FileProcessor {

    public static void main(String[] args) throws URISyntaxException {
        //define the input file
        URL resource = FileProcessor.class.getClassLoader().getResource("input.txt");
        if (resource == null) {
            System.err.println("File not found!");
            return;
        }

        File inputFile = new File(resource.getFile());
        System.out.println(inputFile);
        try {
            //read all lines from the input file
            List<String> lines = FileUtils.readLines(inputFile, "UTF-8");

            //process the lines to get all words
            String text = String.join(" ", lines); //join lines into a single text
            String[] words = StringUtils.split(text, ' '); //split text into an array of words

            //calc number of unique words
            int uniqueWordCount = countUniqueWords(words);

            //Write the result to the same file
            FileUtils.write(inputFile, "\nnumber of unique words: " + uniqueWordCount, "UTF-8", true);
        } catch (IOException e) {
            //handle IO exception
            e.printStackTrace();//print the exception details to the console
        }
    }

    //helper method to count the number of unique words
    private static int countUniqueWords(String[] words) {
        //create a set to store the unique words
        Set<String> uniqueWords = new HashSet<>();

        //iterate through each word
        for (String word : words) {
            //check if the word is not blank
            if (StringUtils.isNoneBlank(word)) {
                //add the non-blank word to the set.
                uniqueWords.add(word);
            }
        }
        //return the size of the set, which reps the number of unique words
        return uniqueWords.size();
    }
}
