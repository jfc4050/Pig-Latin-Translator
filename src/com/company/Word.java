package com.company;

public class Word {

    String word;
    String wordAlphanumeric = ""; //word with special characters removed
    String rearranged; //alphanumeric, rearranged according to vowel or consonant start
    String savedSpecial = "";
    String wordFinal; //special characters returned
    String wordFinalCapitalized;
    int firstVowel;
    boolean startWithConsonant = false;
    boolean startWithVowel = false;
    boolean startsCapital = false;

    //CONSTRUCTOR
    Word(String wordIn) {
        this.word = wordIn;

        //check to see if word is capitalized
        if (Character.isUpperCase(word.charAt(0))) {
            this.word = Character.toLowerCase(word.charAt(0)) + word.substring(1);
            startsCapital = true;
        }
        //word is now decapitalized

        //check to see if word starts with consonant
        char[] consonants =
                {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Z', 'W', 'Y'};
        for (char consonant : consonants) {
            if (Character.toUpperCase(word.charAt(0)) == consonant) {
                this.startWithConsonant = true;
            }
        }

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
                    this.firstVowel = i;
                }
            }
            if (!foundVowel) {
                i++;
            }
        }
        if (firstVowel == 0) {
            this.startWithVowel = true;
        }
    }

    public void chooseArrangement() {
        if(startWithConsonant) {
            this.rearranged = wordAlphanumeric.substring(firstVowel) + wordAlphanumeric.substring(0, firstVowel) + "a";
        }
        else if(startWithVowel){
            this.rearranged = wordAlphanumeric + "ay";
        }
        else {
            this.rearranged = wordAlphanumeric;
        }
    }

    public void returnSpecialChars(){
        this.wordFinal = rearranged + savedSpecial;
    }

    public void reCapitalize() {
        if (startsCapital) {
            this.wordFinalCapitalized = Character.toUpperCase(wordFinal.charAt(0)) + wordFinal.substring(1);
        }
        else if (!startsCapital){
            this.wordFinalCapitalized = wordFinal;
        }
    }

}
