/**
 Given an integer N, find its factorial.

 Example 1:

 Input: N = 5
 Output: 120
 Explanation : 5! = 1*2*3*4*5 = 120
 Hint : Number may be very large, beyound the capacity of int or long.

 */
package com.practice.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FactorialLargeNumber {

    public static void main(String[] args) {

        int res[] = new int[3000];
        res[0] = 1;
        int res_size = 1;
        for(int x =2; x<=1000;x++) {
            res_size = multiply(x, res, res_size);
        }
        for(int i=res_size-1;i>=0;i--){
            System.out.print(res[i]);
        }
    }

    private static int multiply(int x, int[] res, int res_size) {
        int carry =0;
        for(int i=0;i<res_size;i++) {
            int product = res[i] * x + carry;
            res[i] = product % 10;
            carry = product / 10;
        }
        while(carry!=0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }


	//Another Solution
    private static BigInteger factorial(int n) {
        BigInteger k = BigInteger.valueOf(1);
        for(int i = 2; i<=n;i++){
            k = k.multiply(BigInteger.valueOf(i));
        }
        return k;
    }
}
