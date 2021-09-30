/**
 You are given an array arr[] of n integers and q queries in an array queries[] of length 2*q containing l,
 r pair for all q queries. You need to compute the following sum over q queries.
 Array is 1-Indexed.

 Example 1:
 Input: n = 4
 arr = {1, 2, 3, 4}
 q = 2
 queries = {1, 4, 2, 3}
 Output: 10 5
 Explaination: In the first query we need sum
 from 1 to 4 which is 1+2+3+4 = 10. In the
 second query we need sum from 2 to 3 which is
 2 + 3 = 5.

 */

package com.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class SumOfQueries {

    List<Integer> querySum(int n, int arr[], int q, int queries[])
    {
        List<Integer> finalSumList = new ArrayList<Integer>();
        int i=0;
        while(i<2*q){
            int startingIndex = queries[i++];
            int endingIndex = queries[i++];
            int sum = 0;
            while(startingIndex <= endingIndex){
                sum += arr[startingIndex-1];
                startingIndex++;
            }
            finalSumList.add(sum);
        }
        return finalSumList;
    }
}
