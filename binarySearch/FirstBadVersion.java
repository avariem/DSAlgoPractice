/**
 You are a product manager and currently leading a team to develop a new product. Unfortunately,
 the latest version of your product fails the quality check. Since each version is developed based on the
 previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all
 the following ones to be bad.

 You are given an API bool isBadVersion(version) which returns whether version is bad.
 Implement a function to find the first bad version. You should minimize the number of calls to the API.

 Example 1:
 Input: n = 5, bad = 4
 Output: 4
 Explanation:
 call isBadVersion(3) -> false
 call isBadVersion(5) -> true
 call isBadVersion(4) -> true
 Then 4 is the first bad version.

 Example 2:
 Input: n = 1, bad = 1
 Output: 1


 Constraints:
 1 <= bad <= n <= 231 - 1
 */
package com.practice.binarySearch;

public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        int firstVersion = 1,
                lastVersion = n;
        int badVersion = 1;
        while(firstVersion <= lastVersion) {
            int middleVersion = firstVersion + (lastVersion - firstVersion) / 2;
            //This condition is because (firstVersion+lastVersion)/2 cause TimeLimitExceeded(TLE).
            //This happens for large numbers.
            if (isBadVersion(middleVersion)) {
                badVersion = middleVersion;
                lastVersion = middleVersion - 1;
            }
            else firstVersion = middleVersion + 1;
        }
        return badVersion;
    }
    /**
     * Note:
     REASON OF TLE :
     The value of mid switches between positive and negative signs. This will never stop, resulting in an
     infinite loop and hence TLE.

     WHY it behaves this way?
     In the second iteration, mathematically it should be
     (1063376696 + 2126753390) /2 = (3190130086) /2 = 1595065043
     but due to overflows of the integer range, it will be interpreted as
     (1063376696 + 2126753390) / 2 = (-1104837210) / 2 = -552418605

     So, After an overflow, the compiler starts again from the least limit of value (i.e. -2147483648 in
     integer case) and adds the remaining surplus value.
     here, 3190130086 - 2147483648 - 2147483648 = -1104837210.
     The limit has crossed twice here, followed by a division giving -552418605
     */

    /**
     * This is the method which will return whether the version is bad or not
     * Here it is hardcoded to false
     * @param n
     * @return
     */
    public static boolean isBadVersion(int n){
        return false;
    }
}
