/**
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.


Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false
 */
package com.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ContainsDuplicate {

    //One Solution
    public boolean containsDuplicate(int[] nums){
        int distinctCount = (int) Arrays.stream(nums).distinct().count();
        if(distinctCount!=nums.length){
            return true;
        }
        return false;
    }

    //Optimized Solution - 6ms
    public boolean containsDuplicates2(int[] nums){
        HashMap<Integer , Integer> hmap = new HashMap<>();

        //init hashmap
        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(nums[i]))
                return true;
            hmap.put(nums[i], 1);
        }

        return false;
    }
}
