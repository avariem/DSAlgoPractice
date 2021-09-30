/**
 Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
 Example 1:
 Input:
 N = 5
 arr[]= {0 2 1 2 0}
 Output:
 0 0 1 2 2
 Explanation:
 0s 1s and 2s are segregated
 into ascending order.
 */
package com.practice.arrays;

public class DutchNationalFlag {

    public void sort(int[] array, int n){
        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid<=high){
            if(array[mid] == 0){
                swap(array, array[low],array[mid]);
                low++;
                mid++;
            }else if(array[mid] == 1){
                mid++;
            }else if(array[mid] == 2){
                swap(array,array[high],array[mid]);
                high --;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
