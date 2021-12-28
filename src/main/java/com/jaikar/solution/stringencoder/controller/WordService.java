package com.jaikar.solution.stringencoder.controller;

import com.jaikar.solution.stringencoder.constraints.WordValidation;

import java.net.MalformedURLException;
import java.util.Random;

public class WordService {
    WordValidation wv = new WordValidation();

    /**
     * Returns a String encoded based on its decoded version
     * this String should match the regex [A-Za-z ], in other way
     * it will throw a MalformedUrlException.
     *
     * @param  phrase   the phrase to encode
     * @return          the image at the specified URL
     */
    protected String encodeString(String phrase) {
        try {
            if (!wv.checkIfWordMatchAZSpace(phrase)) {
                throw new MalformedURLException();
            }
            String switchedPhrase = "";
            for (int i = 0; i <= phrase.length() - 1; i++) {
                int charsForPhraseChar = generateInt(3, 0);
                while (charsForPhraseChar > 0) {
                    switchedPhrase += putRowSeparator(switchedPhrase) + generateRandomChar();
                    charsForPhraseChar -= 1;
                }
                switchedPhrase += putRowSeparator(switchedPhrase) +
                        phrase.charAt(i);
            }
            String result = switchArray(switchedPhrase.split("-"));
            return result.replaceAll(" ", "&nbsp;");
        } catch(MalformedURLException ex){
            return "The word should have only chars from a to Z and spaces";
        }
    }

    /**
     * Returns a String based on its encoded version
     *
     * @param  phrase  the phrase to decode
     * @return         the decoded phrase
     */
    protected String decodeString(String phrase){
        String[] rowsList = phrase.split("-");

        String switchedWord = switchArray(rowsList);

        String result = switchedWord.replaceAll("[^A-Za-z ]", "");
        return result;
    }

    /**
     * Returns a String separated by a dash
     * to be a representation for the end of
     * the rows.
     *
     * The rows of the String returned is the ones
     * who used to be the columns from the rowsList
     * String array.
     *
     * @param  rowsList List of String who share it size
     *                  among them at least until the last
     *                  item.
     * @return          a String with the rows from rowsList
     *                  as columns
     */
    private String switchArray(String[] rowsList){
        String switchedWord = "";
        for(int column = 0; column <= rowsList[0].length() - 1; column++){
            for(int row = 0; row <= rowsList.length - 1; row++){
                if(rowsList[row].length() - 1 >= column){
                    switchedWord += rowsList[row].charAt(column);
                }else{
                    switchedWord += generateRandomChar();
                }
            }
            switchedWord += "-";
        }
        return switchedWord;
    }

    private char generateRandomChar(){
        String charsDict = "(1)2=3$4'5/6!°¬7¿89¡";
        return charsDict.charAt(generateInt(charsDict.length() - 1, 0));
    }

    /**
     * Returns a dash when the String match with
     * the criteria of be a six multiple element
     *
     * @param  phrase   a String who require to be separated
     *                  by dashes every six chars
     * @return          a String of a dash if its size is a six
     *                  multiple, else returns an empty String
     */
    private String putRowSeparator(String phrase){
        int phraseLength = phrase.length() + 1;
        if(phraseLength % 6 == 0 && phraseLength > 1){
            return "-";
        }else{
            return "";
        }
    }

    private int generateInt(int max, int min){
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
