/**
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest
product, and return the product.
It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
package com.practice.arrays;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];

        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for(int i=1;i<n;i++){

            if(nums[i]<0){

                int temp = minProd;
                minProd = maxProd;
                maxProd = temp;
            }

            maxProd = Math.max(nums[i], nums[i]*maxProd);
            minProd = Math.min(nums[i], nums[i]*minProd);

            ans = Math.max(ans, maxProd);

        }
        return ans;
    }
}
