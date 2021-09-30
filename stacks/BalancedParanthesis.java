/**
 Repeated String Match
 Medium Accuracy: 49.96% Submissions: 12874 Points: 4
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

 Input: A = "bxkk", B = "xb"
 Output: 2

 Difficulty level - Medium
 */
package com.practice.stacks;

import java.util.Stack;

public class BalancedParanthesis {

    public static void main(String[] args) {
        System.out.println(balancedParanthsis("({[]})"));
    }

    static boolean balancedParanthsis(String s){
        Stack<Character> stk = new Stack<>();
        //Deque<Character> stack = new ArrayDeque<Character>(); //ArrayDeque is faster than stack
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('|| s.charAt(i) == '['||s.charAt(i) == '{'){
                stk.push(s.charAt(i));
            }else{
                switch (s.charAt(i)) {
                    case ')':
                        if (stk.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stk.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stk.pop() != '{') {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }
}
