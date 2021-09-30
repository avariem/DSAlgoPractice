/**
 Given an array having both positive and negative integers. The task is to compute the length of the
 largest subarray with sum 0.

 Example 1:

 Input:
 N = 8
 A[] = {15,-2,2,-8,1,7,10,23}
 Output: 5
 Explanation: The largest subarray with
 sum 0 will be -2 2 -8 1 7.

 */
package com.practice.arrays

import java.util.HashMap;

public class LargestSubArrayWith0Sum {

    //Brute-Force Approach
    int maxLen(int arr[], int n)
    {
        int maxlen =0;
        for(int i =0;i<n-1;i++){
            int sum = arr[i];
            for(int j=i+1;j<n;j++){
                sum = sum+arr[j];
                if(sum == 0){
                    maxlen = (j-i+1)>maxlen?(j-i+1):maxlen;
                }
            }
        }
        return maxlen;
    }

    //O(n) approach
    int maxLenOptimizes(int arr[], int n)
    {
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0;
        int max_len = 0; 
        for (int i = 0; i < arr.length; i++) {
			
            sum += arr[i];
			
            if (arr[i] == 0 && max_len == 0){
                max_len = 1;
			}

            if (sum == 0){
                max_len = i + 1; //For array like {-1,1,-1,1}
			}				

            Integer prev_i = hM.get(sum);
            if (prev_i != null){
                max_len = Math.max(max_len, i - prev_i);
			}
            else {
                hM.put(sum, i);
			}
        }

        return max_len;
    }
}
