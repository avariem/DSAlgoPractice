/**
 You are given a string STR of length N. Your task is to remove all the vowels present in that string and
 print the modified string.
 */
package com.practice.strings;

public class RemoveVowels {

    public static String removeVowels(String str) {
        String vowels="AaEeIiOoUu";
        StringBuilder newString = new StringBuilder();
        for(int i =0;i<str.length();i++){
            if(vowels.indexOf(str.charAt(i)) == -1) {
                newString.append(str.charAt(i));
            }
        }
        return newString.toString();
    }
}
