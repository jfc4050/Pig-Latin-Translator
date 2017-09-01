package com.company;

public class Word {

    private String word;
    private String wordAlphanumeric = ""; //word with special characters removed
    private String rearranged; //alphanumeric, rearranged according to vowel or consonant start
    private String savedSpecial = "";
    private String wordFinal; //special characters returned
    String wordFinalCapitalized;

    private int firstVowelIndex;

    private boolean startWithConsonant = false;
    private boolean startWithVowel = false;
    private boolean startsCapital = false;

    //CONSTRUCTOR
    Word(String wordIn) {
        this.word = wordIn;
    }

    public void wordProcessing() {
        checkCapitalization(); //checks if word is capitalized
        checkConsonantStart(); //checks if word starts with consonant
        extractSpecialChars(); //extracts special characters
        findVowels(); // find index values of vowels, determine if word starts with vowel
        chooseArrangement();
        //chooses processing path based on if the word starts with vowel or consonant
        returnSpecialChars(); //returns special characters removed by extractSpecialCharacters
        reCapitalize(); //if startsCapital, recapitalizes word
    }

    private void checkCapitalization() {
        //check to see if word is capitalized
        if (Character.isUpperCase(word.charAt(0))) {
            this.word = Character.toLowerCase(word.charAt(0)) + word.substring(1);
            startsCapital = true;
        }
        //word is now decapitalized
        //startsCapital is now functional
    }

    private void checkConsonantStart() {
        //check to see if word starts with consonant
        char[] consonants =
                {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z', 'W', 'Y'};
        for (char consonant : consonants) {
            if (Character.toUpperCase(word.charAt(0)) == consonant) {
                this.startWithConsonant = true;
            }
        }
    }

    private void extractSpecialChars() {
        //extract specialCharacters
        char[] specialCharacters = {',', '.', '!', '?'};
        String wordAlphanumeric = "";
        String specialCharsInWord = "";
        for (int i = 0; i < word.length(); i++) {
            boolean isSpecialChar = false;
            for (char specialChar : specialCharacters) {
                if (word.charAt(i) == specialChar) {
                    this.savedSpecial += specialChar;
                    isSpecialChar = true;
                }
            }
            if (!isSpecialChar) {
                this.wordAlphanumeric += word.charAt(i);
            }
        }
    }

    private void findVowels() {
        //look for index value of first vowel/check if startsWithVowel
        char[] vowels =
                {'A', 'E', 'I', 'O', 'U'};
        int i = 0;
        boolean foundVowel = false;
        while (i < word.length() && !foundVowel) {
            for (char vowel : vowels) {
//                System.out.println("word.charAt(i) = " + word.charAt(i) + " vowel = " + vowel);
                if (Character.toUpperCase(word.charAt(i)) == vowel) {
                    foundVowel = true;
                    this.firstVowelIndex = i;
                }
            }
            if (!foundVowel) {
                i++;
            }
        }
        if (firstVowelIndex == 0) {
            this.startWithVowel = true;
        }
    }

    private void chooseArrangement() {
        if(startWithConsonant) {
            this.rearranged = wordAlphanumeric.substring(firstVowelIndex) + wordAlphanumeric.substring(0, firstVowelIndex) + "a";
        }
        else if(startWithVowel){
            this.rearranged = wordAlphanumeric + "ay";
        }
        else {
            this.rearranged = wordAlphanumeric;
        }
    }

    private void returnSpecialChars(){
        this.wordFinal = rearranged + savedSpecial;
    }

    private void reCapitalize() {
        if (startsCapital) {
            this.wordFinalCapitalized = Character.toUpperCase(wordFinal.charAt(0)) + wordFinal.substring(1);
        }
        else if (!startsCapital){
            this.wordFinalCapitalized = wordFinal;
        }
    }

}
