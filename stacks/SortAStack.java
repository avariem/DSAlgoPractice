/**
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
*/

package com.practice.stacks;

import java.util.Stack;

public class SortAStack {

        public static Stack<Integer> sort(Stack<Integer> s)
        {
            Stack<Integer> temp1 = new Stack<>();
            Stack<Integer> temp2 = new Stack<>();
            do{
                if(temp1.isEmpty()){
                    temp1.push(s.pop());
                }else{
                    int t = s.pop();
                    while(!temp1.isEmpty() && temp1.peek()>t){
                        temp2.push(temp1.pop());
                    }
                    temp1.push(t);
                    while(!temp2.isEmpty()){
                        temp1.push(temp2.pop());
                    }

                }

            }while(!s.isEmpty());
            return temp1;
        }
}
