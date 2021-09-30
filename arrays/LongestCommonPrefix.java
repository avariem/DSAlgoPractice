/**
 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:
 Input: strs = ["flower","flow","flight"]
 Output: "fl"

 Example 2:
 Input: strs = ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.

 Example 3:
 Input: strs = ["a"]
 Output: "a"

 */
package com.practice.arrays;

import java.util.Arrays;

public class LongestCommonPrefix {

    //First Solution O(n^2)
    public static String longestCommonPrefix(String[] strs) {

        String firstString = strs[0];
        int len = firstString.length();

        for(int i=0;i<len;i++){
            boolean isPresent = true;
            String temp = firstString.substring(0,len-i);

            for(String str : strs){
                if(str.indexOf(temp)!=0){
                    isPresent = false;
                    break;
                }
            }
            if(isPresent)
                return temp;
        }
        return "";
    }

    //Optimized Solution O(nlogn)
    public String longestCommonPrefix2(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        for(int i = 0; i < str1.length() && i < str2.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
            }else{
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
