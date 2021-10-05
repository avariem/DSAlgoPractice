/**
 Given an array, rotate the array to the right by k steps, where k is non-negative.

 Example 1:
 Input: nums = [1,2,3,4,5,6,7], k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
package com.practice.twoPointers;

public class RotateArray {

    //0(1) time complexity.
    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k %=n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    //O(n) space complexity because of extra array
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        k = k%n;
        for(int i=0;i<n;i++){
            if(i+k<n){
                temp[i+k] = nums[i];
            }else{
                temp[i+k-n] = nums[i];
            }
        }
        for(int i=0;i<n;i++){
            nums[i] = temp[i];
        }

    }
}
