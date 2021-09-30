/**
Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
Opening parenthesis must be closed in the correct order.
Example 1:

Input: S = ((()
Output: 2
Explaination: The longest valid 
parenthesis substring is "()".
Example 2:

Input: S = )()())
Output: 4
Explaination: The longest valid 
parenthesis substring is "()()".
*/
package com.practice.stacks;

import java.util.Deque;
import java.util.Stack;

public class LongestValidParenthesis {

    static int findMaxLen(String str){
        int n = str.length();
        int result =0;
        Stack<Integer> stk= new Stack<>();
        stk.push(-1);
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='('){
                stk.push(i);
            }else{
                if(!stk.isEmpty()){
                    stk.pop();
                }
                if(!stk.isEmpty()){
                    result = Math.max(result,i-stk.peek());
                }else{
                    stk.push(i);
                }
            }
        }
        return result;
    }

}
