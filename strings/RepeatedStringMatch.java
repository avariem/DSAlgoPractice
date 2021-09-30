/**
Given two strings A and B, find the minimum number of times A has to be repeated such that B becomes a substring of the repeated A. If B cannot be a substring of A no matter how many times it is repeated, return -1.

Example 1:

Input: A = "abcd", B = "cdabcdab"
Output: 3
Explanation: After repeating A three times, 
we get "abcdabcdabcd".
Example 2:

Input: A = "aa", B = "a"
Output: 1
Explanation: B is already a substring of A.
*/

package com.practice.strings;

public class RepeatedStringMatch {

    public static int repeatedStringMatch(String a, String b){
        int lengthA = a.length();
        int lengthB = b.length();
        int count =1;
        if(a.contains(b)){
            return count;
        }
        String initialA = a;
        boolean found = false;
        while(lengthA < lengthB) {
            count++;
            a = a.concat(initialA);
            lengthA = a.length();
        }

        if(a.contains(b)){
            return count;
        }
        a =a.concat(initialA);
        if(a.contains(b)){
           count++;
           return count;
        }

        return -1;
    }
}
