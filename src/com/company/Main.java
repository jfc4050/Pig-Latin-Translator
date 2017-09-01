package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	String filePath = "/Users/justin/Documents/IntelliJ IDEA Projects/Pig Latin Translator/Text Files/cleancode.txt";
        try {
            //read and create array of words
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String text = br.readLine();
            String[] words = text.split(" ");

            for (String word : words) {
                String wordOut;
                Word newWord = new Word(word);

                newWord.chooseArrangement();
                newWord.returnSpecialChars();
                newWord.reCapitalize();
                System.out.print(newWord.wordFinalCapitalized + " ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
