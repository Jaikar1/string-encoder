package com.jaikar.solution.stringencoder.constraints;

public class WordValidation {
    /**
     * Returns a boolean answer checking if word match with
     * the [^A-Za-z ] regex pattern
     *
     * @param  word the word to check
     * @return      true if word match with regex, else will return false
     */
    public boolean checkIfWordMatchAZSpace(String word){
        String regexAppliedWord = word.replaceAll("[^A-Za-z ]", "");
        return word == regexAppliedWord;
    }
}
